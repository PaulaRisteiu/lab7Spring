package ro.ubb.lab7Spring.core.service;

import ro.ubb.lab7Spring.core.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
     Customer saveCustomer(Customer customer);
    Customer upadateCustomer(Customer customer);
    void deleteById(Long id);
}
