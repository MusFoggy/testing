package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Roles;
import ua.com.testing.entity.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student, Long> {
}
