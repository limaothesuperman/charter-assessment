package com.example.rewards.service;

import com.example.rewards.entity.RewardPointsResponse;
import com.example.rewards.entity.Transaction;
import com.example.rewards.repository.CustomerRepository;
import com.example.rewards.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardPointsService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;

    public RewardPointsService(TransactionRepository transactionRepository,
                               CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    public RewardPointsResponse calculateRewardPoints(Long customerId, YearMonth yearMonth) {
        YearMonth startDate = yearMonth.minusMonths(2);

        LocalDate startDateOfMonth = startDate.atDay(1);
        LocalDate endDateOfMonth = yearMonth.atEndOfMonth();

        List<Transaction> transactions = transactionRepository.findTransactionsByCustomerIdAndTransactionDateBetween(
                customerId, startDateOfMonth, endDateOfMonth);

        Map<String, Integer> monthlyPoints = new HashMap<>();
        int totalPoints = 0;

        for (YearMonth currentMonth = startDate; !currentMonth.isAfter(yearMonth); currentMonth = currentMonth.plusMonths(1)) {
            LocalDate monthStart = currentMonth.atDay(1);
            LocalDate monthEnd = currentMonth.atEndOfMonth();
            int points = calculatePointsForMonth(transactions, monthStart, monthEnd);
            monthlyPoints.put(currentMonth.format(DateTimeFormatter.ofPattern("yyyy-MM")), points);
            totalPoints += points;
        }
        String customerName = customerRepository.findCustomerById(customerId).getName();

        return new RewardPointsResponse(customerId.toString(), customerName, monthlyPoints, totalPoints);
    }

    private int calculatePointsForMonth(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        int points = 0;

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getTransactionDate();
            if (!transactionDate.isBefore(startDate) && !transactionDate.isAfter(endDate)) {
                points += calculatePoints(transaction.getAmount());
            }
        }

        return points;
    }

    public int calculatePoints(double amount) {
        int points = 0;

        if (amount > 100) {
            points += (int) ((amount - 100) * 2 + 50);
        } else if (amount > 50) {
            points += (int) (amount - 50);
        }

        return points;
    }
}