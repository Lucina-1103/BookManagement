package bookmanagement.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bookmanagement.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, String> {

    public BookEntity findByUuid(UUID uuid);

    @Query("SELECT MAX(sortOrder) FROM BookEntity")
    public Integer findMaxSortOrder();

    public Integer deleteByUuid(UUID uuid);
}
