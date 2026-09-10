package entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("Student")
public class Student extends Person {
    private LocalDateTime enrollmentDate;
    
    @OneToMany(mappedBy = "student")
    private List<StudentGrade> studentGrades;
}