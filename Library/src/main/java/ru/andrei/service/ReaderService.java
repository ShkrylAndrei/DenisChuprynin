package ru.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andrei.models.Reader;
import ru.andrei.repositories.ReaderRepository;

import java.util.Optional;

@Service
@Transactional
public class ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    public Iterable<Reader> findAllReader() {
        return readerRepository.findAll();
    }

    public Optional<Reader> findByIdReader(long readerId){
        return readerRepository.findById(readerId);
    }

    public void saveReader(Reader reader){
        readerRepository.save(reader);
    }


}
