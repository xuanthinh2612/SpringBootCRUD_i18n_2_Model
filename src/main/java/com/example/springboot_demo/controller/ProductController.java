package com.example.springboot_demo.controller;

import com.example.springboot_demo.model.Category;
import com.example.springboot_demo.model.Product;
import com.example.springboot_demo.service.category.CategoryService;
import com.example.springboot_demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("product/")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryList")
    private List<Category> getListCategory() {
        return categoryService.findALl();
    }

    @GetMapping("list")
    public ModelAndView productList() {
        ModelAndView modelAndView = new ModelAndView("product/index");
        List<Product> productList = productService.findALl();
        modelAndView.addObject("productList", productList);

        return modelAndView;
    }

    @GetMapping("new")
    public ModelAndView newProduct() {
        ModelAndView modelAndView = new ModelAndView("product/new");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categoryList", categoryService.findALl());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        productService.save(product);
        return new ModelAndView("redirect:/product/list");
    }
}
