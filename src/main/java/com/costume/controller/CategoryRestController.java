/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.controller;

import com.costume.model.Category;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.costume.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryRestController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public List<Category> getAllCategory() {
        return  categoryService.getAllCategory();
        
    }
    
    @GetMapping("/{id}")
    public Category get(@PathVariable Integer id) {
        return categoryService.getCategoryId(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCategory( @RequestBody Category category) {
        return categoryService.updateCategory(category);
        
    }
       
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category crearCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
         
    }
        
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
          return categoryService.deleteCategory(id);
   }
    }
