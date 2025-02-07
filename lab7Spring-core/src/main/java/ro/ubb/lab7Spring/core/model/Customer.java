package ro.ubb.lab7Spring.core.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder //design pattern !!!
public class Customer extends BaseEntity<Long>{
    private String name;
    private String phone;
}
