package bookmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookManagementController {

    @GetMapping("/")
    public String index() {
        return "/index";
    }
}
