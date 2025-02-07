package ro.ubb.lab7Spring.core.service;

import ro.ubb.lab7Spring.core.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteById(Long id);
}
