package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Test;
import ua.com.testing.entity.Testhasquestion;

@Repository

public interface TesthasquestionRepository extends JpaRepository<Testhasquestion, Long> {
}
