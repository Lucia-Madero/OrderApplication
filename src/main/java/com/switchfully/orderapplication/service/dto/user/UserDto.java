package com.switchfully.orderapplication.service.dto.user;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;
import com.switchfully.orderapplication.domain.user.User;

import java.util.Objects;
import java.util.UUID;

public class UserDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private Email email;
    private Address address;
    private PhoneNumber phoneNumber;
    private String username;
    private String password;
    private User.Role userRole;

    public UUID getId() {
        return id;
    }

    public UserDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public UserDto setEmail(Email email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public UserDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public UserDto setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public User.Role getUserRole() {
        return userRole;
    }

    public UserDto setUserRole(User.Role userRole) {
        this.userRole = userRole;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return getId().equals(userDto.getId()) && getFirstName().equals(userDto.getFirstName()) && getLastName().equals(userDto.getLastName()) && getEmail().equals(userDto.getEmail()) && getAddress().equals(userDto.getAddress()) && getPhoneNumber().equals(userDto.getPhoneNumber()) && getUsername().equals(userDto.getUsername()) && getPassword().equals(userDto.getPassword()) && getUserRole() == userDto.getUserRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getAddress(), getPhoneNumber(), getUsername(), getPassword(), getUserRole());
    }
}
