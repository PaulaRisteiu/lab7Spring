package ro.ubb.lab7Spring.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.lab7Spring.core.model.Customer;
import ro.ubb.lab7Spring.core.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        log.trace("getAllCustomers - method called" );
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer upadateCustomer(Customer customer) {
        Customer updatedCustomer = customerRepository.findById(customer.getId()).orElse(new Customer());
        updatedCustomer.setName(customer.getName());
        updatedCustomer.setPhone(customer.getPhone());
        return updatedCustomer;
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
