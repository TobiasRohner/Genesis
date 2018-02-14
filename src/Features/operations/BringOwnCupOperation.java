package Features.operations;

import java.util.ArrayList;
import java.util.List;

import Features.operations.actions.BringOwnCupAction;
import Features.operations.actions.IAction;
import Repository.IRepository;
import Token.IToken;
import Utilities.IAddress;

/**
 * Created by Tobias on 14.02.2018.
 */

public class BringOwnCupOperation extends AOperation {

    public BringOwnCupOperation(IRepository repo) {
        super(repo);
    }

    public List<IAction> getActions() {
        //TODO: Implement
        return new ArrayList<IAction>();
    }

    public IAction getNextAction() {
        //TODO: Implement
        return new BringOwnCupAction(new IAddress() {
            @Override
            public long getAddress() {
                return 0;
            }
        }, 0);
    }

    public boolean write(IToken token, IClaim claim) {
        //TODO: Implement
        return false;
    }

    public void resetOperation() {
        //TODO: Implement
    }

    public boolean isSet() {
        //TODO: Implement
        return false;
    }

}
