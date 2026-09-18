package service.impl;

import dao.PersonDAO;
import dto.PersonResponseDTO;
import mapper.PersonMapper;
import service.PersonInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonService implements PersonInterface {
    private final PersonDAO personDAO = new PersonDAO();

    @Override
    public void delete(int id) {
        personDAO.delete(id);
    }

    @Override
    public Optional<PersonResponseDTO> findById(int id) {
        return personDAO.findById(id).map(PersonMapper::toDTO);
    }

    @Override
    public List<PersonResponseDTO> findAll() {
        return personDAO.findAll()
                .stream()
                .map(PersonMapper::toDTO)
                .collect(Collectors.toList());
    }
}
