package one.typex.magicbox.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/")
public class ApiController {

    @GetMapping("categories")
    public void getCategories() {

    }

    @PostMapping("createRequest")
    public void createRequest() {

    }

    @GetMapping("points")
    public void getPointsByCategory(@RequestParam("category") long category) {

    }

    @GetMapping("requestsText/{id}")
    public void getRequestText(@PathVariable("id") long id) {

    }
}
