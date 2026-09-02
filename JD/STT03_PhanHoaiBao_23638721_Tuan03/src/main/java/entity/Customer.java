package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "customers")
@AttributeOverride(name = "id",column = @Column(name = "customer_id"))
public class Customer extends Person{

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
