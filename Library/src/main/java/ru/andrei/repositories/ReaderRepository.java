package ru.andrei.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.andrei.models.Reader;

public interface ReaderRepository extends CrudRepository<Reader,Long> {
}
