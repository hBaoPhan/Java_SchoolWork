package service.impl;

import dao.CarDAO;
import dto.reponse.CarReponseDTO;
import dto.reponse.RentalContractHistoryDTO;
import dto.request.CarRequestDTO;
import mapper.CarMapper;
import mapper.RentalContractHistoryMapper;
import service.CarInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarService implements CarInterface {
    private final CarDAO carDAO=new CarDAO();
    @Override
    public void create(CarRequestDTO car) {
        if(carDAO.findById(car.getId()).isPresent()){
           return;
        }
        carDAO.create(CarMapper.toEntity(car));

    }

    @Override
    public void update(CarRequestDTO car) {
        carDAO.update(CarMapper.toEntity(car));
    }

    @Override
    public void delete(Long id) {
        carDAO.delete(id);
    }

    @Override
    public Optional<CarReponseDTO> findById(Long id) {
        return Optional.of(CarMapper.toDto(carDAO.findById(id).get()));
    }

    @Override
    public List<CarReponseDTO> findALl() {
        return carDAO.findAll()
                .stream()
                .map(car -> CarMapper.toDto(car))
                .collect(Collectors.toList());
    }

    @Override
    public List<RentalContractHistoryDTO> getContractByCustomer(String id) {
        return carDAO.getContractByCustomer(id).stream().map(rentalContract -> RentalContractHistoryMapper.toReponseDTO(rentalContract)).collect(Collectors.toList());
    }
}
