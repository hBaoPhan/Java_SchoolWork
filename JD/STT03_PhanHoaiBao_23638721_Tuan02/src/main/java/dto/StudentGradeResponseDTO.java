package dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class StudentGradeResponseDTO {
    private int enrollmentID;
    private double grade;

    public StudentGradeResponseDTO(int enrollmentID, double grade) {
        this.enrollmentID = enrollmentID;
        this.grade = grade;
    }
}
