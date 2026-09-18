package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PersonResponseDTO {
    private int id;
    private String firstName;
    private String lastName;

    public PersonResponseDTO() {
    }

    public PersonResponseDTO(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
