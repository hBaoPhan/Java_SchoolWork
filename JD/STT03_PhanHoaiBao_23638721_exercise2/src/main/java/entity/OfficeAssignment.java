package entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"instructor"})

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