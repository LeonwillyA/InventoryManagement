package com.leon.gestion.persitence;

import com.leon.gestion.persitence.crud.ProductoCrudRepository;
import com.leon.gestion.persitence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNameAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByStockUnidadesLessThan(cantidad);
    }

    public Optional<List<Producto>> pocoPrecioUnidades (double price, int stockUnidades){
        return productoCrudRepository.findByPriceLessThanAndStockUnidadesLessThan(price, stockUnidades);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);

    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
