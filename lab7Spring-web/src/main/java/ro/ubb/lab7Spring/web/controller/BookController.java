package ro.ubb.lab7Spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.lab7Spring.core.model.Book;
import ro.ubb.lab7Spring.core.service.BookService;
import ro.ubb.lab7Spring.web.converter.BookConvertor;
import ro.ubb.lab7Spring.web.dto.BookDto;
import ro.ubb.lab7Spring.web.dto.BooksDto;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;
    @Autowired
    private BookConvertor bookConvertor;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public BooksDto getAllBooks() {
        log.trace("getAllBooks - method entered");
        List<Book> allBooks = bookService.getAllBooks();
        Set<BookDto> bookDtos = bookConvertor.convertModelsToDtos(allBooks);

        BooksDto booksDtoResult = new BooksDto(bookDtos);
        log.trace("method exited - getAllBooks: result ={}", booksDtoResult);
        return booksDtoResult;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    BookDto saveBook(@RequestBody BookDto bookDto) {
        BookDto resultBookDto = bookConvertor.convertModelToDto(bookService.saveBook(
                bookConvertor.convertDtoToModel(bookDto)));
        return resultBookDto;
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
    BookDto updateBook(@PathVariable ("id") Long id, @RequestBody BookDto bookDto) {
        System.out.println("-----bookDto: " + bookDto);
        return bookConvertor.convertModelToDto(
                bookService.updateBook(
                        bookConvertor.convertDtoToModel(bookDto)));
    }

    @RequestMapping(value ="/books/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteBook(@PathVariable ("id") Long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
