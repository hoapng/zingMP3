package com.zingmp3.rest;

import com.zingmp3.entity.Category;
import com.zingmp3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryRest {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/public/categories")
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    @GetMapping("/public/categoriesById")
    public Category findById(@RequestParam("id") Long id){
        return categoryRepository.findById(id).get();
    }

    @PostMapping("/admin/addCategory")
    public void addCategory(@RequestBody Category category){
        categoryRepository.save(category);
    }

    @DeleteMapping("/admin/deleteCategory")
    public void deleteCategory(@RequestParam("id") Long id){
        categoryRepository.deleteById(id);
    }

    @GetMapping("/admin/checkAdmin")
    public void checkAdmin(){
        System.out.println("admin");
    }

    @GetMapping("/admin/checkUser")
    public void checkUser(){
        System.out.println("user");
    }
}
