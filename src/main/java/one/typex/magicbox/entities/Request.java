package one.typex.magicbox.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String summary;
    private String text;

    @OneToOne
    private Coordinate coordinate;
}
