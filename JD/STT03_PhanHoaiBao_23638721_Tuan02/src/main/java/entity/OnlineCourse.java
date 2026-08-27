package entity;

import jakarta.persistence.Entity;

@Entity
public class OnlineCourse extends Course {
    private String url;
}
