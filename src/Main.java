import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;

import Features.operations.HumanConfirmableOperation;
import Features.operations.actions.AHumanConfirmableAction;
import Utilities.StoreDatabase;
import tests.DummyRepo;

/**
 * Created by Tobias on 15.02.2018.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        // Add a store to the store database with index 0x00000000
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(512);
        KeyPair kp = kpg.generateKeyPair();
        StoreDatabase.getInstance().addStore(0x00000000, kp.getPublic());

        // Create a new instance of a HumanConfirmableOperation to test it
        DummyRepo repo = new DummyRepo();
        HumanConfirmableOperation hco = new HumanConfirmableOperation(repo);

        // Get an action from the operation object
        AHumanConfirmableAction action = (AHumanConfirmableAction)hco.getNextAction();
        System.out.println(action.getDescription());
    }

}
