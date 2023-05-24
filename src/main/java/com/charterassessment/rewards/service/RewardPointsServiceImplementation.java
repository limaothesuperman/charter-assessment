package com.charterassessment.rewards.service;

import com.charterassessment.rewards.entity.RewardPointsResponse;
import com.charterassessment.rewards.entity.Transaction;
import com.charterassessment.rewards.repository.CustomerRepository;
import com.charterassessment.rewards.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardPointsServiceImplementation implements RewardPointsService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public RewardPointsServiceImplementation(TransactionRepository transactionRepository,
                                             CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    /**
     * Calculates the reward points for a customer in a specific year and month.
     *
     * @param customerId The ID of the customer.
     * @param yearMonth  The YearMonth object representing the year and month.
     * @return The RewardPointsResponse object containing the calculated reward points.
     */
    @Override
    public RewardPointsResponse calculateRewardPoints(Long customerId, YearMonth yearMonth) {
        // Calculate the start date for the three-month period
        YearMonth startDate = yearMonth.minusMonths(2);

        LocalDate startDateOfMonth = startDate.atDay(1);
        LocalDate endDateOfMonth = yearMonth.atEndOfMonth();

        // Retrieve transactions for the customer within the specified date range
        List<Transaction> transactions = transactionRepository.findTransactionsByCustomerIdAndTransactionDateBetween(
                customerId, startDateOfMonth, endDateOfMonth);

        // Calculate monthly points and total points
        Map<String, Integer> monthlyPoints = new HashMap<>();
        int totalPoints = 0;

        for (YearMonth currentMonth = startDate; !currentMonth.isAfter(yearMonth); currentMonth = currentMonth.plusMonths(1)) {
            LocalDate monthStart = currentMonth.atDay(1);
            LocalDate monthEnd = currentMonth.atEndOfMonth();
            int points = calculatePointsForMonth(transactions, monthStart, monthEnd);
            monthlyPoints.put(currentMonth.format(DateTimeFormatter.ofPattern("yyyy-MM")), points);
            totalPoints += points;
        }

        // Retrieve the customer's name
        String customerName = customerRepository.findCustomerById(customerId).getName();

        // Create and return the RewardPointsResponse object
        return new RewardPointsResponse(customerId.toString(), customerName, monthlyPoints, totalPoints);
    }

    /**
     * Calculates the reward points for a list of transactions within a specific month.
     *
     * @param transactions The list of transactions.
     * @param startDate    The start date of the month.
     * @param endDate      The end date of the month.
     * @return The total reward points earned for the month.
     */
    @Override
    public int calculatePointsForMonth(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        int points = 0;

        // Iterate over transactions within the specified date range and calculate points
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getTransactionDate();
            if (!transactionDate.isBefore(startDate) && !transactionDate.isAfter(endDate)) {
                points += calculatePoints(transaction.getAmount());
            }
        }

        return points;
    }

    /**
     * Calculates the reward points for a transaction amount.
     *
     * @param amount The transaction amount.
     * @return The reward points earned for the transaction.
     */
    @Override
    public int calculatePoints(double amount) {
        int points = 0;

        // Calculate points based on the transaction amount
        if (amount > 100) {
            points += (int) ((amount - 100) * 2 + 50);
        } else if (amount > 50) {
            points += (int) (amount - 50);
        }

        return points;
    }
}
