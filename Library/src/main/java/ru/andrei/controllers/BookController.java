package ru.andrei.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.andrei.models.Book;
import ru.andrei.models.Reader;
import ru.andrei.repositories.BookRepository;
import ru.andrei.repositories.ReaderRepository;
import ru.andrei.service.BookService;
import ru.andrei.service.ReaderService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

//    BookRepository bookRepository;

//    ReaderRepository readerRepository;

//    public BookController(BookRepository bookRepository, ReaderRepository readerRepository) {
//        this.bookRepository = bookRepository;
//        this.readerRepository = readerRepository;
//    }

    @Autowired
    BookService bookService;
    @Autowired
    ReaderService readerService;


    @RequestMapping(value = "/lookAllBook", method = RequestMethod.GET)
    public String lookAllBook(Model model) {
        //Получаем все книги из репозитория

        Iterable<Book> iter = bookService.findAllBook();

        model.addAttribute("allBooks", iter);

        return "viewLookAllBook";
        //return "index";
    }

    @RequestMapping(value = "/takeBook", method = RequestMethod.GET)
    public String takeBook(Model model) {
        Iterable<Book> iterBook = bookService.findAllBookByReaderIsNull();
        Iterable<Reader> iterReader = readerService.findAllReader();

        model.addAttribute("allBooks", iterBook);
        model.addAttribute("allReaders", iterReader);

        return "viewTakeBook";
    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public String returnBook(@RequestParam("reader") long bookId) {

        Optional<Book> bookOpt = bookService.findByIdBook(bookId);
        bookOpt.ifPresent(book -> {
            readerService.findByIdReader(book.getReader().getId()).ifPresent(reader -> {
                List<Book> listBook = reader.getBookList();
                Iterator<Book> iterator = listBook.iterator();
                while (iterator.hasNext()) {
                    Book b = iterator.next();
                    if (b.getId()==bookId) {
                        iterator.remove();
                    }
                }
                book.setReader(null);

                readerService.saveReader(reader);
                bookService.saveBook(book);
            });
        });
        return "redirect:/vewReturnBook";
    }

    @RequestMapping(value = "/addNewBookForm", method = RequestMethod.GET)
    public String addNewBookForm() {
        return "viewAddNewBook";
    }

    @RequestMapping(value = "/addNewBook", method = RequestMethod.POST)
    @Transactional
    public String getPlusPage(@RequestParam(value = "book", required = true) String book,
                              @RequestParam(value = "author", required = true) String author) {

        Book bookToAdd = new Book(book,author,null);
        bookService.saveBook(bookToAdd);

        return "redirect:/vewLookAllBook";
    }


}
