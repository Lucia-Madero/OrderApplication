package com.switchfully.orderapplication.domain;

import java.util.Objects;

public class Address {

    private final String streetName;
    private final String streetNumber;
    private final String postCode;
    private final String city;

    public Address(String streetName, String streetNumber, String postCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return streetName.equals(address.streetName) && streetNumber.equals(address.streetNumber) && postCode.equals(address.postCode) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, streetNumber, postCode, city);
    }
}
