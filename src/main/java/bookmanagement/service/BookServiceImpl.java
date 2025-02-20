package bookmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bookmanagement.entity.BookEntity;
import bookmanagement.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<BookEntity> getBookEntityPage(Pageable pageable) {
        pageable.getSortOr(Sort.by("sortOrder"));
        return bookRepository.findAll(pageable);
    }
}
