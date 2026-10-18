package mapper;

import dto.reponse.CarReponseDTO;
import dto.request.CarRequestDTO;
import entity.Car;

public class CarMapper {
    public static Car toEntity(CarRequestDTO dto){
        return new Car(dto.getId(),
                dto.getStatus(),
                dto.getPricePerDay(),
                dto.getBrand(),
                dto.getSeatCount(),
                dto.getLicensePlate(),
                dto.getCarName());
    }

    public static CarReponseDTO toDto(Car car){
        return new CarReponseDTO(car.getCarName(),
                car.getBrand(),
                car.getSeatCount(),
                car.getLicensePlate(),
                car.getPricePerDay(),
                car.getStatus());

    }
}
