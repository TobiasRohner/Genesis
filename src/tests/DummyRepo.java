package tests;

import java.util.Collection;
import java.util.Map;

import Features.IFeature;
import Features.IOperation;
import Features.IUnderlying;
import Features.operations.IOperationProof;
import Features.operations.actions.IAction;
import Features.properties.IProperty;
import Repository.IRepository;
import Token.IToken;
import Utilities.IAddress;

/**
 * Created by Tobias on 15.02.2018.
 */


/**
 * This repo just contains mostly empty functions. Its functionality is not used by the actions except
 * for transferring money.
 */
public class DummyRepo implements IRepository {


    @Override
    public long store(IToken token) {
        return 0;
    }

    @Override
    public IToken fetchToken(long uniqueID) {
        return null;
    }

    @Override
    public Collection getAllTokens() {
        return null;
    }

    @Override
    public Collection<IOperation> getOperations(IToken token) {
        return null;
    }

    @Override
    public Collection<IUnderlying> getUnderlyings(IToken token) {
        return null;
    }

    @Override
    public Collection<IProperty> getProperties(IToken token) {
        return null;
    }

    @Override
    public Collection<IFeature> getFeatures(IToken token) {
        return null;
    }

    @Override
    public int getCurrentTotalSupply(IToken token) {
        return 0;
    }

    @Override
    public int getBalanceOf(IToken token, IAddress addr) {
        return 0;
    }

    @Override
    public Map<IAddress, Integer> getAllBalances(IToken token) {
        return null;
    }

    @Override
    public boolean store(IAction action, IOperationProof proof) {
        return true;
    }

    @Override
    public boolean contains(IAction action) {
        return false;
    }

    @Override
    public IToken crateNewToken(Collection collection) {
        return null;
    }
}
