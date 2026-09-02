package entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@AttributeOverride(name = "id",column = @Column(name = "staff_id"))
@Table(name = "staffs")
public class Staff extends Person{

    private byte active;

    public Staff() {
    }
}
