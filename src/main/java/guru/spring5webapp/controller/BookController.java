package guru.spring5webapp.controller;

import guru.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by shifengyuan.
 * Date: 2018/6/22
 * Time: 21:23
 */

@Controller
public class BookController {

    private final BookRepository bookRepository;


    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());
        return "book";
    }
}
