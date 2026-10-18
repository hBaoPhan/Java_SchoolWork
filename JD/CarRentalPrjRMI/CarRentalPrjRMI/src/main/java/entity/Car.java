package entity;

import java.util.List;

import enums.CarStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"rentalContracts"})
@Builder

@Entity
@Table(name="Cars")
public class Car {
	@Id
	@Column(name="carId")
	private Long id;
	private String carName;
	private String brand;
	private String licensePlate;
	private int seatCount;
	private double pricePerDay;
	
	@Enumerated(EnumType.STRING)
	private CarStatus status;
	
	@OneToMany(mappedBy = "car")
	private List<RentalContract> rentalContracts;
}
