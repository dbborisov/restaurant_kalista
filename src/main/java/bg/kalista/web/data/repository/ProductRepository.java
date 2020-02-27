package bg.kalista.web.data.repository;

import bg.kalista.web.data.entity.Details;
import bg.kalista.web.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product findByProductName(String name);

    List<Product> findByCategoryName(String categoryName);
    Product findByCategoryNameAndSpecificationName(String categoryName,String specificationName);

    Product findByCategoryNameAndProductName(String categoryName,String productName);

}
