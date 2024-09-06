package com.leon.gestion.persitence.crud;

import com.leon.gestion.persitence.entity.Compras;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compras, Integer> {
    Optional<List<Compras>> findByProveedorId(int proveedorId);
}
