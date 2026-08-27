package entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@DiscriminatorValue("Student")
public class Student extends Person {

    private LocalDateTime enrollmentDate;

    @OneToMany(mappedBy = "student")
    private List<StudentGrade> studentGrades;

    public Student(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Student(String firstName, int id, String lastName, LocalDateTime enrollmentDate) {
        super(firstName, id, lastName);
        this.enrollmentDate = enrollmentDate;
    }

    public Student() {

    }
}
