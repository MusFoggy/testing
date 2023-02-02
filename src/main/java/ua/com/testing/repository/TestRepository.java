package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Student;
import ua.com.testing.entity.Test;

@Repository

public interface TestRepository extends JpaRepository<Test, Long> {
}
