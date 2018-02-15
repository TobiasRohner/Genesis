import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;

import Features.operations.HumanConfirmableOperation;
import Features.operations.actions.AHumanConfirmableAction;
import Features.operations.actions.BringOwnCupAction;
import Utilities.StoreDatabase;
import tests.Address;
import tests.DummyRepo;

/**
 * Created by Tobias on 15.02.2018.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        // Add a store to the store database with index 0x0000000000000000
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(512);
        KeyPair kp = kpg.generateKeyPair();
        StoreDatabase.getInstance().addStore(0x0000000000000000, kp.getPublic());

        // Create a new instance of a HumanConfirmableOperation to test it
        DummyRepo repo = new DummyRepo();
        HumanConfirmableOperation hco = new HumanConfirmableOperation(repo);

        // Get an action from the operation object (At the moment, we know its a BringOwnCupAction
        BringOwnCupAction action = (BringOwnCupAction) hco.getNextAction();
        System.out.println(action.getDescription());

        // Just invent some random customer_address
        Address address = new Address(0x0000000000000000);
        action.setCustomerAddress(address);
        // Set the store id to 0x0000000000000000, as it is the only registered store
        action.setStoreID(0x0000000000000000);
    }

}
