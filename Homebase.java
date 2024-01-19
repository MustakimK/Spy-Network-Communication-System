import java.util.ArrayList;
import java.util.List;

/**
 * The Homebase class represents the central command in the spy network.
 * It is a singleton to ensure only one instance is used throughout the application.
 * It handles the encryption and decryption of messages using the assigned Cypher strategy.
 */
public class Homebase implements Receiver {

    // Instance variables for the Homebase class
    private String message = "";
    private final List<Fieldbase> fieldbases = new ArrayList<>();
    private Cypher cypher;
    private int key = 0;

    // Static instance for Singleton pattern
    private static final Homebase instance = new Homebase();

    // Private constructor to prevent instantiation
    private Homebase(){}

    // Static method to get the instance of the class
    public static Homebase getInstance(){
        return instance;
    }

    // Set the Cypher encryption strategy and update all fieldbases
    public void setCypher(Cypher newCypher) {
        this.cypher = newCypher;
        updateFieldbases();
    }

    // Set the encryption/decryption key and update all fieldbases
    public void setKey(int newKey){
        this.key = newKey;
        updateFieldbases();
    }

    // Get the current Cypher strategy
    public Cypher getCypher(){
        return this.cypher;
    }

    // Get the current key
    public int getKey(){
        return this.key;
    }

    // Register a new fieldbase to the network
    public void registerFB(Fieldbase newFieldbase){
        fieldbases.add(newFieldbase);
    }

    // Unregister a fieldbase from the network
    public void unregisterFB(Fieldbase fieldbaseToRemove){
        fieldbases.remove(fieldbaseToRemove);
    }

    // Notify all fieldbases of a change in encryption strategy or key
    private void updateFieldbases(){
        for (Fieldbase fieldbase : fieldbases){
            fieldbase.update();
        }
    }

    // Get the last decrypted message
    public String getMessage(){
        return this.message;
    }

    // Send an encrypted message to a receiver
    @Override
    public void sendMessage(String msg, Receiver receiver) {
        msg = cypher.encrypt(msg, this.key);
        receiver.setMessage(msg);
    }

    // Set the message after decrypting with the current key
    @Override
    public void setMessage(String msg){
        msg = cypher.decrypt(msg, this.key);
        this.message = msg;
    }
}
