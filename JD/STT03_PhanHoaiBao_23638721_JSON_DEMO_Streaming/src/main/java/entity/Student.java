package entity;

import java.util.List;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private int age;

    private List<String> phones;
    private Address address;

    public Student() {
    }

    public Student(long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getPhones() {
        return phones;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phones=" + phones +
                ", address=" + address +
                '}';
    }
}
