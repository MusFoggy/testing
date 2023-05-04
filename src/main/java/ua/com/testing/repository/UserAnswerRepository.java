package ua.com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import ua.com.testing.entity.Question;
import ua.com.testing.entity.Test;
import ua.com.testing.entity.UserAnswer;
import ua.com.testing.entity.Users;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
    List<UserAnswer> findAllByUser(Users user);

    List<UserAnswer> findAllByTest(Test test);

    List<UserAnswer> findAllByQuestion(Question question);
    List<UserAnswer> findAllByUserAndTest(Users user, Test test);

    List<UserAnswer> findAll();
}
