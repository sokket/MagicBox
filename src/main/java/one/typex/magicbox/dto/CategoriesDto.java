package one.typex.magicbox.dto;

import lombok.Data;

@Data
public class CategoriesDto {
    private long id;
    private String name;
    private String color;

    public CategoriesDto(long id, String name, String colorHexString) {
        this.id = id;
        this.name = name;
        this.color = colorHexString;
    }
}
