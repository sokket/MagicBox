package one.typex.magicbox.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RequestDto {
    private long requestId;
    private String requestSummary;
    private Timestamp requestCreationDate;
    private CoordinateDto coordinate;

    public RequestDto(long requestId, String requestSummary, Timestamp requestCreationDate, CoordinateDto coordinate) {
        this.requestId = requestId;
        this.requestSummary = requestSummary;
        this.requestCreationDate = requestCreationDate;
        this.coordinate = coordinate;
    }
}
