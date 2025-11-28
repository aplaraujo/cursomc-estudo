package io.github.aplaraujo.services;

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
}
