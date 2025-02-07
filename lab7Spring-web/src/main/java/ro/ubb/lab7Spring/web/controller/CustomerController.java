package ro.ubb.lab7Spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.lab7Spring.core.model.Customer;
import ro.ubb.lab7Spring.core.service.CustomerService;
import ro.ubb.lab7Spring.web.converter.CustomerConvertor;
import ro.ubb.lab7Spring.web.dto.CustomerDto;
import ro.ubb.lab7Spring.web.dto.CustomersDto;

import java.util.List;
import java.util.Set;

@RestController
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerConvertor customerConvertor;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public CustomersDto getCustomers() {
        log.trace("----getCustomers - method called");
        List<Customer> allCustomers = customerService.getAllCustomers();
        Set<CustomerDto> customerDtos = customerConvertor.convertModelsToDtos(allCustomers);
        CustomersDto customersDtoResult = new CustomersDto(customerDtos);
        log.trace("----getCustomers - method called completed: result={}", customersDtoResult);
        return customersDtoResult;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    CustomerDto saveCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto resultCustomerDto = customerConvertor.convertModelToDto(
                customerService.saveCustomer(
                        customerConvertor.convertDtoToModel(customerDto)));
        return resultCustomerDto;
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    CustomerDto updateCustomer(@PathVariable ("id") Long id, @RequestBody CustomerDto customerDto) {
        System.out.println("----customerDto - method called: " + customerDto);
        return customerConvertor.convertModelToDto(
                customerService.upadateCustomer(
                        customerConvertor.convertDtoToModel(customerDto)));
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteCustomer(@PathVariable ("id") Long id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
