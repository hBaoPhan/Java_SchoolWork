package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends Person{
    private LocalDateTime hireDate;

    @ManyToMany
    @JoinTable(name = "courseInstructor",joinColumns = @JoinColumn(name = "PersonID"),inverseJoinColumns = @JoinColumn(name="CourseID"))
    private Set<Course> courses;

    @OneToOne(mappedBy = "instructor")
    private OfficeAssignment officeAssignment;


    public Instructor(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public Instructor(String firstName, int id, String lastName, LocalDateTime hireDate) {
        super(firstName, id, lastName);
        this.hireDate = hireDate;
    }

    public Instructor() {

    }
}
