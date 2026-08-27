package entity;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
public class OfficeAssignment {
    @Id
    private int id;

    private Timestamp timestamp;

    private String location;

    @OneToOne
    @MapsId
    @JoinColumn(name = "InstructorID")
    private Instructor instructor;


}
