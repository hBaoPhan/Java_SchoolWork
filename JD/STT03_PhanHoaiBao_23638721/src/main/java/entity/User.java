package entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", length = 11)
    private int id;
    @Column(length = 45, nullable = false, unique = true)
    private String username;
    @Column(length = 45, nullable = false)
    private String password;
    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable( name = "users_groups",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<Group> groups;

    public User() {
    }
}
