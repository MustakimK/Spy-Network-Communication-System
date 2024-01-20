/**
 * Extends the Caesar cipher by using double the key value to shift letters.
 * Provides a slight twist on the classic encryption method.
 */
public class Caesar2 implements Cypher {

    // Define the alphabet used for the cipher
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Encrypts a message using a modified Caesar cipher with double key value for shifting
    public String encrypt(String msg, int key) {
        msg = msg.toLowerCase();
        StringBuilder encryptedString = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int charPosition = ALPHABET.indexOf(msg.charAt(i));
            // Modify the shift by using key*2 for encryption
            int shiftedPosition = Math.floorMod(charPosition + key * 2, ALPHABET.length());
            encryptedString.append(ALPHABET.charAt(shiftedPosition));
        }

        return encryptedString.toString();
    }

    // Decrypts a message using the modified Caesar cipher
    public String decrypt(String msg, int key) {
        msg = msg.toLowerCase();
        StringBuilder decryptedString = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int charPosition = ALPHABET.indexOf(msg.charAt(i));
            // Modify the shift by using key*2 for decryption
            int shiftedPosition = Math.floorMod(charPosition - key * 2, ALPHABET.length());
            decryptedString.append(ALPHABET.charAt(shiftedPosition));
        }

        // Replace 'z' with a space to maintain readability for decrypted text
        return decryptedString.toString().replace('z', ' ');
    }
}
