package ua.com.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.testing.entity.*;
import ua.com.testing.service.*;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TestService testService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserAnswerService userAnswerService;

    // Отримати всі тести
    @GetMapping
    public String getAllTests(Model model) {
        List<Test> tests = testService.getAllTests();
        model.addAttribute("tests", tests);
        return "/admin/tests";
    }

    // Отримати деталі тесту за ідентифікатором
    @GetMapping("/{id}/details")
    public String getTestById(@PathVariable Long id, Model model) {
        Test test = testService.getTestById(id);
        model.addAttribute("test", test);
        return "/admin/testDetails";
    }

    // Створити новий тест
    @PostMapping
    public String createTest(@ModelAttribute Test test, @RequestParam Long category, @RequestParam String questions) {
        Category selectedCategory = categoryService.getCategoryById(category);
        test.setCategory(selectedCategory);

        List<Question> questionList = Arrays.stream(questions.split("\\r?\\n"))
                .map(questionText -> new Question(questionText.trim(), test))
                .collect(Collectors.toList());

        testService.createTestWithQuestions(test, questionList);
        return "redirect:/admin";
    }

    // Редагувати тест за ідентифікатором
    @GetMapping("/{id}/edit")
    public String editTest(@PathVariable Long id, Model model) {
        Test test = testService.getTestById(id);
        if (test == null) {
            return "/error/testNotFound";
        }
        model.addAttribute("test", test);
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "/admin/testEdit";
    }

    // Оновити тест
    @PostMapping("/{id}/update")
    public String updateTest(@PathVariable("id") Long id, @ModelAttribute Test test, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/testEdit";
        }
        testService.updateTest(id, test);
        return "redirect:/admin";
    }

    // Видалити тест за ідентифікатором
    @PostMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        testService.deleteById(id);
        return "redirect:/admin";
    }

    // Отримати форму для створення нового тесту
    @GetMapping("/new")
    public String createTestForm(Model model) {
        model.addAttribute("test", new Test());
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "/admin/createTest";
    }

    // Почати тест за ідентифікатором
    @GetMapping("/{id}/start")
    public String startTest(@PathVariable Long id, Model model) {
        Test test = testService.getTestById(id);
        List<Question> questions = questionService.getQuestionsByTestId(id);
        model.addAttribute("test", test);
        model.addAttribute("questions", questions);
        return "testPage";
    }

    // Отримати тести за категорією
    @GetMapping("/category/{id}")
    public String getTestsByCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        List<Test> tests = testService.getTestsByCategoryId(id);
        model.addAttribute("categoryName", category.getName());
        model.addAttribute("tests", tests);
        return "templ/testsByCategory";
    }

    // Завершити тест та зберегти відповіді користувача
    @PostMapping("/{id}/submit")
    public String submitTest(@PathVariable Long id, @RequestParam("answers[]") List<String> answers) {
        Test test = testService.getTestById(id);
        Users user = userAnswerService.getCurrentUser();
        List<Question> questions = test.getQuestions();

        for (int i = 0; i < questions.size(); i++) {
            UserAnswer userAnswer = new UserAnswer();
            userAnswer.setUser(user);
            userAnswer.setTest(test);
            userAnswer.setQuestion(questions.get(i));
            userAnswer.setAnswer(answers.get(i));
            userAnswerService.saveUserAnswer(userAnswer);
        }
        return "redirect:/category";
    }

    // Показати результати тестів
    @GetMapping("/testResults")
    public String showTestResults(Model model) {
        List<UserAnswer> userAnswers = userAnswerService.getAllUserAnswers();
        model.addAttribute("userAnswers", userAnswers);
        return "/admin/testResults";
    }

    // Видалити відповіді користувача
    @PostMapping("/deleteUserAnswers")
    public String deleteUserAnswers(@RequestParam("username") String username,
                                    @RequestParam("testName") String testName) {
        userAnswerService.deleteUserAnswersByUserAndTest(username, testName);
        return "redirect:/admin";
    }
}
