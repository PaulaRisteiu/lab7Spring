package ro.ubb.lab7Spring.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.lab7Spring.core.model.Customer;
import ro.ubb.lab7Spring.web.dto.CustomerDto;

@Component
public class CustomerConvertor extends BaseConvertor<Customer, CustomerDto> {
    @Override
    public Customer convertDtoToModel(CustomerDto dto) {
       Customer customer = Customer.builder()
               .name(dto.getName())
               .phone(dto.getPhone())
               .build();
       customer.setId(dto.getId());
        return customer;
    }

    @Override
    public CustomerDto convertModelToDto(Customer customer) {
        CustomerDto dto = CustomerDto.builder()
                .name(customer.getName())
                .phone(customer.getPhone())
                .build();
        dto.setId(customer.getId());
        return dto;
    }
}
