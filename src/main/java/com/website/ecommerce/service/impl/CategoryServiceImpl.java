package com.website.ecommerce.service.impl;

import com.website.ecommerce.entity.Category;
import com.website.ecommerce.repository.CategoryRepository;
import com.website.ecommerce.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
