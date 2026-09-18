package service;

import dto.StudentGradeRequestDTO;
import dto.StudentGradeResponseDTO;
import dto.StudentResponseDTO;
import entity.Student;
import entity.StudentGrade;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentGradeInterface {
    public void create(StudentGradeRequestDTO studentGradeRequestDTO);
    public void update(StudentGradeRequestDTO studentGradeRequestDTO);
    public void delete(int id);
    public Optional<StudentGradeResponseDTO> findById(int id);
    public List<StudentGradeResponseDTO> findAll();
    public Map<StudentResponseDTO, Double> getAverageScoreOfStudents();
}
