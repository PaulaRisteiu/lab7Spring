package ro.ubb.lab7Spring.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.lab7Spring.core.model.Book;
import ro.ubb.lab7Spring.web.dto.BookDto;

@Component
public class BookConvertor extends BaseConvertor<Book, BookDto> {
    @Override
    public Book convertDtoToModel(BookDto dto) {
       Book book = Book.builder()
               .title(dto.getTitle())
               .author(dto.getAuthor())
               .price(dto.getPrice())
               .build();
       book.setId(dto.getId());
       return book;
    }

    @Override
    public BookDto convertModelToDto(Book book) {
       BookDto dto = BookDto.builder()
               .title(book.getTitle())
               .author(book.getAuthor())
               .price(book.getPrice())
               .build();
       dto.setId(book.getId());
       return dto;
    }
}
