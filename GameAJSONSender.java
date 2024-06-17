/**
 * Project: Space Game - Caesar Cipher, HMAC/SHA256 Hash
 * Purpose Details: Game A JSON Sender
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 6/10/24
 * Last Date Changed: 6/16/24
 * Revision: 1
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class GameAJSONSender

{

    /**
     * Calculates the HMAC for the given data using the specified key
     *
     * @param data The data to be hashed
     * @param key The secret key used for hashing
     * @return The HMAC value as a Base64 encoded string
     * @throws NoSuchAlgorithmException If the specified algorithm does not exist
     *
     * @throws InvalidKeyException If the given key is inappropriate for initializing the MAC
     */
    public static String calculateHMAC(String data, String key)
            throws NoSuchAlgorithmException, InvalidKeyException
    {
        String algorithm = "HmacSHA256";

        Mac mac = Mac.getInstance(algorithm);

        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        mac.init(secretKeySpec);

        byte[] hmacBytes = mac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hmacBytes);
    }

    public static void main(String[] args)
    {
        try
        {
            // Create a GameObject instance
            GameObject gameObject = new GameObject("Player1", 100);
            // Convert GameObject to JSON string
            ObjectMapper mapper = new ObjectMapper();

            String jsonInputString = mapper.writeValueAsString(gameObject);

            // Calculate HMAC
            String secretKey = "mySecretKey12345";
            String hmac = calculateHMAC(jsonInputString, secretKey);

            // Simulate sending JSON data and HMAC to GameB
            System.out.println("Sending JSON data: " + jsonInputString);
            System.out.println("Sending HMAC: " + hmac);
        } catch
        (Exception e)
        {
            e.printStackTrace();
        }
    }
}
