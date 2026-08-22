package entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ElementCollection
    @CollectionTable(name="authors", joinColumns = @JoinColumn(name="book_id"))
    @Column(name="author_name",nullable = false)
    private Set<String> authors;

    private int year;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Book() {
    }

    public Book(String title, Set<String> authors, int year) {
        this.title = title;
        this.authors = authors;
        this.year = year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public int getYear() {
        return year;
    }

    public Category getCategory() {
        return category;
    }
}
