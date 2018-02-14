package Features.operations;

import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

import Features.operations.actions.BringOwnCupAction;
import Features.operations.actions.IAction;
import Repository.IRepository;
import Token.IToken;

/**
 * Created by Tobias on 14.02.2018.
 */

public class BringOwnCupOperation extends AOperation {

    public BringOwnCupOperation(IRepository repo) {
        super(repo);
    }

    @Override
    public List<IAction> getActions() {
        //TODO: Implement
        return new ArrayList<IAction>();
    }

    @Override
    public IAction getNextAction() {
        //TODO: Implement
        return new BringOwnCupAction();
    }

    @Override
    public boolean write(IToken token, IClaim claim) {
        //TODO: Implement
        return false;
    }

    @Override
    public void resetOperation() {
        //TODO: Implement
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
        if (!(claim.getProof() instanceof BringOwnCupActionProof))
            return false;
        BringOwnCupActionProof proof = (BringOwnCupActionProof)claim.getProof();
        return signature.verify(proof.getSignatureBytes());
    }

}
