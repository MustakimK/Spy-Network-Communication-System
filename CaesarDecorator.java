/**
 * The CaesarDecorator class is a decorator for objects that implement the Cypher interface.
 * It follows the Decorator Pattern to extend the functionality of Cypher objects dynamically.
 * This class adds a layer of Caesar cypher encryption on top of the existing encryption method
 * provided by the decorated cypher object. It modifies the standard encryption and decryption
 * processes by applying a Caesar cypher shift to the characters of the input message, using a
 * specified key. This allows for more complex and layered encryption strategies while adhering
 * to the open/closed principle, as new behavior is added without modifying existing code.
 */
public class CaesarDecorator extends CypherDecorator {

    // Static final variable for the alphabet, using uppercase for constants
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public CaesarDecorator(Cypher decoratedCypher) {
        super(decoratedCypher);
    }

    // Encrypts the message by first using the decorated cipher, then applying the Caesar cipher
    @Override
    public String encrypt(String msg, int key) {
        // Display the original message before encryption
        System.out.println("Original Message for Encryption: " + msg);

        // Encrypt using the decorated cipher
        msg = super.encrypt(msg, key);

        // Apply the Caesar cipher
        msg = msg.toLowerCase();
        StringBuilder encryptedString = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int charPosition = ALPHABET.indexOf(msg.charAt(i));
            int encryptedCharIndex = Math.floorMod(charPosition + key, ALPHABET.length());
            encryptedString.append(ALPHABET.charAt(encryptedCharIndex));
        }

        // Display the encrypted message
        System.out.println("Encrypted Message: " + encryptedString);
        return encryptedString.toString();
    }

    // Decrypts the message by first using the decorated cipher, then applying the Caesar cipher
    @Override
    public String decrypt(String msg, int key) {
        // Display the encrypted message before decryption
        System.out.println("Encrypted Message for Decryption: " + msg);

        // Decrypt using the decorated cipher
        msg = super.decrypt(msg, key);

        // Apply the Caesar cipher for decryption
        msg = msg.toLowerCase();
        StringBuilder decryptedString = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int charPosition = ALPHABET.indexOf(msg.charAt(i));
            int decryptedCharIndex = Math.floorMod(charPosition - key, ALPHABET.length());
            decryptedString.append(ALPHABET.charAt(decryptedCharIndex));
        }

        // Display the decrypted message
        System.out.println("Decrypted Message: " + decryptedString);
        return decryptedString.toString().replace('z', ' ');
    }
}
