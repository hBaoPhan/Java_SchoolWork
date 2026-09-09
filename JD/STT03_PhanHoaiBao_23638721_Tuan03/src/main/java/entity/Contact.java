package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
@Embeddable
public class Contact {
    @Column(columnDefinition = "NVARCHAR(255)")
    private String phone;
    @Column(columnDefinition = "NVARCHAR(255)")
    private String email;


}
