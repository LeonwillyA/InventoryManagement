package com.leon.gestion.persitence.mapper;

import com.leon.gestion.domain.Purchases;
import com.leon.gestion.persitence.entity.Compras;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchasesItemMapper.class})
public interface PurchasesMapper {

    @Mappings({
            @Mapping(source = "compraId", target = "purchaseId"),
            @Mapping(source = "fechaCompra", target = "datePurchase"),
            @Mapping(source = "proveedorId", target = "supplierId"),
            @Mapping(source = "montoAcumulado", target = "totalAmount"),
            @Mapping(source = "creadoEn", target = "createdAt"),
            @Mapping(source = "actualizadoEn", target = "updatedAt"),
            @Mapping(source = "comprasProductos", target = "purchasesItems")
    })
    Purchases toPurchases(Compras compras);
    List<Purchases> toPurchasess (List<Compras> comprasList);

    @InheritInverseConfiguration
    @Mapping(target = "proveedores", ignore = true)
    Compras toCompra(Purchases purchases);
}
