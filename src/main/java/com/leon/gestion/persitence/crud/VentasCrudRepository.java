package com.leon.gestion.persitence.crud;

import com.leon.gestion.persitence.entity.Ventas;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface VentasCrudRepository extends CrudRepository<Ventas, Integer> {
    Optional<List<Ventas>> findByMontoAcumuladoLessThanAndStatus(BigDecimal montoAcumulado, String status);
}
