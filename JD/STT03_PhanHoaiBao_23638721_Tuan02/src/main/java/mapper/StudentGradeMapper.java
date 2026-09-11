package mapper;

import dto.StudentGradeRequestDTO;
import dto.StudentGradeResponseDTO;
import dto.StudentResponseDTO;
import entity.StudentGrade;

public class StudentGradeMapper {

    public static StudentGrade toEntity(StudentGradeRequestDTO studentGradeRequestDTO){
        return new StudentGrade(studentGradeRequestDTO.getEnrollmentID(), studentGradeRequestDTO.getGrade());
    }
    public static StudentGradeResponseDTO toDTO(StudentGrade studentGrade){
        return new StudentGradeResponseDTO(studentGrade.getEnrollmentID(), studentGrade.getGrade());
    }
}
