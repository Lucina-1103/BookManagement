package bookmanagement.controller;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookmanagement.form.BookForm;
import bookmanagement.helper.BookHelper;
import bookmanagement.service.BookService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookHelper bookHelper;

    /*
     * 書籍一覧画面を表示する
     */
    @GetMapping("")
    public String books(Model model, Pageable pageable) {
        // ----- 書籍情報の取得 -----
        var bookEntityPage = bookService.getBookEntityPage(pageable);

        // ----- 存在しないページ番号を指定された場合の対応 -----
        if (pageable.getPageNumber() < 0
                || bookEntityPage.getTotalPages() <= pageable.getPageNumber()) {
            model.addAttribute("bookEntityPage", bookEntityPage);
            return "/books/index";
        }

        // ----- 画面へ書籍情報を渡す -----
        model.addAttribute("bookEntityPage", bookEntityPage);
        return "/books/index";
    }

    /*
     * 書籍詳細画面を表示する
     */
    @GetMapping("{uuid}")
    public String detail(@PathVariable("uuid") UUID uuid, Model model) {
        var bookEntity = bookService.showBookEntity(uuid);

        model.addAttribute(bookEntity);

        return "/books/detail";
    }

    /*
     * 書籍登録画面を表示する
     */
    @GetMapping("new")
    public String create(Model model) {
        var bookForm = new BookForm();
        model.addAttribute(bookForm);
        return "/books/new";
    }

    /*
     * 書籍情報を登録する
     */
    @PostMapping("")
    public String insert(@ModelAttribute("bookForm") BookForm bookForm, BindingResult bindingResult) {
        var bookEntity = bookHelper.toBookEntity(bookForm);

        bookService.insertBookEntity(bookEntity);

        return "redirect:/books";
    }

    @GetMapping("edit/{uuid}")
    public String edit(@PathVariable("uuid") UUID uuid, Model model) {
        var bookEntity = bookService.showBookEntity(uuid);
        var bookForm = new BookForm();
        bookForm.setUuid(bookEntity.getUuid());
        bookForm.setTitle(bookEntity.getTitle());
        bookForm.setSortOrder(bookEntity.getSortOrder());

        model.addAttribute(bookForm);

        return "/books/edit";
    }

    @PutMapping("{uuid}")
    public String update(@PathVariable("uuid") UUID uuid, @ModelAttribute("bookForm") BookForm bookForm, BindingResult bindingResult) {
        var bookEntity = bookHelper.toBookEntity(bookForm);

        bookService.updateBookEntity(uuid, bookEntity);

        return "redirect:/books";
    }

    @DeleteMapping("{uuid}")
    public String delete(@PathVariable("uuid") UUID uuid) {
        bookService.deleteBookEntity(uuid);

        return "redirect:/books";
    }
}
