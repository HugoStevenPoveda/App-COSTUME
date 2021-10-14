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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.costume.service.CategoryService;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Category")
//@CrossOrigin(origins = "*",methods = {RequestMethod.GET})
public class CategoryRestController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category>listCategorys = categoryService.getAllCategory();
        return  ResponseEntity.ok(listCategorys) ;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
         /** @TODO */
        return null;
    }
    
    @PutMapping
    public ResponseEntity<Category> updateCategory( @RequestBody Category category) {
         /** @TODO */
        return null;
       
    }
    
    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> crearCategory(@RequestBody Category category) {
        Category newCategory = categoryService.saveCategory(category);
        
        return ResponseEntity.ok(newCategory);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
          /** @TODO */
        return null;
    }
    
}
