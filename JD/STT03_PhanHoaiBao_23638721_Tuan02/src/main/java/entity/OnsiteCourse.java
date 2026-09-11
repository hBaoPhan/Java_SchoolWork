package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.SecondaryTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnsiteCourse extends Course {

    private String days;
    private String location;
    private LocalDateTime time;

    public OnsiteCourse(int id, int credits, String title, String days, LocalDateTime time, String location) {
        super(id, credits, title);
        this.days = days;
        this.time = time;
        this.location = location;
    }
}
