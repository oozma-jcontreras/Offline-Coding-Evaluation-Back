package offline.coding.evaluation.falabella.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ProductImages")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Image {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int imageId;
    @Column(length = 500)
    private String image;
}
