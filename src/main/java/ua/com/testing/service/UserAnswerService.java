package ua.com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.UserAnswer;
import ua.com.testing.entity.Users;
import ua.com.testing.entity.Test;
import ua.com.testing.entity.Question;
import ua.com.testing.repository.TestRepository;
import ua.com.testing.repository.UserAnswerRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserAnswerService {
    @Autowired
    private UserService userService;
    @Autowired
    private TestRepository testRepository;

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public List<UserAnswer> findAllByUser(Users user) {

        return userAnswerRepository.findAllByUser(user);
    }

    public List<UserAnswer> findAllByTest(Test test) {

        return userAnswerRepository.findAllByTest(test);
    }

    public List<UserAnswer> findAllByQuestion(Question question) {
        return userAnswerRepository.findAllByQuestion(question);
    }
    public List<UserAnswer> getAllUserAnswers() {
        return userAnswerRepository.findAll();
    }


    public UserAnswer saveUserAnswer(UserAnswer userAnswer) {

        return userAnswerRepository.save(userAnswer);
    }

    public Users getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<UserAnswer> getAllUserAnswersByUser(Users user) {

        return userAnswerRepository.findAllByUser(user);
    }
    public void deleteUserAnswersByUserAndTest(String username, String testName) {
        Users user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Test test = testRepository.findByName(testName)
                .orElseThrow(() -> new NoSuchElementException("Test not found"));

        List<UserAnswer> userAnswersToDelete = userAnswerRepository.findAllByUserAndTest(user, test);
        userAnswerRepository.deleteAll(userAnswersToDelete);
    }
}


