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
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String getPageCategory(Model model){
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("allCategory", categoryList);
        model.addAttribute("showSearchResults", false);
        return "category";
    }
    @Autowired
    private SearchService searchService;


    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Category> searchResults = searchService.search(query);
        model.addAttribute("searchResults", searchResults);
        model.addAttribute("showSearchResults", true);
        return "category";
    }
    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin";
    }

    @PostMapping("/category/update")
    public String updateCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        String result = categoryService.updateCategory(category);
        redirectAttributes.addFlashAttribute("updateResult", result);
        return "redirect:/admin";
    }


    @PostMapping("/category/delete")
    public String deleteCategory(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        String result = categoryService.deleteCategory(name);
        redirectAttributes.addFlashAttribute("deleteResult", result);
        return "redirect:/admin";
    }



    @GetMapping("/admin")
    public String getAdminPanel() {
        return "admin";
    }
}
