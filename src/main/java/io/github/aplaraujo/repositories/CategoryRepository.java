package io.github.aplaraujo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.aplaraujo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
