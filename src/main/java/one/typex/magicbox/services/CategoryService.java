package one.typex.magicbox.services;

import one.typex.magicbox.dto.CategoriesDto;
import one.typex.magicbox.entities.Category;
import one.typex.magicbox.repositories.CategoryRepo;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CategoryService {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

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
                                getColorHexString(it.getColor())
                        )
                ).toList();
    }

    private String getColorHexString(byte[] colorByte) {
        char[] hexChars = new char[colorByte.length * 2];
        for (int j = 0; j < colorByte.length; j++) {
            int v = colorByte[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public void addCategories(List<CategoriesDto> categoriesDto) {
        for (var categoryDto: categoriesDto) {
            var category = new Category();
            category.setName(categoryDto.getName());
            var color = categoryDto.getColor();
            color = color.substring(1);
            category.setColor(color.getBytes(StandardCharsets.UTF_8));
            categoryRepo.save(category);
        }
    }
}
