package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.testing.entity.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsernameAndPassword(String username, String password);

    Optional<Users> findByUsername(String username);

}
