package bookmanagement.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

        var bookEntity = bookService.saveBookEntity(bookForm);

        return "redirect:/";
    }
}
