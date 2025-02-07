package ro.ubb.lab7Spring.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.lab7Spring.core.model.Book;
import ro.ubb.lab7Spring.core.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        log.trace("getAllBooks - method called");
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public Book updateBook(Book book) {
        Book updatedBook = bookRepository.findById(book.getId()).get();
        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setPrice(book.getPrice());
        return updatedBook;
    }


    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
