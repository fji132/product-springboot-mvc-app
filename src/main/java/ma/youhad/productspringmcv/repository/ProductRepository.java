package ma.youhad.productspringmcv.repository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ma.youhad.productspringmcv.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    List<Product> searchByNameContaining(@NotEmpty @Size(min = 3, max = 50) String name);
}
