package com.leon.gestion.persitence;

import com.leon.gestion.persitence.crud.VentasCrudRepository;
import com.leon.gestion.persitence.entity.Ventas;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class VentasRepository {
    private VentasCrudRepository ventasCrudRepository;

    public Optional<List<Ventas>> menorMontoVendido(BigDecimal montoAcumulado, String status){
        return ventasCrudRepository.findByMontoAcumuladoLessThanAndStatus(montoAcumulado, status);
    }
}
