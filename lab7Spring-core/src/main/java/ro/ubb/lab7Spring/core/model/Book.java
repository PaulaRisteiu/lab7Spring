package ro.ubb.lab7Spring.core.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Book extends BaseEntity<Long> {
    private String title;
    private String author;
    private double price;
}
