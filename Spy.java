/**
 * The Spy interface extends the Receiver interface, representing the capabilities of a spy in the network.
 * It includes methods specific to a spy's operational requirements such as updating their status,
 * registering with a field base, and handling their termination (death) in the field.
 */
public interface Spy extends Receiver {

    /**
     * Updates the spy with the latest information or changes.
     */
    void update();

    /**
     * Registers the spy with a specified field base.
     * @param fieldbase The field base with which the spy is to register.
     */
    void register(Fieldbase fieldbase);

    /**
     * Handles the termination of the spy, typically when they are no longer active or compromised.
     */
    void die();
}