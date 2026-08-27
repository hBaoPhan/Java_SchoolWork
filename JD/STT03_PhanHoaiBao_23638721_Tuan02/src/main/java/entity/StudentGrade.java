package entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="StudentGrade")
public class StudentGrade {
    @Id
    private int enrollmentID;
    @Column(nullable = true)
    private double grade;

    @ManyToOne
    @JoinColumn(name="StudentID")
    private Student student;

    @ManyToOne
    @JoinColumn(name="CourseID")
    private Course course;

    public StudentGrade() {
    }

    public StudentGrade(int enrollmentID, double grade, Student student, Course course) {
        this.enrollmentID = enrollmentID;
        this.grade = grade;
        this.student = student;
        this.course = course;
    }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGrade that = (StudentGrade) o;
        return enrollmentID == that.enrollmentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollmentID);
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "enrollmentID=" + enrollmentID +
                ", grade=" + grade +
                '}';
    }
}

