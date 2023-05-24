package com.charterassessment.rewards.service;

import com.charterassessment.rewards.entity.RewardPointsResponse;
import com.charterassessment.rewards.entity.Transaction;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface RewardPointsService {

    /**
     * Calculates the reward points for a specific customer and year-month.
     *
     * @param customerId The ID of the customer.
     * @param yearMonth  The YearMonth object representing the year and month.
     * @return The RewardPointsResponse object containing the calculated reward points.
     */
    RewardPointsResponse calculateRewardPoints(Long customerId, YearMonth yearMonth);

    /**
     * Calculates the reward points for a list of transactions within a specified date range.
     *
     * @param transactions The list of transactions.
     * @param startDate    The start date of the transaction period.
     * @param endDate      The end date of the transaction period.
     * @return The total reward points earned for the given transactions.
     */
    int calculatePointsForMonth(List<Transaction> transactions, LocalDate startDate, LocalDate endDate);

    /**
     * Calculates the reward points for a given transaction amount.
     *
     * @param amount The transaction amount.
     * @return The reward points earned for the given amount.
     */
    int calculatePoints(double amount);
}
