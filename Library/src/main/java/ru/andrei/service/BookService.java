package ru.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andrei.models.Book;
import ru.andrei.models.Reader;
import ru.andrei.repositories.BookRepository;

import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Iterable<Book> findAllBook() {
        return bookRepository.findAll();
    }

    public Iterable<Book> findAllBookByReaderIsNull(){
        return bookRepository.findAllByReaderIsNull();
    }

    public Optional<Book> findByIdBook(long bookId){
        return bookRepository.findById(bookId);
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }
}
