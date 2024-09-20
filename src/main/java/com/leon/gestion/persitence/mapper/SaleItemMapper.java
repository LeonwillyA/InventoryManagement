package com.leon.gestion.persitence.mapper;

import com.leon.gestion.domain.SalesItem;
import com.leon.gestion.persitence.entity.VentasProductos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.xml.transform.Source;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SaleItemMapper {
    @Mappings({
            @Mapping(source = "id.productosId", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "precioUnitario", target = "priceUnit"),
            @Mapping(source = "creadoEn", target = "createdAt"),
            @Mapping(source = "actualizadoEn", target = "updatedAt")

    })
    SalesItem toSaleItem(VentasProductos ventasProductos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "ventas", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.ventasId", ignore = true)
    })
    VentasProductos toVentaProducto(SalesItem salesItem);
}
