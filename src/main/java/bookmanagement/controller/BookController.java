package bookmanagement.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bookmanagement.service.BookService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public String home(Model model, Pageable pageable) {
        var bookEntityPage = bookService.getBookEntityPage(pageable);
        model.addAttribute("bookEntityPage", bookEntityPage);
        return "index";
    }
}
