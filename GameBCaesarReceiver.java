/**
 * Project: Space Game - Caesar Cipher, HMAC/SHA256 Hash
 * Purpose Details: Game B Caesar Receiver
 * Course: IST 242
 * Author: Abdullah Koro
 * Date Developed: 6/10/24
 * Last Date Changed: 6/16/24
 * Revision: 1
 */

public class GameBCaesarReceiver
{

    /**
     * Decrypts the given encrypted text using Caesar Cipher with the specified shift value
     *
     * @param encryptedText The text to be decrypted
     * @param shift The shift value used for decryption
     * @return The decrypted text
     */
    public static String decrypt(String encryptedText, int shift)
    {
        StringBuilder decryptedText = new StringBuilder();

        for (char character : encryptedText.toCharArray())
        {
            if (Character.isLetter(character))
            {
                char base = Character.isLowerCase(character) ? 'a' : 'A';

                int originalAlphabetPosition = character - base;

                int newAlphabetPosition = (originalAlphabetPosition - shift + 26) % 26;

                char newCharacter = (char) (base + newAlphabetPosition);
                decryptedText.append(newCharacter);
            }
            else
            {
                decryptedText.append(character);
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args)
    {
        try

        {
            // Simulate receiving encrypted data from GameA
            String encryptedText = "Sohhdw|100";
            int shiftValue = 3;

            // Decrypt using Caesar Cipher
            String decryptedText = decrypt(encryptedText, shiftValue);

            // Split decrypted text into GameObject attributes

            String[] parts = decryptedText.split("\\|");

            String playerName = parts[0];

            int playerScore = Integer.parseInt(parts[1]);

            // Create GameObject instance
            GameObject gameObject = new GameObject(playerName, playerScore);

            // Print decrypted GameObject
            System.out.println("Decrypted GameObject: " + gameObject);
        }
        catch (Exception e)

        {
            e.printStackTrace();
        }
    }
}
