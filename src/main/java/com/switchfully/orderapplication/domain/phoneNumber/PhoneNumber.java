package com.switchfully.orderapplication.domain.phoneNumber;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table (name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    @Column (name = "prefix")
    private String prefix;

    @Column (name = "number")
    private String number;

    public PhoneNumber(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    // Required by Hibernate
    public PhoneNumber() {

    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
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
