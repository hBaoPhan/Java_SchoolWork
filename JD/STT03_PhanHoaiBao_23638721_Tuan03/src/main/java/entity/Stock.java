package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
@IdClass(StockId.class)
public class Stock {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "store_id",nullable = false)
    private Store store;

    private int quantity;
}
