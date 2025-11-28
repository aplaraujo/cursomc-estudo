package io.github.aplaraujo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.aplaraujo.entities.Category;
import io.github.aplaraujo.repositories.CategoryRepository;
import io.github.aplaraujo.validators.CategoryValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryValidator categoryValidator;

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> search(String name) {
        if (name != null) {
            return categoryRepository.findByName(name);
        }

        return categoryRepository.findAll();
    }

    @SuppressWarnings("null")
    public Category insert(Category category) {
        categoryValidator.validate(category);
        return categoryRepository.save(category);
    }

    public void update(Category category) {
        if (category.getId() == null) {
            throw new IllegalArgumentException("Category not found!");
        }

        categoryValidator.validate(category);
        categoryRepository.save(category);
    }
}
