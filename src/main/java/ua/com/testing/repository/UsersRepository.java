package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Users;

import java.util.List;
import java.util.Map;

@Repository

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByUsernameAndPassword(String username, String pass);

    Users findByUsernameAndPassword(String user, String pass);
}
