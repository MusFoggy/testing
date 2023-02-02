package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Order;
import ua.com.testing.entity.Roles;

@Repository

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
