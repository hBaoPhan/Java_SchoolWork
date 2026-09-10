package entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class OfficeAssignment {
	
	@Id
	private int id;
	
    private String location;
    private Timestamp timestamp;
    
    @MapsId
    @OneToOne
    @JoinColumn(name="InstructorID")
    private Instructor instructor; //owning side
}