package offline.coding.evaluation.falabella.entities;

public class ProductMock {
    public static Product getCorrect() {
        Product product = new Product();
        product.setSKU("DUMMY");
        product.setName("DUMMY");
        product.setBrand("DUMMY");
        product.setPrice(10.0f);
        product.setSize("S");
        product.setPrincipalImage("DUMMY");
        return product;
    }
}
