package bookmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import bookmanagement.entity.BookEntity;
import bookmanagement.form.BookForm;


public interface BookService {
    public Page<BookEntity> getBookEntityPage(Pageable pageable);

    public BookEntity saveBookEntity(BookForm bookForm);
}
