package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@AttributeOverride(name = "id",column = @Column(name = "staff_id"))
@Table(name = "staffs")
public class Staff extends Person{

    private byte active;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "manager")
    private Set<Staff> staffs;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Staff manager;

    public Staff() {
    }
}
