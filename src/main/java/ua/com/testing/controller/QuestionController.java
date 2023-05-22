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
    private TestService testService;  // Сервіс для роботи з тестами
    @Autowired
    private QuestionService questionService;  // Сервіс для роботи з питаннями
    @Autowired
    private UserService userService;  // Сервіс для роботи з користувачами
    @Autowired
    private UserAnswerService userAnswerService;  // Сервіс для роботи з відповідями користувачів

    @GetMapping
    public String getAllQuestions(Model model) {
        List<Question> questions = questionService.getAllQuestions();  // Отримати список всіх питань
        model.addAttribute("questions", questions);
        return "questions";  // Повернути шаблон "questions"
    }

    @GetMapping("/{id}")
    public String getQuestionById(@PathVariable Long id, Model model) {
        Question question = questionService.getQuestionById(id);  // Отримати питання за ідентифікатором
        model.addAttribute("question", question);
        return "questionDetails";  // Повернути шаблон "questionDetails"
    }

    @PostMapping
    public String createQuestion(@ModelAttribute Question question) {
        questionService.createQuestion(question);  // Створити нове питання
        return "redirect:/questions";  // Перенаправити на сторінку зі списком питань
    }

    @PutMapping("/{id}")
    public String updateQuestion(@PathVariable Long id, @ModelAttribute Question question) {
        questionService.updateQuestion(id, question);  // Оновити питання
        return "redirect:/questions/" + id;  // Перенаправити на сторінку з деталями питання
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);  // Видалити питання
        return "redirect:/questions";  // Перенаправити на сторінку зі списком питань
    }
}

