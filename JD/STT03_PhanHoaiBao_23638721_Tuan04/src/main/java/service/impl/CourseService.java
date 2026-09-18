package service.impl;

import dao.CourseDAO;
import dto.CourseRequestDTO;
import dto.CourseResponseDTO;
import dto.StudentResponseDTO;
import mapper.CourseMapper;
import mapper.StudentMapper;
import service.CourseInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseService implements CourseInterface {
    private final CourseDAO courseDAO = new CourseDAO();

    @Override
    public void create(CourseRequestDTO courseRequestDTO) {
        // Course is abstract entity; persistence is managed via OnlineCourse / OnsiteCourse or entity instances.
    }

    @Override
    public void update(CourseRequestDTO courseRequestDTO) {
    }

    @Override
    public void delete(int id) {
        courseDAO.delete(id);
    }

    @Override
    public Optional<CourseResponseDTO> findById(int id) {
        return courseDAO.findById(id).map(CourseMapper::toDTO);
    }

    @Override
    public List<CourseResponseDTO> findAll() {
        return courseDAO.findAll()
                .stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentResponseDTO> listStudentsStudyingCourseWithHighestScore(String courseName) {
        return courseDAO.listStudentsStudyingCourseWithHighestScore(courseName)
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
