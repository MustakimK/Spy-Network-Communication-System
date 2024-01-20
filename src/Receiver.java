/**
 * The Receiver interface defines the contract for classes that can receive and handle messages.
 * It includes methods for sending messages, setting a message, and retrieving the current message.
 * Classes implementing this interface can communicate with each other by sending and receiving messages.
 */
public interface Receiver {

    /**
     * Sends a message to another receiver.
     * @param msg The message to be sent.
     * @param receiver The receiver to whom the message should be sent.
     */
    void sendMessage(String msg, Receiver receiver);

    /**
     * Sets the message for the receiver.
     * @param msg The message to set.
     */
    void setMessage(String msg);

    /**
     * Retrieves the current message held by the receiver.
     * @return The current message.
     */
    String getMessage();
}
