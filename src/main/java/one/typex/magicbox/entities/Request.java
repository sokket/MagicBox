package one.typex.magicbox.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "category_id")
    @JoinColumn(table = "categories", name = "id")
    private long categoryId;

    private String summary;
    private String content;

    @Column(name = "created_at")
    private Timestamp createdAt;

    private double lon;
    private double lat;
}
