package com.leon.gestion.domain.repository;

import com.leon.gestion.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarse(int quantity);
    Optional<Product> getProduct(int productId);
    Optional<List<Product>> lessPriceUnit(double price, int stock);
    Product save(Product product);
    void delete(int productId);

}
