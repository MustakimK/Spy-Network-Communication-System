/**
 * The Fieldbase interface represents the field bases in the spy network.
 * It extends the Receiver interface, allowing it to receive messages.
 * It provides methods to manage updates from the home base, handle spies,
 * and maintain current encryption strategies.
 */
public interface Fieldbase extends Receiver {

    // Update the field base with the latest information from the home base
    void update();

    // Register the field base with a home base
    void registerWithHomebase(Homebase homebase);

    // Unregister the field base from the home base
    void unregisterWithHomebase();

    // Get the current encryption strategy (cypher) used by the field base
    Cypher getCypher();

    // Get the current key used for encryption/decryption
    int getKey();

    // Update all spies associated with this field base
    void updateSpies();

    // Register a spy to this field base
    void registerSpy(Spy spy);

    // Remove a spy from the field base, typically when a spy is no longer active
    void killSpy(Spy spy);
}
