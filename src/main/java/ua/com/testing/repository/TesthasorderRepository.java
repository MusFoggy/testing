package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Test;
import ua.com.testing.entity.Testhasorder;

@Repository

public interface TesthasorderRepository extends JpaRepository<Testhasorder, Long> {
}
