package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentGrade {
   
	@Id
    private int enrollmentID;
	
    private Double grade;
    
    @ManyToOne
    @JoinColumn(name="StudentID")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name="CourseID")
    private Course course;
}