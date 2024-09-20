package com.leon.gestion.persitence.mapper;

import com.leon.gestion.domain.PurchasesItem;
import com.leon.gestion.persitence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchasesItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "precioUnitario", target = "total"),
            @Mapping(source = "creadoEn", target = "createdAt"),
            @Mapping(source = "actualizadoEn", target = "updatedAt")
    })
    PurchasesItem toPurchaseItem(ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compras", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompras", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchasesItem purchasesItem);
}
