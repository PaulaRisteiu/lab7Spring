package ro.ubb.lab7Spring.web.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomersDto {
    private Set<CustomerDto> customers;
}
