package entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private int postalCode;
}
