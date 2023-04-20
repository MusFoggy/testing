package ua.com.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.testing.entity.Category;
import ua.com.testing.repository.CategoryRepository;

import java.util.List;

@Service
public class SearchService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public SearchService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> search(String query) {
        return categoryRepository.findByNameStartingWithIgnoreCase(query);
    }
}


