package io.github.aplaraujo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.aplaraujo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
    Optional<Category> searchByName(String name);
}
