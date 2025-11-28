package io.github.aplaraujo.controllers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.aplaraujo.controllers.dto.CategoryDTO;
import io.github.aplaraujo.entities.Category;

@Mapper(componentModel="spring")
public interface CategoryMapper {
    @Mapping(source="name", target="name")
    Category toEntity(CategoryDTO dto);
    CategoryDTO toDTO(Category entity);
}
