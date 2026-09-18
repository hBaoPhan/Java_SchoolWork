package dto;

import java.time.LocalDateTime;

public class OnsiteCourseRequestDTO {
    private int id;
    private int credits;
    private String title;
    private String days;
    private String location;
    private LocalDateTime time;

    public OnsiteCourseRequestDTO() {
    }

    public OnsiteCourseRequestDTO(int id, int credits, String title, String days, String location, LocalDateTime time) {
        this.id = id;
        this.credits = credits;
        this.title = title;
        this.days = days;
        this.location = location;
        this.time = time;
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

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
