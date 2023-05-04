package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Category;
import ua.com.testing.entity.Student;
import ua.com.testing.entity.Test;

import java.util.List;
import java.util.Optional;

@Repository

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByCategory(Category category);
    List<Test> findByCategoryId(Long categoryId);
    Optional<Test> findByName(String name);

}
