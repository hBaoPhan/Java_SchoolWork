package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @Column(name = "customerId")
    private String id;
    private String fullName;
    private String email;

    @ElementCollection
    @CollectionTable(name = "Phones",
            joinColumns = @JoinColumn(name = "customerId"))
    @Column(name = "phone")
    private Set<String> phones=new HashSet<>();

    private String driverLicenseNumber;

    @OneToMany(mappedBy = "customer")
    private Set<RentalContract> rentalContracts;




}
