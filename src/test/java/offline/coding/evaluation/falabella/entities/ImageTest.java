package offline.coding.evaluation.falabella.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageTest {
    @Test
    public void testGetterAndSetter() {
        Product product = new Product();
        Image image = new Image();
        image.setImageId(10);
        image.setImage("DUMMY");
        image.setProduct(product);
        assertEquals(10, image.getImageId());
        assertEquals("DUMMY", image.getImage());
        assertEquals(product, image.getProduct());
    }
}
