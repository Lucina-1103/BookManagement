package bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bookmanagement.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, String> {

    @Query("SELECT MAX(sortOrder) FROM BookEntity")
    Integer findMaxSortOrder();
}
