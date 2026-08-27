package entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Course {
    @Id
    @Column(name="CourseID")
    protected int id;
    protected int credit;
    protected String title;
    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors;

    @OneToMany(mappedBy = "course")
    private Set<StudentGrade> studentGrades;

    @ManyToOne
    @JoinColumn(name = "DepartmentId")
    private Department department;
}
