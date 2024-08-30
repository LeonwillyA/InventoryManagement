package com.leon.gestion.persitence.crud;

import com.leon.gestion.persitence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByNameAsc(int idCategoria);

    Optional<List<Producto>> findByStockUnidadesLessThan(int stockUnidades);

    Optional<List<Producto>> findByPriceLessThanAndStockUnidadesLessThan(double price, int stockUnidades);
}
