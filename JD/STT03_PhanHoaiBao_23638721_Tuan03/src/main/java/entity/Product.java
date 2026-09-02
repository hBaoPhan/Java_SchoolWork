package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "list_price")
    private double listPrice;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Stock> stocks;

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems;
}
