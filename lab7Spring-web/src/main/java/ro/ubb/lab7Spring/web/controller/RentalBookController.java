package ro.ubb.lab7Spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.lab7Spring.core.model.Book;
import ro.ubb.lab7Spring.core.model.RentalBook;
import ro.ubb.lab7Spring.core.service.RentalBookService;
import ro.ubb.lab7Spring.web.converter.RentalBookConverter;
import ro.ubb.lab7Spring.web.dto.RentalBookDto;
import ro.ubb.lab7Spring.web.dto.RentalsBookDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class RentalBookController {
    private static final Logger log = LoggerFactory.getLogger(RentalBookController.class);

    @Autowired
    private RentalBookService rentalBookService;

    @Autowired
    private RentalBookConverter rentalBookConverter;

    @RequestMapping(value = "/rentalsbook", method = RequestMethod.GET)
   public  RentalsBookDto rentalsBook() {
        log.trace("******************getRentalsBook -method entered");
        List<RentalBook> allRentalBooks = rentalBookService.getAllRentalBooks();
        Set<RentalBookDto> rentalBookDtos = rentalBookConverter.convertModelsToDtos(allRentalBooks);
        RentalsBookDto rentalsBookDtoResult = new RentalsBookDto(rentalBookDtos);

        log.trace("******************getRentalsBook: result={}", rentalsBookDtoResult);
        return rentalsBookDtoResult;
    }

    @RequestMapping(value = "/rentalsbook", method = RequestMethod.POST)
    RentalBookDto rentalsBook(@RequestBody RentalBookDto rentalBookDto) {
        RentalBookDto rentalBookDtoResult = rentalBookConverter.convertModelToDto(
                rentalBookService.saveRentalBook(rentalBookConverter.convertDtoToModel(rentalBookDto)));
        return rentalBookDtoResult;
    }

    @RequestMapping(value = "/rentalsbook/{id}", method = RequestMethod.PUT)
    RentalBookDto rentalsBook(@PathVariable("id") Long id,
                              @RequestBody RentalBookDto rentalBookDto) {

        System.out.println("----dto: " + rentalBookDto);
        return rentalBookConverter.convertModelToDto(
                rentalBookService.updateRentalBook(
                        rentalBookConverter.convertDtoToModel(rentalBookDto)));

         }

    @RequestMapping(value = "/rentalsbook/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteRentalBook(@PathVariable("id") Long id) {
        rentalBookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
