package com.balch.builderpattern;

public class User {
    private final String firstName;
    private final String lastName;

    private String state;
    private String country;

    private User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder extends BaseBuilder<User> {

        public Builder(final String firstName, final String lastName) {
            super(new User(firstName, lastName));
        }

        public Builder state(String state) {
            this.data.state = state;
            return this;
        }

        public Builder country(String country) {
            this.data.country = country;
            return this;
        }

    }
}
