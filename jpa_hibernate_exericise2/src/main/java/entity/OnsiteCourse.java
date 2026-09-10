package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class OnsiteCourse extends Course {
    private String location;
    private String days;
    private LocalDateTime time;
}