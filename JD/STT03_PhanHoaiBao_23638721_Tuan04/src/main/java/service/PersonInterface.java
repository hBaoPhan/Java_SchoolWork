package service;

import dto.PersonRequestDTO;
import dto.PersonResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PersonInterface {
    void delete(int id);
    Optional<PersonResponseDTO> findById(int id);
    List<PersonResponseDTO> findAll();
}
