package one.typex.magicbox.controllers;

import one.typex.magicbox.dto.CategoriesDto;
import one.typex.magicbox.dto.CreateRequestDto;
import one.typex.magicbox.dto.CreateRequestResponse;
import one.typex.magicbox.dto.RequestDto;
import one.typex.magicbox.services.CategoryService;
import one.typex.magicbox.services.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ApiController {

    private final CategoryService categoryService;
    private final RequestService requestService;

    public ApiController(CategoryService categoryService, RequestService requestService) {
        this.categoryService = categoryService;
        this.requestService = requestService;
    }

    @GetMapping("categories")
    public List<CategoriesDto> getCategories() {
        return categoryService.getAll();
    }


    @GetMapping("points")
    public List<RequestDto> getPointsByCategory(@RequestParam("category") long category) {
        return requestService.getPointsByCategory(category);
    }

    @GetMapping("requestsText/{id}")
    public String getRequestText(@PathVariable("id") long id) {
        return requestService.getTextById(id);
    }

    @PostMapping("createRequest")
    public HttpStatus createRequest(@RequestBody CreateRequestDto newRequest) {
        requestService.createRequest(newRequest);
        return HttpStatus.CREATED;
    }
}
