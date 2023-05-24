package com.charterassessment.rewards.repository;

import com.charterassessment.rewards.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds a customer by their ID.
     *
     * @param customerId The ID of the customer to find.
     * @return The found Customer object, or null if not found.
     */
    Customer findCustomerById(Long customerId);
}
