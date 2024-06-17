/**
 * Project: Space Game - Caesar Cipher, HMAC/SHA256 Hash
 * Purpose Details: Game A Caesar Sender
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 6/10/24
 * Last Date Changed: 6/16/24
 * Revision: 1
 */

import java.util.Scanner;

public class GameACaesarSender

{

    /**
     * Encrypts a plaintext string using the Caesar Cipher with the given shift value
     *
     * @param plaintext The string to be encrypted
     * @param shift The number of positions to shift each character
     * @return The encrypted string
     */
    public static String encrypt(String plaintext, int shift)

    {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : plaintext.toCharArray())
        {
            if (Character.isLetter(character))
            {
                char base = Character.isLowerCase(character) ? 'a' : 'A';

                int originalAlphabetPosition = character - base;

                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;

                char newCharacter = (char) (base + newAlphabetPosition);

                encryptedText.append(newCharacter);
            }
            else

            {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        try

        {
            // Create a GameObject instance
            GameObject gameObject = new GameObject("Player1", 100);
            // Serialize GameObject to a flat-file format --- plaintext
            String plaintext = gameObject.getName() + "|" + gameObject.getScore();
            // Encrypt using Caesar Cipher
            int shiftValue = 3; // Example shift value

            String encryptedText = encrypt(plaintext, shiftValue);

            // Simulate sending encrypted data to GameB
            System.out.println("Sending encrypted data: " + encryptedText);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        {

        }
    }
}
