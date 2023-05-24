package com.charterassessment.rewards.controller;

import com.charterassessment.rewards.exception.NullUserException;
import com.charterassessment.rewards.entity.Customer;
import com.charterassessment.rewards.entity.RewardPointsResponse;
import com.charterassessment.rewards.entity.Transaction;
import com.charterassessment.rewards.repository.CustomerRepository;
import com.charterassessment.rewards.repository.TransactionRepository;
import com.charterassessment.rewards.service.RewardPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final RewardPointsService rewardPointsService;
    private final CustomerRepository customerRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository, RewardPointsService rewardPointsService,
                                 CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.rewardPointsService = rewardPointsService;
        this.customerRepository = customerRepository;
    }

    /**
     * Endpoint for creating a new transaction.
     *
     * @param transaction The Transaction object representing the new transaction.
     * @return The created Transaction object in the response body.
     */
    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    /**
     * Endpoint for creating a new customer.
     *
     * @param customer The Customer object representing the new customer.
     * @return The created Customer object in the response body.
     */
    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    /**
     * Endpoint for calculating the reward points of a customer for a specific year and month.
     *
     * @param customerId The ID of the customer.
     * @param yearMonth  The YearMonth object representing the year and month for which to calculate the reward points.
     * @return The RewardPointsResponse object containing the calculated reward points in the response body.
     * @throws NullUserException If the customer with the given ID is not found.
     */
    @GetMapping("/transactions/{customerId}/points")
    public ResponseEntity<RewardPointsResponse> calculateRewardPoints(
            @PathVariable Long customerId,
            @RequestParam("yearMonth") @DateTimeFormat(pattern = "yyyy-MM") YearMonth yearMonth
    ) {
        Customer customer = customerRepository.findCustomerById(customerId);
        if (customer == null) throw new NullUserException(customerId);

        return new ResponseEntity<>(rewardPointsService.calculateRewardPoints(customerId, yearMonth), HttpStatus.OK);
    }
}
