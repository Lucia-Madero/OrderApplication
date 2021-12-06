package com.switchfully.orderapplication.domain;

import java.util.Objects;

public class PhoneNumber {

    private final String prefix;
    private final String number;

    public PhoneNumber(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return prefix.equals(that.prefix) && number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, number);
    }
}
