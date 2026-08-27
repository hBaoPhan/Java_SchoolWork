package entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator")
public abstract class Person {

    protected String firstName;
    @Id
    @Column(name = "PersonID")
    protected int id;

    protected String lastName;



    public Person() {
    }

    public Person(String firstName, int id, String lastName) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
