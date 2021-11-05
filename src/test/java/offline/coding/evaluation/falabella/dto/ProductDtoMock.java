package offline.coding.evaluation.falabella.dto;

public class ProductDtoMock {
    public static ProductDto getCorrect() {
        return ProductDto.builder()
                .SKU("XXXXXX")
                .name("DUMMY")
                .brand("DUMMY")
                .price(10.0f)
                .size("S")
                .principalImage("DUMMY").build();
    }
}
