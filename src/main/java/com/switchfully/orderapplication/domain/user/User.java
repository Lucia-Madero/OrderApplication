package com.switchfully.orderapplication.domain.user;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.feature.Feature;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;

import java.util.List;
import java.util.UUID;

public class User {

    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private Email email;
    private Address address;
    private PhoneNumber phoneNumber;
    private final String username;
    private final String password;
    private Role userRole;

    public User(String firstName, String lastName, Email email, Address address, PhoneNumber phoneNumber, String username, String password, Role userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }


    public enum Role {
        ADMIN(List.of(Feature.ADD_ITEM,Feature.VIEW_ALL_CUSTOMERS, Feature.VIEW_SINGLE_CUSTOMER, Feature.UPDATE_ITEM)),
        CUSTOMER(List.of());

        private final List<Feature> featureList;

        Role(List<Feature> featureList) {
            this.featureList = featureList;
        }

        public boolean containsFeature(Feature feature) {
            return featureList.contains(feature);
        }
    }

    public boolean hasAccessTo(Feature feature) {
        return this.userRole.containsFeature(feature);
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Role getUserRole() {
        return userRole;
    }

    public User setUserRole(Role userRole) {
        this.userRole = userRole;
        return this;
    }
}
