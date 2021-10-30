package one.typex.magicbox.dto;

import lombok.Data;

@Data
public class CoordinateDto {
    private double lon;
    private double lat;

    public CoordinateDto(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }
}
