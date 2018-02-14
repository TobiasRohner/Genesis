package Features.operations;

import java.security.Signature;

/**
 * Created by Tobias on 14.02.2018.
 */

public class BringOwnCupActionProof implements IActionProof {

    private byte[] signature_bytes;

    public BringOwnCupActionProof(byte[] signature_bytes) {
        this.signature_bytes = signature_bytes;
    }

    public byte[] getSignatureBytes() { return signature_bytes; }

}
