package one.typex.magicbox.dto;

import lombok.Data;
import one.typex.magicbox.entities.Coordinate;

@Data
public class RequestDto {
    private String summary;
    private String text;
    private Coordinate coordinate;
}
