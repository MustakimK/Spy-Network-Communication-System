public class Runner {
    public static void main(String[] args) {

        // Initialize the home base, field base, spies, and cyphers
        Homebase homebase = Homebase.getInstance();
        Fieldbase testfb = new ConcreteFB();
        Spy testspy = new ConcreteSpy();
        Cypher caesar = new Caesar();
        Cypher caesar2 = new Caesar2();

        // Register field base and spy with the home base
        testfb.registerWithHomebase(homebase);
        testspy.register(testfb);

        // Set the encryption strategy and key in home base and send messages
        homebase.setCypher(caesar);
        homebase.setKey(5);
        homebase.sendMessage("Test One", testfb);
        System.out.println("Fieldbase received: " + testfb.getMessage());

        homebase.sendMessage("Test Two", testspy);
        System.out.println("Spy received: " + testspy.getMessage());

        // Change the encryption strategy and key, then send more messages
        Cypher caesarDecorator = new CaesarDecorator(new Caesar2());
        homebase.setCypher(caesarDecorator);
        homebase.setKey(3);

        homebase.sendMessage("Test Three", testfb);
        System.out.println("Fieldbase received: " + testfb.getMessage());

        homebase.sendMessage("Test Four", testspy);
        System.out.println("Spy received: " + testspy.getMessage());

        // Unregister field base and deactivate spy
        testfb.unregisterWithHomebase();
        testspy.die();

        // Set a new encryption strategy and key, then send messages
        homebase.setCypher(caesar2);
        homebase.setKey(10);

        homebase.sendMessage("Test Five", testfb);
        System.out.println("Fieldbase received: " + testfb.getMessage());

        homebase.sendMessage("Test Six", testspy);
        System.out.println("Spy received: " + testspy.getMessage());

        // Attempt to register a deactivated spy
        testspy.register(testfb);
    }
}