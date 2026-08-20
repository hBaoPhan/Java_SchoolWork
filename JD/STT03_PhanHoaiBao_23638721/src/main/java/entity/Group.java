package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="groups")
public class Group {
    @Id
    @Column(name="group_id", length = 11)
    private int id;
    @Column(length = 45, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "groups")
    private Set<User> users;

    public Group() {
    }
}
