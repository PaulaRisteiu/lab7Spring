package ro.ubb.lab7Spring.core.service;

import ro.ubb.lab7Spring.core.model.RentalBook;

import java.util.List;

public interface RentalBookService {
    List<RentalBook> getAllRentalBooks();
    RentalBook saveRentalBook(RentalBook rentalBook);
    RentalBook updateRentalBook(RentalBook rentalBook);
    void deleteById(Long id);
}
