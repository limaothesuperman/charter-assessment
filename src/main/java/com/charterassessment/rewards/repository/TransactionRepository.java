package com.charterassessment.rewards.repository;

import com.charterassessment.rewards.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**
     * Finds transactions by customer ID and transaction date between the specified start and end dates.
     *
     * @param customerId The ID of the customer.
     * @param startDate  The start date of the transaction period.
     * @param endDate    The end date of the transaction period.
     * @return A list of transactions that match the criteria.
     */
    List<Transaction> findTransactionsByCustomerIdAndTransactionDateBetween(Long customerId, LocalDate startDate, LocalDate endDate);

}
