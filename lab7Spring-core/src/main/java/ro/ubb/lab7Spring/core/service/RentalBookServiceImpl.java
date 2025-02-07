package ro.ubb.lab7Spring.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.lab7Spring.core.model.RentalBook;
import ro.ubb.lab7Spring.core.repository.RentalRepository;

import java.util.List;
@Service
public class RentalBookServiceImpl implements RentalBookService {
    private static final Logger log = LoggerFactory.getLogger(RentalBookServiceImpl.class);
    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public List<RentalBook> getAllRentalBooks() {
        log.trace("getAllRentalBooks - method called");
        return rentalRepository.findAll();
    }

    @Override
    public RentalBook saveRentalBook(RentalBook rentalBook) {
        return rentalRepository.save(rentalBook);
    }

    @Override
    public RentalBook updateRentalBook(RentalBook rentalBook) {
        RentalBook updatedRentalBook = rentalRepository.findById(rentalBook.getId()).orElse(new RentalBook());
        updatedRentalBook.setBookId(rentalBook.getBookId());
        updatedRentalBook.setCustomerId(rentalBook.getCustomerId());
        return updatedRentalBook;
    }

    @Override
    public void deleteById(Long id) {
        rentalRepository.deleteById(id);
    }
}
