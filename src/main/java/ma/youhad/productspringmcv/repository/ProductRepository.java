package ma.youhad.productspringmcv.repository;

import ma.youhad.productspringmcv.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {
}
