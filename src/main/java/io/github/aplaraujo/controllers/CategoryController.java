package io.github.aplaraujo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.aplaraujo.controllers.dto.CategoryDTO;
import io.github.aplaraujo.controllers.mappers.CategoryMapper;
import io.github.aplaraujo.entities.Category;
import io.github.aplaraujo.services.CategoryService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value="/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping(value="/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("id") String id) {
        var categoryId = Long.parseLong(id);
        return categoryService.findById(categoryId).map(cat -> {
            CategoryDTO dto = categoryMapper.toDTO(cat);
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> search(@RequestParam(value="name", required=false) String name) {
        List<Category> list = categoryService.search(name);
        List<CategoryDTO> dto = list.stream().map(categoryMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }
}
