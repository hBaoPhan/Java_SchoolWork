package service;

import dto.CourseRequestDTO;
import dto.CourseResponseDTO;
import dto.StudentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseInterface {
    void create(CourseRequestDTO courseRequestDTO);
    void update(CourseRequestDTO courseRequestDTO);
    void delete(int id);
    Optional<CourseResponseDTO> findById(int id);
    List<CourseResponseDTO> findAll();
    List<StudentResponseDTO> listStudentsStudyingCourseWithHighestScore(String courseName);
}
