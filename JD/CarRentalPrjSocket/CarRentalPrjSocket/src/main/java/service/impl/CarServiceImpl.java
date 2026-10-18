package service.impl;

import java.util.List;

import dao.CarDao;
import dto.CarRequestDTO;
import dto.CarResponseDTO;
import dto.RentalContractHistoryDTO;
import entity.Car;
import mapper.CarMapper;
import service.CarService;

public class CarServiceImpl implements CarService{
	
	private final CarDao carDao;
	private final CarMapper mapper;
	
	public CarServiceImpl() {
		carDao = new CarDao();
		mapper = new CarMapper();
	}
	
	@Override
	public void add(CarRequestDTO carRequestDTO) {
		Car car = mapper.toCar(carRequestDTO);
		carDao.add(car);
	}
	@Override
	public void update(CarRequestDTO carRequestDTO) {
		Car car = mapper.toCar(carRequestDTO);
		carDao.update(car);
		
	}
	@Override
	public void delete(Long carId) {
		carDao.delete(carId);
	}
	@Override
	public CarResponseDTO findById(Long carId) {
		Car car = carDao.findById(carId);
		if(car == null)
			return null;
		return mapper.toResponseDTO(car);
	}
	@Override
	public List<CarResponseDTO> findAll() {
		return carDao.findAll()
				.stream()
				.map(car -> mapper.toResponseDTO(car))
				.toList();
	}
	@Override
	public List<RentalContractHistoryDTO> listHistoryRentalByCustomer(String customerId) {
		return carDao.listHistoryRentalByCustomer(customerId)
				.stream()
				.map(a -> mapper.toDto(a))
				.toList();
	}

	public static void main(String[] args) {
		CarService carService = new CarServiceImpl();
		
//		CarRequestDTO carRequestDTO = new CarRequestDTO(11L, "Mazda", "Sedan", "", 4, 150, CarStatus.AVAILABLE);
//		carService.add(carRequestDTO);
		
//		carService.findAll().forEach(c -> System.out.println(c));
		
		System.out.println(carService.findById(1L));
		
//		carService.listHistoryRentalByCustomer("C002")
//		.forEach(c -> System.out.println(c));
	}
}
