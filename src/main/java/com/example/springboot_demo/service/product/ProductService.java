package com.example.springboot_demo.service.product;

import com.example.springboot_demo.model.Product;
import com.example.springboot_demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProduct {

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> findALl() {
        return iProductRepository.findAll();
    }

    @Override
    public Page<Product> findALl(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        iProductRepository.deleteById(id);
    }
}
