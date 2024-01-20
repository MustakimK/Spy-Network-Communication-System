import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteFB represents a concrete field base in the spy network.
 * It manages the spies, communicates with the home base, and handles encryption tasks.
 */
public class ConcreteFB implements Fieldbase {

    private String message = "";
    private Cypher cypher;
    private int key = 0;
    private Homebase homebase;
    private List<Spy> spies = new ArrayList<>();
    private List<Spy> deadSpies = new ArrayList<>();

    // Registers this field base with a home base and updates its cypher and key
    public void registerWithHomebase(Homebase newHomebase){
        this.homebase = newHomebase;
        homebase.registerFB(this);
        update();
    }

    // Unregisters this field base from the home base
    public void unregisterWithHomebase() {
        homebase.unregisterFB(this);
    }

    // Updates this field base's encryption settings and updates all spies
    public void update() {
        this.cypher = homebase.getCypher();
        this.key = homebase.getKey();
        updateSpies();
    }

    // Returns the current encryption cypher
    public Cypher getCypher(){
        return this.cypher;
    }

    // Returns the current encryption/decryption key
    public int getKey(){
        return this.key;
    }

    // Registers a new spy unless they are marked as dead
    public void registerSpy(Spy newSpy) {
        if (!deadSpies.contains(newSpy)) {
            spies.add(newSpy);
        } else {
            System.out.println("Attempted to add a spy who is no longer active.");
        }
    }

    // Marks a spy as dead and removes them from active duty
    public void killSpy(Spy deadSpy) {
        if (!deadSpies.contains(deadSpy)) {
            deadSpies.add(deadSpy);
            spies.remove(deadSpy);
        }
    }

    // Updates all active spies with the latest information
    public void updateSpies() {
        for (Spy spy : spies){
            spy.update();
        }
    }

    // Returns the last decrypted message
    public String getMessage(){
        return this.message;
    }

    // Encrypts and sends a message to another receiver
    @Override
    public void sendMessage(String msg, Receiver receiver) {
        msg = cypher.encrypt(msg, this.key);
        receiver.setMessage(msg);
    }

    // Decrypts and sets the message for this field base
    @Override
    public void setMessage(String encryptedMsg) {
        this.message = cypher.decrypt(encryptedMsg, this.key);
    }
}
