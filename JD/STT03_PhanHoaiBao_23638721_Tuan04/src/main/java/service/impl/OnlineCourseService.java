package service.impl;

import dao.OnlineCourseDAO;
import dto.OnlineCourseRequestDTO;
import dto.OnlineCourseResponseDTO;
import entity.OnlineCourse;
import mapper.OnlineCourseMapper;
import service.OnlineCourseInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OnlineCourseService implements OnlineCourseInterface {
    private final OnlineCourseDAO onlineCourseDAO = new OnlineCourseDAO();

    @Override
    public OnlineCourseResponseDTO create(OnlineCourseRequestDTO dto) {
        OnlineCourse course = OnlineCourseMapper.toEntity(dto);
        OnlineCourse created = onlineCourseDAO.create(course);
        return OnlineCourseMapper.toDTO(created);
    }

    @Override
    public OnlineCourseResponseDTO update(OnlineCourseRequestDTO dto) {
        OnlineCourse course = OnlineCourseMapper.toEntity(dto);
        OnlineCourse updated = onlineCourseDAO.update(course);
        return OnlineCourseMapper.toDTO(updated);
    }

    @Override
    public void delete(int id) {
        onlineCourseDAO.delete(id);
    }

    @Override
    public Optional<OnlineCourseResponseDTO> findById(int id) {
        return onlineCourseDAO.findById(id).map(OnlineCourseMapper::toDTO);
    }

    @Override
    public List<OnlineCourseResponseDTO> findAll() {
        return onlineCourseDAO.findAll()
                .stream()
                .map(OnlineCourseMapper::toDTO)
                .collect(Collectors.toList());
    }
}
