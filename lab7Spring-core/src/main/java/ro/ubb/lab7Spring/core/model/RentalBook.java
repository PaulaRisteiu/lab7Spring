package ro.ubb.lab7Spring.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RentalBook extends BaseEntity<Long>{
  @Column(name = "customer_id")
  private Long customerId;

  @Column(name ="book_id")
    private Long bookId;

}
