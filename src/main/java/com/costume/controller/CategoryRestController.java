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
import java.util.Optional;
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
import com.costume.repository.crud.CategoryCrudRepository;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Category")
public class CategoryRestController {
    
    @Autowired
    private CategoryCrudRepository categoryRepository;
    
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category>listCategorys = (List<Category>)categoryRepository.findAll();
        return  ResponseEntity.ok(listCategorys) ;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
         /** @TODO */
        return null;
    }
    
    @PutMapping
    public ResponseEntity<Category> updateCategory( @RequestBody Category category) {
        Optional<Category> categoryExis = categoryRepository.findById(category.getId());
        if(categoryExis.isPresent()){
           Category newCategory = categoryExis.get();
           newCategory.setName(category.getName());
           newCategory.setDescription(category.getDescription());
           categoryRepository.save(newCategory);
           return ResponseEntity.ok(newCategory);
        }else{
            return ResponseEntity.noContent().build();
        
        }
       
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> crearCategory(@RequestBody Category category) {
        Category newCategory = categoryRepository.save(category);
        
        return ResponseEntity.ok(newCategory);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
          /** @TODO */
        return null;
    }
    
}
