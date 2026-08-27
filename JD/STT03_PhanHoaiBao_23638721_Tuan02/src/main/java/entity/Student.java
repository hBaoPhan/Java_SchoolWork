package entity;

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

    public Student() {
    }

    public Student(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Student(String firstName, int id, String lastName, LocalDateTime enrollmentDate) {
        super(firstName, id, lastName);
        this.enrollmentDate = enrollmentDate;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}

