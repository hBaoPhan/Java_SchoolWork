package entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@ToString(exclude = {"courses", "officeAssignment" })

@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends Person {
    private LocalDateTime hireDate;
    
    @ManyToMany
    @JoinTable(name="CourseInstructor",
    			joinColumns = @JoinColumn(name="PersonID"),
    			inverseJoinColumns = @JoinColumn(name="CourseID")
    		)
    private Set<Course> courses; //owning side
    
    @OneToOne(mappedBy = "instructor")
    private OfficeAssignment officeAssignment; //inverse side
}