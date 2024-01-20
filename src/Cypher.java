/**
 * The Cypher interface defines the structure for encryption and decryption algorithms.
 * Any class that implements this interface should provide concrete implementations
 * for both encrypt and decrypt methods, allowing for different encryption strategies.
 */
public interface Cypher {
    /**
     * Encrypts a given message using a specific key.
     * @param msg The message to be encrypted.
     * @param key The key used for encryption.
     * @return The encrypted message.
     */
    String encrypt(String msg, int key);

    /**
     * Decrypts a given message using a specific key.
     * @param msg The message to be decrypted.
     * @param key The key used for decryption.
     * @return The decrypted message.
     */
    String decrypt(String msg, int key);
}
