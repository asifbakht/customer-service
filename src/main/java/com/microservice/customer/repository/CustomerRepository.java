package com.microservice.customer.repository;

import com.microservice.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM `customer` c WHERE c.email = :email", nativeQuery = true)
    Optional<Customer> findByEmail(@Param("email") final String email);

    Page<Customer> findAllByPhoneNumber(final String phoneNumber, final Pageable pageable);
}
