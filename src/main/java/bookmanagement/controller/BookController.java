package bookmanagement.controller;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bookmanagement.form.BookForm;
import bookmanagement.service.BookService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public String home(Model model, Pageable pageable) {
        // ----- 書籍情報の取得 -----
        var bookEntityPage = bookService.getBookEntityPage(pageable);

        // ----- 存在しないページ番号を指定された場合の対応 -----
        if (pageable.getPageNumber() < 0
                || bookEntityPage.getTotalPages() <= pageable.getPageNumber()) {
            return "redirect:/";
        }

        // ----- 画面へ書籍情報を渡す -----
        model.addAttribute("bookEntityPage", bookEntityPage);
        return "index";
    }

    @GetMapping("/show/{uuid}")
    public String show(@PathVariable("uuid") UUID uuid, Model model) {
        // debug
        System.out.println("***** Start BookController#show");
        System.out.println("***** uuid:" + uuid.toString());

        var bookEntity = bookService.showBookEntity(uuid);
        // debug
        System.out.println("***** bookEntity.getUuid()  : " + bookEntity.getUuid());
        System.out.println("***** bookEntity.getTitle() : " + bookEntity.getTitle());

        model.addAttribute(bookEntity);

        // 暫定的にトップへリダイレクト
        return "show";
    }


    @GetMapping("/create")
    public String create(Model model) {
        // debug
        System.out.println("***** Start BookController#create");

        var bookForm = new BookForm();
        model.addAttribute(bookForm);
        return "create";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute("bookForm") BookForm bookForm, BindingResult bindingResult) {
        // debug
        System.out.println("***** Start BookController#insert");

        bookService.saveBookEntity(bookForm);

        return "redirect:/";
    }

    @GetMapping("/edit/{uuid}")
    public String edit(@PathVariable("uuid") UUID uuid, Model model) {
        // debug
        System.out.println("***** Start BookController#edit");

        var bookEntity = bookService.showBookEntity(uuid);
        var bookForm = new BookForm();
        bookForm.setUuid(bookEntity.getUuid());
        bookForm.setTitle(bookEntity.getTitle());
        bookForm.setSortOrder(bookEntity.getSortOrder());

        model.addAttribute(bookForm);

        return "edit";
    }

    @PostMapping("/update/{uuid}")
    public String update(@PathVariable("uuid") UUID uuid, @ModelAttribute("bookForm") BookForm bookForm, BindingResult bindingResult) {
        // debug
        System.out.println("***** Start BookController#update");

        bookService.updateBookEntity(uuid, bookForm);

        return "redirect:/";
    }

    @PostMapping("/delete/{uuid}")
    public String delete(@PathVariable("uuid") UUID uuid) {
        // debug
        System.out.println("***** Start BookController#delete");

        bookService.deleteBookEntity(uuid);

        return "redirect:/";
    }
}
