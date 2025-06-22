package ma.youhad.productspringmcv;

import ma.youhad.productspringmcv.entities.Product;
import ma.youhad.productspringmcv.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class ProductSpringMcvApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductSpringMcvApplication.class, args);
    }

    @Bean
    public CommandLineRunner commmandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(4566)
                    .quantity(5)
                    .build());
            productRepository.save(Product.builder()
                    .name("Phone")
                    .price(3423)
                    .quantity(88)
                    .build());
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(4226)
                    .quantity(12)
                    .build());
            productRepository.findAll().forEach(product -> System.out.println(product.toString()));
        };
    }

}
