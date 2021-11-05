package offline.coding.evaluation.falabella.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    public void testGetterAndSetter() {
        Product product = new Product();
        product.setSKU("DUMMY");
        product.setName("DUMMY");
        product.setBrand("DUMMY");
        product.setPrice(10.0f);
        product.setSize("S");
        product.setPrincipalImage("DUMMY");
        assertEquals("DUMMY", product.getSKU());
        assertEquals("DUMMY", product.getName());
        assertEquals("DUMMY", product.getBrand());
        assertEquals(10.0f, product.getPrice());
        assertEquals("S", product.getSize());
        assertEquals("DUMMY", product.getPrincipalImage());
    }
}
