package ua.com.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.testing.entity.Question;
import ua.com.testing.entity.Test;
import ua.com.testing.entity.UserAnswer;
import ua.com.testing.entity.Users;
import ua.com.testing.service.QuestionService;
import ua.com.testing.service.TestService;
import ua.com.testing.service.UserAnswerService;
import ua.com.testing.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private TestService testService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserAnswerService userAnswerService;

    @GetMapping
    public String getAllQuestions(Model model) {
        List<Question> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        return "questions";
    }

    @GetMapping("/{id}")
    public String getQuestionById(@PathVariable Long id, Model model) {
        Question question = questionService.getQuestionById(id);
        model.addAttribute("question", question);
        return "questionDetails";
    }

    @PostMapping
    public String createQuestion(@ModelAttribute Question question) {
        questionService.createQuestion(question);
        return "redirect:/questions";
    }

    @PutMapping("/{id}")
    public String updateQuestion(@PathVariable Long id, @ModelAttribute Question question) {
        questionService.updateQuestion(id, question);
        return "redirect:/questions/" + id;
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return "redirect:/questions";
    }
}
