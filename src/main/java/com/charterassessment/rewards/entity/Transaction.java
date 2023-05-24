package com.charterassessment.rewards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private double amount;
    private LocalDate transactionDate;

    /**
     * Constructs a Transaction object with the given ID, customer ID, amount, and transaction date.
     *
     * @param id              The ID of the transaction.
     * @param customerId      The ID of the customer associated with the transaction.
     * @param amount          The amount of the transaction.
     * @param transactionDate The date of the transaction.
     */
    public Transaction(Long id, Long customerId, double amount, LocalDate transactionDate) {
        this.id = id;
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    /**
     * Default constructor for the Transaction class.
     */
    public Transaction() {

    }

    /**
     * Retrieves the ID of the transaction.
     *
     * @return The ID of the transaction.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the transaction.
     *
     * @param id The ID to set for the transaction.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the customer ID associated with the transaction.
     *
     * @return The customer ID.
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID associated with the transaction.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Retrieves the amount of the transaction.
     *
     * @return The amount of the transaction.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the transaction.
     *
     * @param amount The amount to set for the transaction.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Retrieves the date of the transaction.
     *
     * @return The date of the transaction.
     */
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the date of the transaction.
     *
     * @param transactionDate The date to set for the transaction.
     */
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
