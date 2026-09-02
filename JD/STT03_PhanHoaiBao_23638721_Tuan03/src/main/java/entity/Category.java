package entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categorys")
public class Category {

    @Id
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category() {
    }
}
