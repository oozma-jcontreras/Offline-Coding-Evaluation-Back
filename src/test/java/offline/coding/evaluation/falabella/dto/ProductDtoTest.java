package offline.coding.evaluation.falabella.dto;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.*;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductDtoTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    private final static String SKU_ERROR_MESSAGE = "SKU is required";
    private final static String NAME_ERROR_MESSAGE = "Product name is required";
    private final static String BRAND_ERROR_MESSAGE = "Product brand is required";
    private final static String SIZE_ERROR_MESSAGE = "Product size is required";
    private final static String PRICE_ERROR_MESSAGE = "Product price is required";
    private final static String IMAGE_ERROR_MESSAGE = "Principal image is required";

    @Test
    public void returnViolationsWhenProductDtoHasNullValuesInFields() {
        ProductDto productDto = ProductDto.builder().build();
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertEquals(6, violations.size());
    }

    @Test
    public void returnViolationsWhenProductDtoPriceIsOutOfRange() {
        ProductDto productDto = ProductDto.builder()
                .SKU("XXXXXX")
                .name("DUMMY")
                .brand("DUMMY")
                .price(0f)
                .size("S")
                .principalImage("DUMMY").build();
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertEquals(1, violations.size());
    }

    @Test
    public void returnEmptyViolationsWhenProductDtoHasCorrectValuesInFields() {
        ProductDto productDto = ProductDto.builder()
                .SKU("XXXXXX")
                .name("DUMMY")
                .brand("DUMMY")
                .price(10.0f)
                .size("S")
                .principalImage("DUMMY").build();
        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertTrue(violations.isEmpty());
    }
}
