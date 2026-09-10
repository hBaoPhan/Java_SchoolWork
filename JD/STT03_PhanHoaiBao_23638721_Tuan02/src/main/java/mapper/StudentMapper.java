package mapper;

import dto.StudentRequestDTO;
import dto.StudentResponseDTO;
import entity.Student;

public class StudentMapper {
    public static Student toEntity(StudentRequestDTO studentRequestDTO){
        return new Student(studentRequestDTO.getFirstName(),studentRequestDTO.getId(),studentRequestDTO.getLastName(),studentRequestDTO.getEnrollmentDate());
    }

    public static StudentResponseDTO toDTO(Student student){
        return new StudentResponseDTO(student.getLastName(),student.getEnrollmentDate(), student.getFirstName());

    }
}
