package one.typex.magicbox.dto;

import lombok.Data;

@Data
public class CreateRequestDto {
    private String summary;
    private String text;
    private CoordinateDto coordinate;
}
