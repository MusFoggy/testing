package ua.com.testing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Category;

import java.util.List;

@Repository

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameStartingWithIgnoreCase(String query);
    List<Category> findByNameContainingIgnoreCase(String name);
    Category findByName(String name);
}
