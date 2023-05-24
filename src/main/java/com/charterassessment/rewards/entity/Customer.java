package com.charterassessment.rewards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    /**
     * Constructs a Customer object with the given ID and name.
     *
     * @param id   The ID of the customer.
     * @param name The name of the customer.
     */
    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Default constructor for the Customer class.
     */
    public Customer() {
    }

    /**
     * Retrieves the ID of the customer.
     *
     * @return The ID of the customer.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the ID of the customer.
     *
     * @param id The ID to set for the customer.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The name to set for the customer.
     */
    public void setName(String name) {
        this.name = name;
    }
}
