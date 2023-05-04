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

    public List<Test> getAllTests() {

        return testRepository.findAll();
    }
    public List<Test> getAllTestsByCategory(Category category) {

        return testRepository.findByCategory(category);
    }

    public Test getTestById(Long id) {
        return testRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Test not found"));
    }




    public Test updateTest(Long id, Test test) {
        Test existingTest = getTestById(id);
        existingTest.setName(test.getName());
        existingTest.setDescription(test.getDescription());
        existingTest.setPoints(test.getPoints());
        existingTest.setImage(test.getImage());
        existingTest.setCategory(test.getCategory());
        return testRepository.save(existingTest);
    }

    public void deleteById(Long id) {

        testRepository.deleteById(id);
    }
    public Test createTestWithQuestions(Test test, List<Question> questions) {
        Test savedTest = testRepository.save(test);
        questions.forEach(question -> question.setTest(savedTest));
        questionRepository.saveAll(questions);
        return savedTest;
    }
    public List<Test> getTestsByCategoryId(Long categoryId) {

        return testRepository.findByCategoryId(categoryId);
    }


}

