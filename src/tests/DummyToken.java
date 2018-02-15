package tests;

import java.util.Collection;
import java.util.Map;

import Features.operations.IClaim;
import Token.IToken;
import Utilities.IAddress;

/**
 * Created by Tobias on 15.02.2018.
 */

public class DummyToken implements IToken {

    @Override
    public long getUniqueID() {
        return 0;
    }

    @Override
    public String getName() {
        return "DummyToken";
    }

    @Override
    public int getDecimals() {
        return 10;
    }

    @Override
    public String getSymbol() {
        return "DTK";
    }

    @Override
    public int getTotalSupply() {
        return -1;
    }

    @Override
    public boolean isCapped() {
        return false;
    }

    @Override
    public boolean preMined() {
        return false;
    }

    @Override
    public int preMinedAmount() {
        return 0;
    }

    @Override
    public int cappedAmount() {
        return 0;
    }

    @Override
    public int getBalanceOf(IAddress addr) {
        return 0;
    }

    @Override
    public Map<IAddress, Integer> getAllBalances() {
        return null;
    }

    @Override
    public Collection getUnderlyings() {
        return null;
    }

    @Override
    public Collection getProperties() {
        return null;
    }

    @Override
    public Collection getOperations() {
        return null;
    }

    @Override
    public boolean addClaim(IClaim claim) {
        return false;
    }

}
