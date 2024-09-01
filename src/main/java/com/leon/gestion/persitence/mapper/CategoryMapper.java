package com.leon.gestion.persitence.mapper;

import com.leon.gestion.domain.Category;
import com.leon.gestion.persitence.entity.Categorias;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategorias", target = "categoryId"),
            @Mapping(source = "name", target = "category"),
            @Mapping(source = "descripcion", target = ""),
            @Mapping(source = "creadoEn",target = ""),
            @Mapping(source = "actualizadoEn",target = ""),
    })
    Category toCategory (Categorias categorias);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categorias toCategorias (Category category);
}
