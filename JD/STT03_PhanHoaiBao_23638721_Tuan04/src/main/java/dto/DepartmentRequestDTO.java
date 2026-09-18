package dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DepartmentRequestDTO {
    private int id;
    private int administrator;
    private double budget;
    private String name;
    private LocalDateTime startDate;


}
