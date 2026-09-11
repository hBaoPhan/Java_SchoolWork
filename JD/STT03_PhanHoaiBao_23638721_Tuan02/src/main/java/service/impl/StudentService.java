package service.impl;

import dao.StudentDAO;
import dto.StudentRequestDTO;
import dto.StudentResponseDTO;
import mapper.StudentMapper;
import service.StudentInterface;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentService implements StudentInterface {
    private final StudentDAO studentDAO=new StudentDAO();

    @Override
    public void create(StudentRequestDTO studentRequestDTO) {
        studentDAO.create(StudentMapper.toEntity(studentRequestDTO));

    }

    @Override
    public void update(StudentRequestDTO studentRequestDTO) {
        studentDAO.update(StudentMapper.toEntity(studentRequestDTO));
    }

    @Override
    public void delete(int id) {
        studentDAO.delete(id);
    }

    @Override
    public Optional<StudentResponseDTO> findById(int id) {

        return Optional.of(StudentMapper.toDTO(studentDAO.findById(id).get()));
    }

    @Override
    public List<StudentResponseDTO> findAll() {

        return studentDAO.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Map<StudentResponseDTO, Long> getAverageScoreOfStudents() {

        return studentDAO.getAverageScoreOfStudents()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e->StudentMapper.toDTO(e.getKey()),Map.Entry::getValue));
    }

    @Override
    public List<StudentResponseDTO> listStudentsStudyingCourseWithHighestScore(String courseName) {
        return studentDAO.listStudentsStudyingCourseWithHighestScore(courseName)
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());

    }
}
