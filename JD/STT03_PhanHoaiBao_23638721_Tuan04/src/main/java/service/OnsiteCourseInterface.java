package service;

import dto.OnsiteCourseRequestDTO;
import dto.OnsiteCourseResponseDTO;

import java.util.List;
import java.util.Optional;

public interface OnsiteCourseInterface {
    OnsiteCourseResponseDTO create(OnsiteCourseRequestDTO dto);
    OnsiteCourseResponseDTO update(OnsiteCourseRequestDTO dto);
    void delete(int id);
    Optional<OnsiteCourseResponseDTO> findById(int id);
    List<OnsiteCourseResponseDTO> findAll();
}
