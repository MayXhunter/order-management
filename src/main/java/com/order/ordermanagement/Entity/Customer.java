package com.order.ordermanagement.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String bornAt;



    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBornAt() {
        return bornAt;
    }

    public void setBornAt(String bornAt) {
        this.bornAt = bornAt;
    }

    public Customer(Long id, String firstName, String lastName, String bornAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bornAt = bornAt;
    }
}

