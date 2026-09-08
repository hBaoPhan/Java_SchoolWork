package entity;

public class Address {
    private String street;
    private String ward;
    private String city;

    public Address() {
    }
    public Address(String street, String ward, String city) {
        this.street = street;
        this.ward = ward;
        this.city = city;
    }
    public String getStreet() {
        return street;
    }
    public String getWard() {
        return ward;
    }
    public String getCity() {
        return city;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address{" + "street='" + street + '\'' + ", ward='" + ward + '\'' + ", city='" + city + '\'' + '}';
    }
}
