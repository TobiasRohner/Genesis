package Features.operations.actions;

import Utilities.IAddress;

/**
 * Created by Tobias on 14.02.2018.
 */

public class BringOwnCupAction extends AHumanConfirmableAction {

    private IAddress customer_address;
    private long     store_id;

    public BringOwnCupAction() {
        super("Bring your own cup to a coffee shop.");
    }

    public BringOwnCupAction(IAddress customer_address, long store_id) {
        this.customer_address = customer_address;
        this.store_id = store_id;
    }

    public IAddress getCustomerAddress() { return customer_address; }
    public void setCustomerAddress(IAddress address) { customer_address = address; }
    public long getStoreID() { return store_id; }
    public void setStoreID(long id) { store_id = id; }

}
