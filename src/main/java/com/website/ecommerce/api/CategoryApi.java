package com.website.ecommerce.api;

import com.website.ecommerce.entity.Category;
import com.website.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class CategoryApi {

    private final CategoryService categoryService;


    public CategoryApi(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping("/category/findAll")
    public ResponseEntity<List<Category>> findAllList(){
        List<Category> result = categoryService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
