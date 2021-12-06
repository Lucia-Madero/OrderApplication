package com.switchfully.orderapplication.domain;

import java.util.Objects;

public class Email {

    private final String username;
    private final String domain;

    public Email(String username, String domain) {
        this.username = username;
        this.domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
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
