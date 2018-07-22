package guru.spring5webapp.controller;

import guru.spring5webapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shifengyuan.
 * Date: 2018/6/23
 * Time: 10:19
 */

@Component
public class MyController {

    @Autowired
    private GreetingService greetingService;

    public void hello() {

        greetingService.greeting();
    }
}
