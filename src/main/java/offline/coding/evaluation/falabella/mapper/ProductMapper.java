package offline.coding.evaluation.falabella.mapper;

import offline.coding.evaluation.falabella.dto.ProductDto;
import offline.coding.evaluation.falabella.entities.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDto productEntityToProductDto(Product product);
    Product productDtoToProductEntity(ProductDto product);
}