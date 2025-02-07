package ro.ubb.lab7Spring.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RentalBookDto extends BaseDto{
    private Long bookId;
    private Long customerId;
}
