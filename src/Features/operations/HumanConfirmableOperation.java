package Features.operations;

import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

import Features.operations.actions.AHumanConfirmableAction;
import Features.operations.actions.BringOwnCupAction;
import Features.operations.actions.EActionType;
import Features.operations.actions.IAction;
import Repository.IRepository;
import Token.IToken;
import Utilities.StoreDatabase;

/**
 * Created by Tobias on 14.02.2018.
 */

public class HumanConfirmableOperation extends AOperation {

    public HumanConfirmableOperation(IRepository repo) {
        super(repo);
    }

    @Override
    public List<IAction> getActions() {
        List<IAction> returnList = new ArrayList();
        returnList.add(new BringOwnCupAction());
        return returnList;
    }

    @Override
    public IAction getNextAction() {
        return new BringOwnCupAction();
    }

    @Override
    public boolean write(IToken token, IClaim claim) {
        // Verify whether the claim is of the right type
        if(claim.getAction()==null)
            return false;
        if(!(claim.getAction() instanceof AHumanConfirmableAction))
            return false;
        AHumanConfirmableAction action = (AHumanConfirmableAction) claim.getAction();
        // Verify the proof for the claim
        boolean valid;
        try {
            // Currently we know the action is an instance of BringOwnCupAction
            // This may and will change in the future, so a distinction between those has to be mad
            switch (action.getType()) {
                case BRING_OWN_CUP:
                    valid = verifyClaim(claim,
                            StoreDatabase.getInstance().getPublicKey(((BringOwnCupAction)action).getStoreID()),
                            "DSA"); // Just use DSA for the moment
                    break;
                default:
                    return false;
            }
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
            return false;
        }
        if (!valid)
            return false;

        // Give the reward
        if (repo.store(claim.getAction(), null /*claim.getProof()*/)) {
            // Give the reward
            token.generate(action.getCustomerAddress(), action.getReward());
            //TODO: Implement reputation
            return true;
        }
        return false;
    }

    @Override
    public void resetOperation() {
        // Should be right to leave this empty
    }

    @Override
    public boolean isSet() {
        //TODO: Implement
        return false;
    }

    /**
     * @brief Verifying a given claim with its proof
     *
     * The proof for the claim should be a digital signature
     * on the hash of the action object.
     * The Signature object is updated with the least significant byte first
     *
     * @param claim The claim object to verify.
     * @param public_key The public key of the instance that signed the data
     * @param signature_algorithm The signature algorithm to be used
     * @return Whether the proof is valid or not
     */
    private boolean verifyClaim(IClaim claim,
                                PublicKey public_key,
                                String signature_algorithm) throws Exception {
        int hash = claim.getAction().hashCode();
        Signature signature = Signature.getInstance(signature_algorithm);
        signature.initVerify(public_key);
        for (int i = 0 ; i < 4 ; ++i) {
            signature.update((byte)(hash >> 8*i));
        }
        if (!(claim.getProof() instanceof HumanConfirmableActionProof))
            return false;
        HumanConfirmableActionProof proof = (HumanConfirmableActionProof)claim.getProof();
        return signature.verify(proof.getSignatureBytes());
    }

}
