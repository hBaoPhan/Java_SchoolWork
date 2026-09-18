package service.impl;

import dao.OnsiteCourseDAO;
import dto.OnsiteCourseRequestDTO;
import dto.OnsiteCourseResponseDTO;
import entity.OnsiteCourse;
import mapper.OnsiteCourseMapper;
import service.OnsiteCourseInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OnsiteCourseService implements OnsiteCourseInterface {
    private final OnsiteCourseDAO onsiteCourseDAO = new OnsiteCourseDAO();

    @Override
    public OnsiteCourseResponseDTO create(OnsiteCourseRequestDTO dto) {
        OnsiteCourse course = OnsiteCourseMapper.toEntity(dto);
        OnsiteCourse created = onsiteCourseDAO.create(course);
        return OnsiteCourseMapper.toDTO(created);
    }

    @Override
    public OnsiteCourseResponseDTO update(OnsiteCourseRequestDTO dto) {
        OnsiteCourse course = OnsiteCourseMapper.toEntity(dto);
        OnsiteCourse updated = onsiteCourseDAO.update(course);
        return OnsiteCourseMapper.toDTO(updated);
    }

    @Override
    public void delete(int id) {
        onsiteCourseDAO.delete(id);
    }

    @Override
    public Optional<OnsiteCourseResponseDTO> findById(int id) {
        return onsiteCourseDAO.findById(id).map(OnsiteCourseMapper::toDTO);
    }

    @Override
    public List<OnsiteCourseResponseDTO> findAll() {
        return onsiteCourseDAO.findAll()
                .stream()
                .map(OnsiteCourseMapper::toDTO)
                .collect(Collectors.toList());
    }
}
