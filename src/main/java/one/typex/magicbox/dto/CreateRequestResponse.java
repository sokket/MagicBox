package one.typex.magicbox.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CreateRequestResponse {
    private long id;
    private Timestamp createdAt;
}
