package Features.operations.actions;

import Utilities.IAddress;

/**
 * Created by Tobias on 14.02.2018.
 */

public class BringOwnCupAction extends AHumanConfirmableAction {

    private long     store_id;

    public BringOwnCupAction() {
        super("Bring your own cup to a coffee shop.");
        this.reward = 1;
    }

    public BringOwnCupAction(IAddress customer_address, long store_id) {
        super("Bring your own cup to a coffee shop.");
        this.customer_address = customer_address;
        this.store_id = store_id;
        this.reward = 1;    // The reward for bringing the own cup should be 1 coin
    }

    public long getStoreID() { return store_id; }
    public void setStoreID(long id) { store_id = id; }

}
