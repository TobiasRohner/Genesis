package tests;

import Utilities.IAddress;

/**
 * Created by Tobias on 15.02.2018.
 */

public class Address implements IAddress {

    long address;

    public Address() {
        address = 0;
    }

    public Address(long address) {
        this.address = address;
    }

    @Override
    public long getAddress() {
        return address;
    }

    public void setAddress(long address) {
        this.address = address;
    }

}
