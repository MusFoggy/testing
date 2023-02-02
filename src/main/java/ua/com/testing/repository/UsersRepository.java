package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Users;

@Repository

public interface UsersRepository extends JpaRepository<Users, Long> {
}
