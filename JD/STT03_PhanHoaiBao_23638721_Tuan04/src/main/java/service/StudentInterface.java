package service;

import dto.StudentRequestDTO;
import dto.StudentResponseDTO;
import entity.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentInterface {
    public void create(StudentRequestDTO studentRequestDTO);
    public void update(StudentRequestDTO studentRequestDTO);
    public void delete(int id);
    public Optional<StudentResponseDTO> findById(int id);
    public List<StudentResponseDTO> findAll();
    public Map<StudentResponseDTO,Long> getAverageScoreOfStudents();
    public List<StudentResponseDTO> listStudentsStudyingCourseWithHighestScore(String courseName);
}
