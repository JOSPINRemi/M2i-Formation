package org.example.demo.service;

import org.example.demo.dto.ProductDto;
import org.example.demo.model.Product;
import org.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(String name, Double price) {
        Product product = Product.builder()
                .name(name)
                .price(price)
                .build();
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new RuntimeException("Not found");
    }

    public Product update(Long id, ProductDto productDto) {
        return productRepository.save(
                Product.builder()
                        .id(id)
                        .name(productDto.getName())
                        .price(productDto.getPrice())
                        .build()
        );
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
