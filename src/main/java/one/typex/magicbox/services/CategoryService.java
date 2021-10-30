package one.typex.magicbox.services;

import one.typex.magicbox.dto.CategoriesDto;
import one.typex.magicbox.entities.Category;
import one.typex.magicbox.repositories.CategoryRepo;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<CategoriesDto> getAll() {
        return categoryRepo.findAll()
                .stream().map(it ->
                        new CategoriesDto(
                                it.getId(),
                                it.getName(),
                                new String(it.getColor(), StandardCharsets.UTF_8)
                        )
                ).toList();
    }


    public void addCategories(List<CategoriesDto> categoriesDto) {
        for (var categoryDto : categoriesDto) {
            var category = new Category();
            category.setName(categoryDto.getName());
            var color = categoryDto.getColor();
            category.setColor(color.getBytes(StandardCharsets.UTF_8));
            categoryRepo.save(category);
        }
    }
}
