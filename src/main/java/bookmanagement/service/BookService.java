package bookmanagement.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import bookmanagement.entity.BookEntity;
import bookmanagement.form.BookForm;


public interface BookService {
    public Page<BookEntity> getBookEntityPage(Pageable pageable);

    public BookEntity showBookEntity(UUID uuid);

    public BookEntity saveBookEntity(BookForm bookForm);

    public BookEntity updateBookEntity(UUID uuid, BookForm bookForm);

    @Transactional
    public void deleteBookEntity(UUID uuid);
}
