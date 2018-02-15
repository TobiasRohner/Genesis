import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

import Features.operations.HumanConfirmableActionProof;
import Features.operations.HumanConfirmableClaim;
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
        System.out.print("Action: ");
        System.out.println(action.getDescription());

        // Just invent some random customer_address
        Address address = new Address(0x0000000000000000);
        action.setCustomerAddress(address);
        // Set the store id to 0x0000000000000000, as it is the only registered store
        action.setStoreID(0x0000000000000000);

        // Get a proof that we have done the action
        byte[] signature = sign(action, kp.getPrivate());
        System.out.print("Signature: ");
        System.out.println(signature);
        HumanConfirmableActionProof proof = new HumanConfirmableActionProof(signature);

        // Claim that we have done the action
        HumanConfirmableClaim claim = new HumanConfirmableClaim(action, proof);

        // Send the claim to the operation object to get the reward
        //TODO: Implement
    }

    // Helper function to sign human readable actions
    private static byte[] sign(AHumanConfirmableAction action, PrivateKey private_key) throws Exception {
        Signature signature = Signature.getInstance("DSA");
        signature.initSign(private_key);
        int hash = action.hashCode();
        for (int i = 0 ; i < 4 ; ++i)
            signature.update((byte)(hash >> 8*i));
        return signature.sign();
    }

}
