package ua.com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.Question;
import ua.com.testing.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question question) {
        Question existingQuestion = getQuestionById(id);
        existingQuestion.setText(question.getText());
        return questionRepository.save(existingQuestion);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
    public List<Question> getQuestionsByTestId(Long testId) {
        return questionRepository.findAllByTestId(testId);
    }

}
