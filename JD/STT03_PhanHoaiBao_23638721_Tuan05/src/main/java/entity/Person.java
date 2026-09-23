package entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private List<PhoneNumber> phoneNumbers;

    public Person(String firstName, String lastName, int age, Address address, List<PhoneNumber> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }
}
