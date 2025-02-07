package ro.ubb.lab7Spring.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookDto extends BaseDto {
    private String title;
    private String author;
    private double price;
}
