package offline.coding.evaluation.falabella.services;

import offline.coding.evaluation.falabella.dto.ProductDto;
import offline.coding.evaluation.falabella.entities.Product;
import offline.coding.evaluation.falabella.exceptions.DoNotExistsException;
import offline.coding.evaluation.falabella.mapper.ProductMapper;
import offline.coding.evaluation.falabella.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    public static final String PRODUCT_DO_NOT_EXISTS_MESSAGE = "Product SKU %s do not exists";

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> findAll() {
        List<ProductDto> finalResult = new ArrayList<>();
        Iterable<Product> resultFromDataBase = productRepository.findAll();
        resultFromDataBase.forEach(data -> {
            finalResult.add(productMapper.productEntityToProductDto(data));
        });
        return finalResult;
    }

    public ProductDto findBySku(String sku) throws DoNotExistsException {
        Optional<Product> actualProduct = productRepository.findById(sku);
        if(!actualProduct.isPresent())
            throw new DoNotExistsException(String.format(PRODUCT_DO_NOT_EXISTS_MESSAGE, sku));
        return productMapper.productEntityToProductDto(actualProduct.get());
    }

    public void insert(ProductDto product) {
        productRepository.save(productMapper.productDtoToProductEntity(product));
    }

    public void update(ProductDto product) throws DoNotExistsException {
        if(!productRepository.findById(product.getSKU()).isPresent())
            throw new DoNotExistsException(String.format(PRODUCT_DO_NOT_EXISTS_MESSAGE, product.getSKU()));
        productRepository.save(productMapper.productDtoToProductEntity(product));
    }

    public void remove(String sku) throws DoNotExistsException {
        if(!productRepository.findById(sku).isPresent())
            throw new DoNotExistsException(String.format(PRODUCT_DO_NOT_EXISTS_MESSAGE, sku));
        productRepository.deleteById(sku);
    }
}
