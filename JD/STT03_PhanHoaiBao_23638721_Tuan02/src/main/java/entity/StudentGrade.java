package entity;

import jakarta.persistence.*;

@Entity
@Table(name="StudentGrade")
public class StudentGrade {
    @Id
    private int enrollmentID;

    private double grade;

    @ManyToOne
    @JoinColumn(name="StudentID")
    private Student student;

    @ManyToOne
    @JoinColumn(name="CourseID")
    private Course course;


}
