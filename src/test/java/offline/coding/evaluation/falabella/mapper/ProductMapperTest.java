package offline.coding.evaluation.falabella.mapper;

import offline.coding.evaluation.falabella.dto.ProductDto;
import offline.coding.evaluation.falabella.entities.Product;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductMapperTest {
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    public void mapProductDtoToProduct() {
        ProductDto productDto = ProductDto.builder()
                .SKU("XXXXXX")
                .name("DUMMY")
                .brand("DUMMY")
                .price(10.0f)
                .size("S")
                .principalImage("DUMMY").build();
        Product product = productMapper.productDtoToProductEntity(productDto);
        assertNotNull(product);
        assertEquals(productDto.getSKU(), product.getSKU());
        assertEquals(productDto.getName(), product.getName());
        assertEquals(productDto.getBrand(), product.getBrand());
        assertEquals(productDto.getPrice(), product.getPrice());
        assertEquals(productDto.getSize(), product.getSize());
        assertEquals(productDto.getPrincipalImage(), product.getPrincipalImage());
    }

    @Test
    public void mapProductToProductDto() {
        Product product = new Product();
        product.setSKU("XXXXXX");
        product.setName("DUMMY");
        product.setBrand("DUMMY");
        product.setPrice(10.0f);
        product.setSize("S");
        product.setPrincipalImage("DUMMY");
        ProductDto productDto = productMapper.productEntityToProductDto(product);
        assertNotNull(product);
        assertEquals(product.getSKU(), productDto.getSKU());
        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getBrand(), productDto.getBrand());
        assertEquals(product.getPrice(), productDto.getPrice());
        assertEquals(product.getSize(), productDto.getSize());
        assertEquals(product.getPrincipalImage(), productDto.getPrincipalImage());
    }
}
