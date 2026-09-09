package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(columnDefinition = "NVARCHAR(255)")
    private String street;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String city;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String state;
    @Column(name = "zip_code",columnDefinition = "NVARCHAR(5)")
    private String zipCode;
}
