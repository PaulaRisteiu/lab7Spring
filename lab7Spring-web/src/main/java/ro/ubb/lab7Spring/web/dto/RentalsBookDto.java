package ro.ubb.lab7Spring.web.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RentalsBookDto {
    private Set<RentalBookDto> rentalBooks;
}
