package org.example.db.model;

import javax.annotation.Generated;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="books")
public class Book implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="author_name")
    private String author_name;
    @Column(name="book_name")
    private String book_name;
    @Column(name="isbn")
    private String  isbn;

    public Book() {
    }

    public Book(int id, String author_name, String book_name, String isbn) {
        this.id = id;
        this.author_name = author_name;
        this.book_name = book_name;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author_name='" + author_name + '\'' +
                ", book_name='" + book_name + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
