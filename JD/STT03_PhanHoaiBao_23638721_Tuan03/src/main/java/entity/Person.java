package entity;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Person {
    @Id
    protected int id;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Embedded
    private Contact contact;


}
