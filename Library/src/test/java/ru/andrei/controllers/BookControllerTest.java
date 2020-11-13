package ru.andrei.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.andrei.config.WebConfig;
import ru.andrei.models.Book;
import ru.andrei.models.Reader;
import ru.andrei.repositories.BookRepository;
import ru.andrei.repositories.ReaderRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class BookControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ReaderRepository readerRepository;

    @InjectMocks
    private BookController bookController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.bookController).build();
    }

    @Test
    public void lookAllBook() throws Exception {
        List<Book> list = new ArrayList<>();
        Book book = new Book();
        book.setName("test");
        list.add(book);
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        ResultMatcher msg = MockMvcResultMatchers.model()
                .attribute("allBooks", list);

        when(bookRepository.findAll()).thenReturn(list);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/lookAllBook");
        this.mockMvc.perform(builder)
                .andExpect(ok)
                .andExpect(msg);
    }

    @Test
    public void takeBook() throws Exception {
        List<Book> list = new ArrayList<>();
        Book book = new Book();
        book.setName("test");
        list.add(book);


        List<Reader> listReader = new ArrayList<>();
        Reader reader = new Reader();
        reader.setName("Ivan");
        listReader.add(reader);


        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        ResultMatcher msg = MockMvcResultMatchers.model()
                .attribute("allBooks", list);
        ResultMatcher msg2 = MockMvcResultMatchers.model()
                .attribute("allReaders", listReader);


        when(bookRepository.findAllByReaderIsNull()).thenReturn(list);
        when(readerRepository.findAll()).thenReturn(listReader);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/takeBook");
        this.mockMvc.perform(builder)
                .andExpect(ok)
                .andExpect(msg)
                .andExpect(msg2);

    }

    @Test
    public void getPlusPage() {
    }

    @Test
    public void giveBook() {
    }
}