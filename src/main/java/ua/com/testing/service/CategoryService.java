package ua.com.testing.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.Category;
import ua.com.testing.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

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


    // ...

    public String deleteCategory(String name) {
        try {
            Category category = categoryRepository.findByName(name);
            if (category != null) {
                categoryRepository.delete(category);
                return "Категорія з іменем " + name + " успішно видалена!";
            } else {
                return "Категорія з іменем " + name + " не знайдена!";
            }
        } catch (EmptyResultDataAccessException e) {
            return "Помилка при видаленні категорії з іменем " + name + "!";
        }
    }




}
