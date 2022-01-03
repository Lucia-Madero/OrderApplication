package com.switchfully.orderapplication.domain.user;

import com.switchfully.orderapplication.domain.adress.Address;
import com.switchfully.orderapplication.domain.email.Email;
import com.switchfully.orderapplication.domain.feature.Feature;
import com.switchfully.orderapplication.domain.phoneNumber.PhoneNumber;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table (name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column (name = "firstname" )
    private String firstName;

    @Column (name = "lastname")
    private String lastName;

    @JoinColumn (name = "fk_email")
    @OneToOne (cascade = {CascadeType.ALL})
    private Email email;

    @JoinColumn (name = "fk_address")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Address address;

    @JoinColumn (name = "fk_phone_number")
    @ManyToOne(cascade = {CascadeType.ALL})
    private PhoneNumber phoneNumber;

    @Column (name = "username")
    private String username;

    @Column (name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
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

    // Required by Hibernate
    public User() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getEmail().equals(user.getEmail()) && getAddress().equals(user.getAddress()) && getPhoneNumber().equals(user.getPhoneNumber()) && getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) && getUserRole() == user.getUserRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getAddress(), getPhoneNumber(), getUsername(), getPassword(), getUserRole());
    }
}
