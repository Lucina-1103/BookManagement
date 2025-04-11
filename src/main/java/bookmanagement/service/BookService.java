package bookmanagement.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import bookmanagement.entity.BookEntity;


public interface BookService {
    public Page<BookEntity> getBookEntityPage(Pageable pageable);

    public BookEntity getBookEntity(UUID uuid);

    public BookEntity insertBookEntity(BookEntity bookEntity);

    public BookEntity updateBookEntity(UUID uuid, BookEntity bookEntity);

    @Transactional
    public void deleteBookEntity(UUID uuid);
}
