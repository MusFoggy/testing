package ua.com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.Category;
import ua.com.testing.entity.Question;
import ua.com.testing.entity.Test;
import ua.com.testing.repository.TestRepository;
import ua.com.testing.repository.QuestionRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TestService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TestRepository testRepository;

    // Метод для отримання всіх тестів
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    // Метод для отримання всіх тестів за категорією
    public List<Test> getAllTestsByCategory(Category category) {
        return testRepository.findByCategory(category);
    }

    // Метод для отримання тесту за його ідентифікатором
    public Test getTestById(Long id) {
        return testRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Test not found"));
    }

    // Метод для оновлення тесту
    public Test updateTest(Long id, Test test) {
        Test existingTest = getTestById(id);
        existingTest.setName(test.getName());
        existingTest.setDescription(test.getDescription());
        existingTest.setPoints(test.getPoints());
        existingTest.setImage(test.getImage());
        existingTest.setCategory(test.getCategory());
        return testRepository.save(existingTest);
    }

    // Метод для видалення тесту за його ідентифікатором
    public void deleteById(Long id) {
        testRepository.deleteById(id);
    }

    // Метод для створення тесту з питаннями
    public Test createTestWithQuestions(Test test, List<Question> questions) {
        Test savedTest = testRepository.save(test);
        questions.forEach(question -> question.setTest(savedTest));
        questionRepository.saveAll(questions);
        return savedTest;
    }

    // Метод для отримання тестів за ідентифікатором категорії
    public List<Test> getTestsByCategoryId(Long categoryId) {
        return testRepository.findByCategoryId(categoryId);
    }
}

