package ua.com.testing.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.testing.entity.Category;
import ua.com.testing.service.CategoryService;
import ua.com.testing.service.SearchService;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        // Конструктор, що приймає CategoryService
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String getPageCategory(Model model){
        // Отримати список всіх категорій і передати його в модель
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("allCategory", categoryList);
        model.addAttribute("showSearchResults", false);
        return "category";
    }

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        // Виконати пошук категорій за запитом і передати результати в модель
        List<Category> searchResults = searchService.search(query);
        model.addAttribute("searchResults", searchResults);
        model.addAttribute("showSearchResults", true);
        return "category";
    }

    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute("category") Category category) {
        // Додати нову категорію
        categoryService.addCategory(category);
        return "redirect:/admin";
    }

    @PostMapping("/category/update")
    public String updateCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        // Оновити існуючу категорію
        String result = categoryService.updateCategory(category);
        redirectAttributes.addFlashAttribute("updateResult", result);
        return "redirect:/admin";
    }

    @PostMapping("/category/delete")
    public String deleteCategory(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        // Видалити категорію за назвою
        String result = categoryService.deleteCategory(name);
        redirectAttributes.addFlashAttribute("deleteResult", result);
        return "redirect:/admin";
    }
}
