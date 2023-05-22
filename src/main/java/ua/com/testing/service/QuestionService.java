package ua.com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.Question;
import ua.com.testing.repository.QuestionRepository;

import java.util.List;

@Service // Маркує сервісний шар в Spring'овому контексті.
public class QuestionService {

    @Autowired // Інжектить залежність від QuestionRepository.
    private QuestionRepository questionRepository;

    // Виводить список всіх питань.
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Знаходить питання за ID. Якщо не знайшло - видає RuntimeException.
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    // Створює нове питання.
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Оновлює існуюче питання за ID. Замінює текст питання.
    public Question updateQuestion(Long id, Question question) {
        Question existingQuestion = getQuestionById(id);
        existingQuestion.setText(question.getText());
        return questionRepository.save(existingQuestion);
    }

    // Видаляє питання за ID.
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    // Знаходить список питань за ID тесту.
    public List<Question> getQuestionsByTestId(Long testId) {
        return questionRepository.findAllByTestId(testId);
    }

}

