package bookmanagement.service;

import org.springframework.data.domain.Page;

import bookmanagement.entity.BookEntity;

public interface BookService {
    public Page<BookEntity> getBookEntityList();
}
