package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @Column(name="category_id",length = 45)
    private String id;

    @Column(name="category_name",length = 100,unique = true,nullable = false)
    private String name;

    @OneToMany(mappedBy = "category" )
    private List<Book> books;

    public Category() {
    }

    public Category(String name ,String id) {
        this.name = name;

        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }
}
