package com.example.rewards.entity;

import java.util.Map;

public class RewardPointsResponse {

    private String customerId;
    private String name;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;

    public RewardPointsResponse(String customerId, String name, Map<String, Integer> monthlyPoints, int totalPoints) {
        this.customerId = customerId;
        this.name = name;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    public RewardPointsResponse() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    public void setMonthlyPoints(Map<String, Integer> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
