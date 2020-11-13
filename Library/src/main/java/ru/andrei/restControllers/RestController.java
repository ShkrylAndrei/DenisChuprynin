package ru.andrei.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.andrei.models.Book;
import ru.andrei.repositories.BookRepository;

@Controller
@RequestMapping(value = "/serviceLibrary")
public class RestController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(path= "/menu", method = RequestMethod.GET)
    public String menu() {
        return "restGetBook";
    }

    @RequestMapping(path= "/book/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBook(@PathVariable long id) {
        Book resultBook = bookRepository.findById(id).get();
        resultBook.setReader(null);

        return resultBook;

    }

    @RequestMapping(path= "/book", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Book> getAllBook() {
        Iterable<Book> resultBooks = bookRepository.findAll();

        for (Book b:resultBooks){
            b.setReader(null);
        }
        return resultBooks;
    }


    //Как работает jackson - спросить, как посмотреть что он подключается, в отладчике
    //класс Spring.Converter
    //https://javatalks.ru/topics/question/50909
    //https://devcolibri.com/rest-%D0%BD%D0%B0-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D1%80%D0%B5-spring-mvc/
    //Разобрать когда время будет(пример по работе с jackson)
    //https://springframework.guru/processing-json-jackson/
}
