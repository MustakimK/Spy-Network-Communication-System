/**
 * Implements the Caesar cipher for encrypting and decrypting messages.
 * Shifts letters in the message by a set key value.
 */
public class Caesar implements Cypher {

    // Constant representing the English alphabet
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Encrypts a message using Caesar cipher
    public String encrypt(String msg, int key) {
        msg = msg.toLowerCase();
        StringBuilder encryptedString = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int charPosition = ALPHABET.indexOf(msg.charAt(i));
            int encryptedCharIndex = Math.floorMod(charPosition + key, ALPHABET.length());
            char encryptedChar = ALPHABET.charAt(encryptedCharIndex);
            encryptedString.append(encryptedChar);
        }

        return encryptedString.toString();
    }

    // Decrypts a message using Caesar cipher
    public String decrypt(String msg, int key) {
        msg = msg.toLowerCase();
        StringBuilder decryptedString = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int charPosition = ALPHABET.indexOf(msg.charAt(i));
            int decryptedCharIndex = Math.floorMod(charPosition - key, ALPHABET.length());
            char decryptedChar = ALPHABET.charAt(decryptedCharIndex);
            decryptedString.append(decryptedChar);
        }

        // Replace 'z' with space to handle non-alphabetic characters
        return decryptedString.toString().replace('z', ' ');
    }
}
