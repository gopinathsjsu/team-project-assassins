package com.assassins.assassin.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Booking {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String creditCard;

    public Booking(long id, String firstName, String lastName, String creditCard, short cvc) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCard = creditCard;
    }

    public Booking() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {this.id = id;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}