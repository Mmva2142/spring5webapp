package guru.spring5webapp.controller;

import guru.spring5webapp.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by shifengyuan.
 * Date: 2018/6/23
 * Time: 23:08
 */

@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping({"/joke","/chucknorris"})
    public String showJoke(Model model){

        model.addAttribute("joke", jokeService.getJoke());
        return "joke";
    }

}
