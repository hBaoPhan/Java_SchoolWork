package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class OnsiteCourseResponseDTO {
    private int id;
    private int credits;
    private String title;
    private String days;
    private String location;
    private LocalDateTime time;

    public OnsiteCourseResponseDTO() {
    }

    public OnsiteCourseResponseDTO(int id, int credits, String title, String days, String location, LocalDateTime time) {
        this.id = id;
        this.credits = credits;
        this.title = title;
        this.days = days;
        this.location = location;
        this.time = time;
    }


}
