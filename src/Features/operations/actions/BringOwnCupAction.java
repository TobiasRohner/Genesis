package Features.operations.actions;

import Utilities.IAddress;

/**
 * Created by Tobias on 14.02.2018.
 */

public class BringOwnCupAction implements IAction {

    private IAddress customer_address;
    private long     store_id;

    public BringOwnCupAction(IAddress customer_address, long store_id) {
        this.customer_address = customer_address;
        this.store_id = store_id;
    }

    public IAddress getCustomerAddress() { return customer_address; }
    public long     getStoreID() { return store_id; }

    @Override
    public EActionType getType() { return EActionType.BRING_OWN_CUP; }

}
