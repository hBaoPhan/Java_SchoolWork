package entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@Column(name="DepartmentID")
    private int id;
	
    private String name;
    private double budget;
    private LocalDateTime startDate;
    private int administrator;
    
    @OneToMany(mappedBy = "department")
    private List<Course> courses; //inverse side

	/**
	 * @param id
	 * @param name
	 * @param budget
	 * @param startDate
	 * @param administrator
	 */
	public Department(int id, String name, double budget, LocalDateTime startDate, int administrator) {
		super();
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.startDate = startDate;
		this.administrator = administrator;
	}
	
	public Department() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the budget
	 */
	public double getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}

	/**
	 * @return the startDate
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the administrator
	 */
	public int getAdministrator() {
		return administrator;
	}

	/**
	 * @param administrator the administrator to set
	 */
	public void setAdministrator(int administrator) {
		this.administrator = administrator;
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", budget=" + budget + ", startDate=" + startDate
				+ ", administrator=" + administrator + "]";
	}
    
	
    
    //setters/ getters/ constructors/ toString
    
    
}