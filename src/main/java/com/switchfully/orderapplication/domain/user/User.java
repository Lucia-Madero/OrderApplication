package com.switchfully.orderapplication.domain.user;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;

import java.util.UUID;

public class User {

    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private Email email;

    private Address address;

    private PhoneNumber phoneNumber;

    public User(String firstName, String lastName, Email email, Address address, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }


    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }


    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public User setEmail(Email email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public User setAddress(Address address) {
        this.address = address;
        return this;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
