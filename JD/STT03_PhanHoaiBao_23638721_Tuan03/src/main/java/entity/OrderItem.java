package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
@IdClass(OrderItemId.class)
public class OrderItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    @Column(name = "list_price")
    private double listPrice;

    @Column(name = "discount")
    private double discount;
}
