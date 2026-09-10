package dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentResponseDTO {

    private String firstName;
    private String lastName;
    private LocalDateTime enrollmentDate;

    public StudentResponseDTO(String lastName, LocalDateTime enrollmentDate, String firstName) {
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
        this.firstName = firstName;
    }
}
