package com.anchor.anchor_service.karldm.Service;

import com.anchor.anchor_service.karldm.Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CutomerService {

    public List<Customer> getCustomer();

    void addCustomer(Customer customer);

    public void deleteCustomer(int customer_id);
    public Optional<Customer> updateCustomer(int customer_id, Customer customerDetails);
}
