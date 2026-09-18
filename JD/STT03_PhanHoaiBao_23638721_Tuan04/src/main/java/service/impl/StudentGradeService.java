package service.impl;

import dao.StudentGradeDAO;
import dto.StudentGradeRequestDTO;
import dto.StudentGradeResponseDTO;
import dto.StudentResponseDTO;
import entity.Student;
import entity.StudentGrade;
import mapper.StudentGradeMapper;
import service.StudentGradeInterface;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentGradeService implements StudentGradeInterface {
    private StudentGradeDAO studentGradeDAO=new StudentGradeDAO();

    @Override
    public void create(StudentGradeRequestDTO studentGradeRequestDTO) {
        studentGradeDAO.create(StudentGradeMapper.toEntity(studentGradeRequestDTO));
    }

    @Override
    public void update(StudentGradeRequestDTO studentGradeRequestDTO) {
        studentGradeDAO.update(StudentGradeMapper.toEntity(studentGradeRequestDTO));
    }

    @Override
    public void delete(int id) {
        studentGradeDAO.delete(id);
    }

    @Override
    public Optional<StudentGradeResponseDTO> findById(int id) {
        return Optional.of(StudentGradeMapper.toDTO(studentGradeDAO.findById(id).get()));
    }

    @Override
    public List<StudentGradeResponseDTO> findAll() {
        return studentGradeDAO.findAll().stream().map(StudentGradeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Map<StudentResponseDTO, Double> getAverageScoreOfStudents() {
        return Map.of();
    }
}
