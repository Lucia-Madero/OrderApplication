package com.switchfully.orderapplication.domain.email;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table (name = "email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column (name = "username")
    private String username;

    @Column (name = "domain")
    private String domain;

    public Email(String username, String domain) {
        this.username = username;
        this.domain = domain;
    }

    // Required by Hibernate
    public Email() {

    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return username + "@" + domain ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return username.equals(email.username) && domain.equals(email.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, domain);
    }
}
