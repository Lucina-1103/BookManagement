package bookmanagement.helper;

import org.springframework.stereotype.Component;

import bookmanagement.entity.BookEntity;
import bookmanagement.form.BookForm;

@Component
public class BookHelper {

    /**
     * BookformをBookEntityに変換する
     */
    public BookEntity toBookEntity(BookForm bookForm) {
        var bookEntity = new BookEntity();
        bookEntity.setUuid(bookForm.getUuid());
        bookEntity.setTitle(bookForm.getTitle());
        bookEntity.setSortOrder(bookForm.getSortOrder());
        return bookEntity;
    }
}
