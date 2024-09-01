package com.leon.gestion.persitence;

import com.leon.gestion.domain.Product;
import com.leon.gestion.domain.repository.ProductRepository;
import com.leon.gestion.persitence.crud.ProductoCrudRepository;
import com.leon.gestion.persitence.entity.Producto;
import com.leon.gestion.persitence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productosCategoria = productoCrudRepository.findByIdCategoriaOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProducts(productosCategoria));
    }

    @Override
    public Optional<List<Product>> getScarse(int quantity) {
        Optional<List<Producto>> productosScarse = productoCrudRepository.findByStockUnidadesLessThan(quantity);
        return productosScarse.map(productos -> productMapper.toProducts(productos));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> productMapper.toProduct(producto));

    }

    @Override
    public Optional<List<Product>> lessPriceUnit(double price, int stock) {
        Optional<List<Producto>> productosBajos= productoCrudRepository.findByPriceLessThanAndStockUnidadesLessThan(price, stock);
        return productosBajos.map(productos -> productMapper.toProducts(productos));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }


    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
