package entity;

import java.time.LocalDate;

import enums.ContractStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@ToString
@Builder

@Entity
@Table(name="RentalContracts")
@IdClass(RentalContractId.class)
public class RentalContract {
	@Id
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@Id
	@ManyToOne
	@JoinColumn(name="carId")
	private Car car;
	@Id
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	private ContractStatus contractStatus;
}
