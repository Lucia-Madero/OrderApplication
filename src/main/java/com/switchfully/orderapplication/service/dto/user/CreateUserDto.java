package com.switchfully.orderapplication.service.dto.user;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;
import com.switchfully.orderapplication.domain.user.User;

public class CreateUserDto {

    private String firstName;
    private String lastName;
    private Email email;
    private Address address;
    private PhoneNumber phoneNumber;
    private String username;
    private String password;
    private User.Role userRole;

    public CreateUserDto(String firstName, String lastName, Email email, Address address, PhoneNumber phoneNumber, String username, String password, User.Role userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public CreateUserDto setEmail(Email email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }


    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public User.Role getUserRole() {
        return userRole;
    }
    @Override
    public String toString() {
        return "CreateUserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email=" + email +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
                '}';
    }



}
