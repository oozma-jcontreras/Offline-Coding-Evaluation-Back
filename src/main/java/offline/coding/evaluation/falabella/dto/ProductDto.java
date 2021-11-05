package offline.coding.evaluation.falabella.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class ProductDto {
    @NotNull(message = "SKU is required")
    private String SKU;
    @NotBlank(message = "Product name is required")
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank(message = "Product brand is required")
    @Size(min = 3, max = 50)
    private String brand;
    @NotBlank(message = "Product size is required")
    private String size;
    @NotNull(message = "Product price is required")
    @Min(1)
    @Max(99999999)
    private float price;
    @NotBlank(message = "Principal image is required")
    private String principalImage;
    private List<String> otherImagesList;
}
