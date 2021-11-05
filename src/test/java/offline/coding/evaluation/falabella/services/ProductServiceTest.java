package offline.coding.evaluation.falabella.services;

import offline.coding.evaluation.falabella.dto.ProductDto;
import offline.coding.evaluation.falabella.dto.ProductDtoMock;
import offline.coding.evaluation.falabella.entities.Product;
import offline.coding.evaluation.falabella.entities.ProductMock;
import offline.coding.evaluation.falabella.exceptions.DoNotExistsException;
import offline.coding.evaluation.falabella.mapper.ProductMapper;
import offline.coding.evaluation.falabella.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    @InjectMocks
    private ProductService productService;

    @Test
    public void tesFindAllProducts() {
        List<ProductDto> expected = new ArrayList<>();
        ProductDto productDto = ProductDtoMock.getCorrect();
        expected.add(productDto);

        List<Product> expectedFromBd = new ArrayList<>();
        Product product = ProductMock.getCorrect();
        expectedFromBd.add(product);

        when(productRepository.findAll()).thenReturn(expectedFromBd);
        when(productMapper.productEntityToProductDto(product)).thenReturn(productDto);
        assertEquals(expected, productService.findAll());
    }

    @Test
    public void findProductDtoGivenASku() throws DoNotExistsException {
        String sku = "DUMMY";
        ProductDto productDto = ProductDtoMock.getCorrect();
        Product product = ProductMock.getCorrect();
        Optional<Product> optionalProduct = Optional.of(product);
        when(productRepository.findById(sku)).thenReturn(optionalProduct);
        when(productMapper.productEntityToProductDto(optionalProduct.get())).thenReturn(productDto);
        ProductDto actualProductDto = productService.findBySku(sku);
        assertNotNull(actualProductDto);
        assertEquals(productDto, actualProductDto);
    }

    @Test
    public void throwDoNotExistsExceptionWhenSkuDoNotExists() {
        String sku = "DUMMY";
        Optional<Product> optionalProduct = Optional.empty();
        when(productRepository.findById(sku)).thenReturn(optionalProduct);
        DoNotExistsException exception = assertThrows(DoNotExistsException.class, () -> {
            productService.findBySku(sku);
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void insertProductGivenAProductDto() {
        ProductDto productDto = ProductDtoMock.getCorrect();
        Product product = ProductMock.getCorrect();
        when(productMapper.productDtoToProductEntity(productDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        productService.insert(productDto);
    }

    @Test
    public void updateProductGivenAProductDto() throws DoNotExistsException {
        ProductDto productDto = ProductDtoMock.getCorrect();
        Product product = ProductMock.getCorrect();
        Optional<Product> optionalProduct = Optional.of(product);
        when(productRepository.findById(productDto.getSKU())).thenReturn(optionalProduct);
        when(productMapper.productDtoToProductEntity(productDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        productService.update(productDto);
    }

    @Test
    public void removeProductGivenASku() throws DoNotExistsException {
        String sku = "DUMMY";
        Product product = ProductMock.getCorrect();
        Optional<Product> optionalProduct = Optional.of(product);
        when(productRepository.findById(sku)).thenReturn(optionalProduct);
        doNothing().when(productRepository).deleteById(sku);
        productService.remove(sku);
    }
}
