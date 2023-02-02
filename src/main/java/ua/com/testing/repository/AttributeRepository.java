package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Attribute;
import ua.com.testing.entity.Attributehastest;

@Repository

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
