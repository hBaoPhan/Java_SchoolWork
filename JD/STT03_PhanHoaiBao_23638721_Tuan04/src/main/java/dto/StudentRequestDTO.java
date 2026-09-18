package dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentRequestDTO {

   private int id;
   private String firstName;
   private String lastName;
   private LocalDateTime enrollmentDate;


}
