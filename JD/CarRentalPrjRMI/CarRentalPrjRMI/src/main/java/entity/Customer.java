package entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="Customers")
public class Customer {
	@Id
	@Column(name="customerId")
	private String id;
	private String fullName;
	private String email;
	
	@ElementCollection
	@CollectionTable(name="Phones", joinColumns = @JoinColumn(name = "customerId"))
	@Column(name="phone")
	private Set<String> phones;
	private String driverLicenseNumber;
	
	@OneToMany(mappedBy = "customer")
	private List<RentalContract> rentalContracts;
}
