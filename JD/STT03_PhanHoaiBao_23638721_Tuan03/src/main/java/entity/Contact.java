package entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
@Embeddable
public class Contact {

    private String phone;

    private String email;


}
