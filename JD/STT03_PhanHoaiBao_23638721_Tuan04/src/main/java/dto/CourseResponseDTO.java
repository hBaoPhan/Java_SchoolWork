package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CourseResponseDTO {
    private int id;
    private int credits;
    private String title;

    public CourseResponseDTO() {
    }

    public CourseResponseDTO(int id, int credits, String title) {
        this.id = id;
        this.credits = credits;
        this.title = title;
    }


}
