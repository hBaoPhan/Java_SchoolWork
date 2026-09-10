package service.impl;

import dto.StudentRequestDTO;
import dto.StudentResponseDTO;
import service.StudentInterface;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentService implements StudentInterface {

    @Override
    public void create(StudentRequestDTO studentRequestDTO) {

    }

    @Override
    public void update(StudentRequestDTO studentRequestDTO) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<StudentResponseDTO> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<StudentResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public Map<StudentResponseDTO, Long> getAverageScoreOfStudents() {
        return Map.of();
    }

    @Override
    public List<StudentResponseDTO> listStudentsStudyingCourseWithHighestScore(String courseName) {
        return List.of();
    }
}
