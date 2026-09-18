package dto;

import lombok.ToString;

@ToString
public class OnlineCourseResponseDTO {
    private int id;
    private int credits;
    private String title;
    private String url;

    public OnlineCourseResponseDTO() {
    }

    public OnlineCourseResponseDTO(int id, int credits, String title, String url) {
        this.id = id;
        this.credits = credits;
        this.title = title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
