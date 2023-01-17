package com.example.springboot_demo.service.category;

import com.example.springboot_demo.model.Category;
import com.example.springboot_demo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategory{

    @Autowired
    ICategoryRepository iCategoryRepository;


    @Override
    public List<Category> findALl() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Page<Category> findALl(Pageable pageable) {
        return iCategoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        iCategoryRepository.deleteById(id);
    }
}
