package service;

import dto.reponse.CarReponseDTO;
import dto.reponse.RentalContractHistoryDTO;
import dto.request.CarRequestDTO;
import entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarInterface {
        public void create(CarRequestDTO car);
        public void update(CarRequestDTO car);
        public void delete(Long id);
        public Optional<CarReponseDTO> findById(Long id);
        public List<CarReponseDTO> findALl();
        public List<RentalContractHistoryDTO> getContractByCustomer(String id);


}
