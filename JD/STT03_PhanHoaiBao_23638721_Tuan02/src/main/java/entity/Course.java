package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Course {
    @Id
    @Column(name="CourseID")
    protected int id;
    protected int credits;
    protected String title;

    @ManyToMany(mappedBy = "courses")
    private Set<Instructor> instructors;

    @OneToMany(mappedBy = "course")
    private Set<StudentGrade> studentGrades;

    @ManyToOne
    @JoinColumn(name = "DepartmentId")
    private Department department;

    public Course() {
    }

    public Course(int id, int credits, String title) {
        this.id = id;
        this.credits = credits;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Set<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(Set<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}

