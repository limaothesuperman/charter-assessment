package com.example.rewards.controller;

import com.example.rewards.entity.Customer;
import com.example.rewards.entity.RewardPointsResponse;
import com.example.rewards.entity.Transaction;
import com.example.rewards.exception.NullUserException;
import com.example.rewards.repository.CustomerRepository;
import com.example.rewards.repository.TransactionRepository;
import com.example.rewards.service.RewardPointsService;
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


    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

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