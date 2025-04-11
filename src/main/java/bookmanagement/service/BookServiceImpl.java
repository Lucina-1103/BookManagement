package bookmanagement.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        var sort = pageable.getSortOr(Sort.by("sortOrder"));
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return bookRepository.findAll(sortedPageable);
    }

    @Override
    public BookEntity getBookEntity(UUID uuid) {
        return bookRepository.findByUuid(uuid);
    }

    @Override
    public BookEntity insertBookEntity(BookEntity bookEntity) {
        var maxSortOrder = bookRepository.findMaxSortOrder();
        if (maxSortOrder == null) {
            bookEntity.setSortOrder(10);
        } else {
            bookEntity.setSortOrder(maxSortOrder + 10);
        }

        return bookRepository.save(bookEntity);
    }

    @Override
    public BookEntity updateBookEntity(UUID uuid, BookEntity bookEntity) {
        var baseBookEntity = bookRepository.findByUuid(uuid);

        baseBookEntity.setTitle(bookEntity.getTitle());

        return bookRepository.save(baseBookEntity);
    }

    @Override
    public void deleteBookEntity(UUID uuid) {
        bookRepository.deleteByUuid(uuid);
    }
}
