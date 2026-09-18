package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class OnlineCourseRequestDTO {
    private int id;
    private int credits;
    private String title;
    private String url;

    public OnlineCourseRequestDTO() {
    }

    public OnlineCourseRequestDTO(int id, int credits, String title, String url) {
        this.id = id;
        this.credits = credits;
        this.title = title;
        this.url = url;
    }


}
