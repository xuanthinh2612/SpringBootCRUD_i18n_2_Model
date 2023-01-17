package com.example.springboot_demo.controller;

import com.example.springboot_demo.model.Category;
import com.example.springboot_demo.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public ModelAndView categoryList() {
        ModelAndView modelAndView = new ModelAndView("category/index");
        List<Category> categoryList = categoryService.findALl();
        modelAndView.addObject("categoryList", categoryList);

        return modelAndView;
    }

    @GetMapping("new-category")
    public ModelAndView newCategory() {
        ModelAndView modelAndView = new ModelAndView("category/new");
        modelAndView.addObject("category", new Category());

        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView createCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return new ModelAndView("redirect:/category/list");
    }
}
