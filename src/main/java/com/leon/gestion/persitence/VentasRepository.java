package com.leon.gestion.persitence;

import com.leon.gestion.domain.Sales;
import com.leon.gestion.domain.repository.SaleRepository;
import com.leon.gestion.persitence.crud.VentasCrudRepository;
import com.leon.gestion.persitence.entity.Ventas;
import com.leon.gestion.persitence.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class VentasRepository implements SaleRepository {

    @Autowired
    private VentasCrudRepository ventasCrudRepository;
    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<Sales> getAll() {
        return saleMapper.toSales((List<Ventas>) ventasCrudRepository.findAll());
    }

    @Override
    public Optional<List<Sales>> getByCustomers(String customerId) {
        return ventasCrudRepository.findByClienteId(customerId).
                map(ventas -> saleMapper.toSales(ventas));
    }

    @Override
    public Sales save(Sales sales) {
        Ventas ventas = saleMapper.toVenta(sales);

        ventas.getVentasProductos().forEach(ventasProductos -> ventasProductos.setVentas(ventas));
        return saleMapper.toSale(ventasCrudRepository.save(ventas));
    }



    /*public Optional<List<Ventas>> menorMontoVendido(BigDecimal montoAcumulado, String status){
        return ventasCrudRepository.findByMontoAcumuladoLessThanAndStatus(montoAcumulado, status);
    }*/
}
