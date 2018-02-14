package Features.operations;

import java.security.Signature;

/**
 * Created by Tobias on 14.02.2018.
 */

public class BringOwnCupActionProof implements IActionProof {

    private Signature signature;

    public BringOwnCupActionProof(Signature signature) {
        this.signature = signature;
    }

    public Signature getSignature() { return signature; }

}
