package ua.com.testing.service;

import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.Category;
import ua.com.testing.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategory(){
//        List<Category> categories = new ArrayList<>();
//        categories = categoryRepository.findAll();
//        return categories;

        return categoryRepository.findAll();
    }


}
