package entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Course {
	@Id
	@Column(name="CourseID")
    protected int id;
    protected String title;
    protected int credits;
    
    @ManyToOne
    @JoinColumn(name = "DepartmentID")
    private Department department; //owning side
    
    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors; //inverse side
    
    @OneToMany(mappedBy = "course")
    private List<StudentGrade> studentGrades;
}