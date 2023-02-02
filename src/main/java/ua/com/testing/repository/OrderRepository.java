package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Category;
import ua.com.testing.entity.Order;

@Repository

public interface OrderRepository extends JpaRepository<Order, Long> {
}
