package offline.coding.evaluation.falabella.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Products")
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    @Id
    @Column
    private String SKU;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String brand;
    @Column
    private String size;
    @Column
    private float price;
    @Column(length = 500)
    private String principalImage;
    @OneToMany(mappedBy = "product")
    private List<Image> otherImages;
}
