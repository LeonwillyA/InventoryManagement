package com.leon.gestion.persitence.mapper;

import com.leon.gestion.domain.Product;
import com.leon.gestion.persitence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "precio", target = "price"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "stockUnidades", target = "stock"),
            @Mapping(source = "creadoEn", target = "createdAt"),
            @Mapping(source = "actualizadoEn", target = "updatedAt"),
            @Mapping(source = "categorias", target = "category"),
    })

    Product toProduct (Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "codigoBarras", ignore = true),
            @Mapping(target = "movimientoInventarios", ignore = true),
            @Mapping(target = "comprasProductos", ignore = true),
            @Mapping(target = "ventasProductos", ignore = true)
    })
    Producto toProducto(Product product);
}
