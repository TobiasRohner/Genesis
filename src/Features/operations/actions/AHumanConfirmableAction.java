package Features.operations.actions;

import Token.IToken;
import Utilities.IAddress;

/**
 * Created by Tobias on 15.02.2018.
 */

public abstract class AHumanConfirmableAction implements IAction {

    protected String description;
    protected IAddress customer_address;
    protected int reward;

    public AHumanConfirmableAction() {
        // Nothing to do here
    }

    public AHumanConfirmableAction(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public IAddress getCustomerAddress() { return customer_address; }
    public void setCustomerAddress(IAddress address) { customer_address = address; }
    public int getReward() { return reward; }
    public void setReward(int reward) { this.reward = reward; }

}
