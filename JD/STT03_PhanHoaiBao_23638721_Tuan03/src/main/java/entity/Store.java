package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @Column(name = "store_id")
    private int id;

    @Column(name = "store_name",columnDefinition = "NVARCHAR(255)")
    private String name;

    @Embedded
    private Contact contact;

    @Embedded
    private Address address;

    public Store() {
    }
}
