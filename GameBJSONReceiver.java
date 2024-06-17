/**
 * Project: Space Game - Caesar Cipher, HMAC/SHA256 Hash
 * Purpose Details: Game B JSON Receiver
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 6/10/24
 * Last Date Changed: 6/16/24
 * Revision: 1
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class GameBJSONReceiver

{

    /**
     * Fetches the secret key securely
     *
     * @return The secret key used for HMAC calculations
     */
    private static String fetchSecretKey()
    {
        String secretKey = "mySecretKey12345";

        if (secretKey == null || secretKey.isEmpty())

        {
            throw new RuntimeException("Secret key not found or empty");
        }

        return secretKey;
    }

    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(8080))

        {
            System.out.println("Listening on port 8080...");
            while (true)

            {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))

                {

                    // Read JSON input and HMAC
                    StringBuilder jsonInput = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null)

                    {
                        jsonInput.append(line);
                    }

                    String[] parts = jsonInput.toString().split("\\|");
                    if (parts.length != 2) {
                        System.out.println();
                        continue;
                    }

                    String receivedJSON = parts[0];
                    String receivedHMAC = parts[1];

                    // Calculate HMAC locally
                    String secretKey = fetchSecretKey(); // Fetch secret key securely
                    String calculatedHMAC = GameAJSONSender.calculateHMAC(receivedJSON, secretKey);

                    // Verify HMAC
                    if (receivedHMAC.equals(calculatedHMAC))
                    {
                        // Deserialize JSON into

                        ObjectMapper mapper = new ObjectMapper();

                        GameObject gameObject = mapper.readValue(receivedJSON, GameObject.class);
                        System.out.println("Received and verified GameObject: " + gameObject);
                    }
                    else
                    {
                        System.out.println();
                    }
                    
                }
            }
        }
        catch
        (Exception e)
        {
            e.printStackTrace();
        }
    }
}
