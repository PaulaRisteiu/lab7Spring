package ro.ubb.lab7Spring.web.dto;

import lombok.*;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BooksDto {
    private Set<BookDto> books;
}
