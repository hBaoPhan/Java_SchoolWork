package entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Table(name = "brands")
@Entity
public class Brand {
    @Id
    @Column(name = "brand_id")
    private int id;

    @Column(name = "brand_name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products;

    public Brand() {
    }
}
