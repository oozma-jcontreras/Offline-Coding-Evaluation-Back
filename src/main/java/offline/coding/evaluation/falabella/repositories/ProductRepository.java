package offline.coding.evaluation.falabella.repositories;

import offline.coding.evaluation.falabella.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {  }
