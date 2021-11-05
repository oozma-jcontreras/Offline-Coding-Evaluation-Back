package offline.coding.evaluation.falabella.controllers;

import offline.coding.evaluation.falabella.dto.ProductDto;
import offline.coding.evaluation.falabella.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{sku}")
    public ResponseEntity<ProductDto> getProductBySku(@PathVariable(value = "sku") String sku) {
        try {
            return new ResponseEntity<>(productService.findBySku(sku), HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity addNewProduct(@Valid @RequestBody ProductDto product) {
        try {
            productService.insert(product);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity updateProduct(@Valid @RequestBody ProductDto product) {
        try {
            productService.update(product);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity removeProduct(@PathVariable(value = "sku") String sku) {
        try {
            productService.remove(sku);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
