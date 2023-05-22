package ua.com.testing.service;


import org.springframework.beans.factory.annotation.Autowired;
import ua.com.testing.entity.Test;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.Category;
import ua.com.testing.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final TestService testService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, TestService testService) {
        this.categoryRepository = categoryRepository;
        this.testService = testService;
    }

    // отримує всі категорії
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    // додає нову категорію
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    // отримує категорію за id
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // оновлює категорію
    public String updateCategory(Category category) {
        Category existingCategory = categoryRepository.findByName(category.getName());
        if (existingCategory != null) {
            existingCategory.setDescription(category.getDescription());
            existingCategory.setImage(category.getImage());
            categoryRepository.save(existingCategory);
            return "Категорія з назвою " + category.getName() + " успішно оновлена!";
        } else {
            return "Категорія з назвою " + category.getName() + " не знайдена!";
        }
    }

    // видаляє категорію
    public String deleteCategory(String name) {
        Category category = categoryRepository.findByName(name);

        if (category != null) {
            List<Test> tests = testService.getAllTestsByCategory(category);

            // зберігаємо зміни у тестах, які належали даній категорії
            for (Test test : tests) {
                test.setCategory(null);
                testService.updateTest(test.getId(), test);
            }

            categoryRepository.delete(category);
            return "Категорія успішно видалена.";
        } else {
            return "Категорія не знайдена.";
        }
    }
}

