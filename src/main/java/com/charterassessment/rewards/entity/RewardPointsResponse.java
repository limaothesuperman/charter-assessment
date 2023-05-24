package com.charterassessment.rewards.entity;

import java.util.Map;

public class RewardPointsResponse {

    private String customerId;
    private String name;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;

    /**
     * Constructs a RewardPointsResponse object with the given customer ID, name, monthly points, and total points.
     *
     * @param customerId    The ID of the customer.
     * @param name          The name of the customer.
     * @param monthlyPoints The map of monthly points, where the key represents the month (as a string) and the value represents the points earned.
     * @param totalPoints   The total points earned by the customer.
     */
    public RewardPointsResponse(String customerId, String name, Map<String, Integer> monthlyPoints, int totalPoints) {
        this.customerId = customerId;
        this.name = name;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    /**
     * Default constructor for the RewardPointsResponse class.
     */
    public RewardPointsResponse() {
    }

    /**
     * Retrieves the customer ID.
     *
     * @return The customer ID.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID.
     *
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
     * @param name The name of the customer to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the map of monthly points.
     *
     * @return The map of monthly points, where the key represents the month and the value represents the points earned.
     */
    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    /**
     * Sets the map of monthly points.
     *
     * @param monthlyPoints The map of monthly points to set, where the key represents the month and the value represents the points earned.
     */
    public void setMonthlyPoints(Map<String, Integer> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    /**
     * Retrieves the total points earned by the customer.
     *
     * @return The total points earned.
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Sets the total points earned by the customer.
     *
     * @param totalPoints The total points earned to set.
     */
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
