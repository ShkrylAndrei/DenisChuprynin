package ru.andrei.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andrei.models.Book;
import ru.andrei.models.Reader;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends CrudRepository<Book,Long> {


    Iterable<Book> findAllByReaderIsNull();
    Iterable<Book> findAllByReaderIsNotNull();


    //Уточнить почему так не работает с join
    //@Query("SELECT b.name_book, r.name FROM books b inner join readers r ON b.reader_id=r.id where b.reader_id>0")
    //public List findAllBookGetToReader();


    //Просто пример
//    @Query("SELECT e FROM Employee e WHERE e.age = :age")
//    public List findByAge(@Param("age") int age);
}


