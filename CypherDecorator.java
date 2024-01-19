/**
 * The CypherDecorator class is an abstract decorator that implements the Cypher interface.
 * It follows the Decorator Pattern, allowing for dynamic addition of responsibilities to objects.
 * This class serves as a base for creating decorators that can augment the functionality
 * of Cypher implementations without modifying their existing code.
 */
public abstract class CypherDecorator implements Cypher {

    // The Cypher instance being decorated
    protected Cypher decoratedCypher;

    // Constructor for the decorator class
    public CypherDecorator(Cypher decoratedCypher){
        this.decoratedCypher = decoratedCypher;
    }

    // Delegates the encrypt call to the decorated Cypher instance
    @Override
    public String encrypt(String msg, int key) {
        return decoratedCypher.encrypt(msg, key);
    }

    // Delegates the decrypt call to the decorated Cypher instance
    @Override
    public String decrypt(String msg, int key) {
        return decoratedCypher.decrypt(msg, key);
    }
}