package dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGradeRequestDTO {
    private int enrollmentID;

    private double grade;
}
