package bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bookmanagement.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, String> {
}