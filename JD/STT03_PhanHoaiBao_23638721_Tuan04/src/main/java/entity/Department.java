package entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
public class Department {
    @Id
    @Column(name = "DepartmentID")
    private int id;

    private int administrator;
    private double budget;
    private String name;
    private LocalDateTime startDate;

    @OneToMany(mappedBy = "department")
    private Set<Course> courses;

    public Department() {
    }

    public Department(int id, int administrator, double budget, String name, LocalDateTime startDate) {
        this.id = id;
        this.administrator = administrator;
        this.budget = budget;
        this.name = name;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdministrator() {
        return administrator;
    }

    public void setAdministrator(int administrator) {
        this.administrator = administrator;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", administrator=" + administrator +
                ", startDate=" + startDate +
                '}';
    }
}

