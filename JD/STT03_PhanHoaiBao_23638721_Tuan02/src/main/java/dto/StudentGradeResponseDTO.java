package dto;

import jakarta.persistence.Column;

public class StudentGradeResponseDTO {
    private int enrollmentID;
    private double grade;

    public StudentGradeResponseDTO(int enrollmentID, double grade) {
        this.enrollmentID = enrollmentID;
        this.grade = grade;
    }
}
