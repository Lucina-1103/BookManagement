package bookmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import bookmanagement.entity.BookEntity;

public interface BookService {
    public Page<BookEntity> getBookEntityPage(Pageable pageable);
}
