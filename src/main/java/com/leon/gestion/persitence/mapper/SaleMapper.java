package com.leon.gestion.persitence.mapper;

import com.leon.gestion.domain.Sales;
import com.leon.gestion.persitence.entity.Ventas;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SaleItemMapper.class})
public interface SaleMapper  {

    @Mappings({
            @Mapping(source = "idVentas", target = "salesId"),
            @Mapping(source = "fechaVenta", target = "dateSale"),
            @Mapping(source = "clienteId", target = "customerId"),
            @Mapping(source = "montoAcumulado", target = "totalAmount"),
            @Mapping(source = "creadoEn", target = "createdAt"),
            @Mapping(source = "actualizadoEn", target = "updatedAt"),
            @Mapping(source = "ventasProductos", target = "salesItems")
    })
    Sales toSale(Ventas ventas);
    List<Sales> toSales(List<Ventas> ventass);

    @InheritInverseConfiguration
    @Mapping(target = "clientes", ignore = true)
    Ventas toVenta(Sales sales);

}
