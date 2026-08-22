package entity;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeProjectId implements Serializable {
    private Long employee;
    private Long project;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProjectId that = (EmployeeProjectId) o;
        return Objects.equals(employee, that.employee) && Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, project);
    }
}
