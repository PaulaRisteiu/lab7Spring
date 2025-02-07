package ro.ubb.lab7Spring.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CustomerDto extends BaseDto{
    private String name;
    private String phone;

}
