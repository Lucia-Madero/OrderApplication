package com.switchfully.orderapplication.domain.adress;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table (name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column (name = "streetname")
    private String streetName;

    @Column (name = "streetnumber")
    private String streetNumber;

    @Column (name = "postCode")
    private String postCode;

    @Column (name = "city")
    private String city;

    public Address(String streetName, String streetNumber, String postCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
    }

    // Required by Hibernate
    public Address() {

    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
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
