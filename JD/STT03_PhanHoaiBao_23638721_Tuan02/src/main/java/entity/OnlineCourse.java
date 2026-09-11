package entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnlineCourse extends Course {
    private String url;

    public OnlineCourse(int id, int credits, String title, String url) {
        super(id, credits, title);
        this.url = url;
    }
}
