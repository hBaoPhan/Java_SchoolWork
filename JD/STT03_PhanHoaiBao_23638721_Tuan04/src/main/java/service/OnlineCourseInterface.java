package service;

import dto.OnlineCourseRequestDTO;
import dto.OnlineCourseResponseDTO;

import java.util.List;
import java.util.Optional;

public interface OnlineCourseInterface {
    OnlineCourseResponseDTO create(OnlineCourseRequestDTO dto);
    OnlineCourseResponseDTO update(OnlineCourseRequestDTO dto);
    void delete(int id);
    Optional<OnlineCourseResponseDTO> findById(int id);
    List<OnlineCourseResponseDTO> findAll();
}
