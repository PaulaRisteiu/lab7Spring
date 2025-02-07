package ro.ubb.lab7Spring.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.lab7Spring.core.model.RentalBook;
import ro.ubb.lab7Spring.web.dto.RentalBookDto;

@Component
public class RentalBookConverter extends BaseConvertor<RentalBook, RentalBookDto> {
    @Override
    public RentalBook convertDtoToModel(RentalBookDto dto) {
       RentalBook rentalBook = RentalBook.builder()
               .bookId(dto.getBookId())
               .customerId(dto.getCustomerId())
               .build();
       rentalBook.setId(dto.getId());
        return rentalBook;
    }

    @Override
    public RentalBookDto convertModelToDto(RentalBook rentalBook) {
        return null;
    }
}
