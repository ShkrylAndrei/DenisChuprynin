package ru.andrei.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name_book")
    private String name;

    @Column(name="author")
    private String author;

//    @Column(name="in_library")
//    private Boolean in_library;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Book() {
    }

    public Book(long id, String name, String author, Reader reader) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.reader = reader;
    }

    public Book(String name, String author, Reader reader) {
        this.name = name;
        this.author = author;
        this.reader = reader;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }




    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
