package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.spi.LocaleNameProvider;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_status")
    private byte orderStatus;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "shipped_date")
    private LocalDate shippedDate;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;


}
