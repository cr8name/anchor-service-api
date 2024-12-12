package com.anchor.anchor_service.karldm.Repository;

import com.anchor.anchor_service.karldm.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query("SELECT c FROM Customer c WHERE c.first_name = ?1 AND c.last_name = ?2")
    Optional<Customer> findFirstNameLastName(String firstName, String lastName);

}
