package one.typex.magicbox.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/")
public class ApiController {

    @GetMapping("categories")
    public void getCategories() {

    }
}
