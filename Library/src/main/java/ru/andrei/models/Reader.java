package ru.andrei.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    private String name;

    @Column(name="abonement_number")
    private String abonement_number;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.REFRESH)
    private List<Book> bookList = new ArrayList<>();

    public Reader() {
    }

    public Reader(long id, String name, String abonement_number) {
        this.id = id;
        this.name = name;
        this.abonement_number = abonement_number;
    }


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
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

    public String getAbonement_number() {
        return abonement_number;
    }

    public void setAbonement_number(String abonement_number) {
        this.abonement_number = abonement_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(name, reader.name);
    }



    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abonement_number='" + abonement_number + '\'' +
                '}';
    }
}
