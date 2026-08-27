package entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class OnsiteCourse extends Course {

    private String days;
    private String location;
    private LocalDateTime time;
}
