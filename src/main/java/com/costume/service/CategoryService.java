/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.service;

import com.costume.model.Category;
import com.costume.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugog
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        List<Category> listCategory = categoryRepository.getAllCategory();
        return listCategory;
    }
    
    public Category getCategoryId(Integer id){
        Optional categOptional = categoryRepository.getCategory(id);
        if(categOptional.isPresent()){
            return (Category)categOptional.get();
        
        }
        return null;
    
    }

    public Category saveCategory(Category category) {
        Category newCategory;
        if (category.getId() == null) {
            newCategory = categoryRepository.saveCategory(category);
            newCategory.setCostumes(new ArrayList<>());
            return newCategory;
        } else {
            Optional<Category> categoryExists = categoryRepository.getCategory(category.getId());
            if (categoryExists.isPresent()) {
                return category;
            } else {
                newCategory = categoryRepository.saveCategory(category);
                newCategory.setCostumes(new ArrayList<>());
                return newCategory;
            }

        }

    }
    
    public Category updateCategory(Category category){
       Category categoryForUpdate= categoryRepository.updateCategory(category);
       if (categoryForUpdate!=null){
           Category newCategory = categoryForUpdate;
           newCategory.setName(category.getName());
           newCategory.setDescription(category.getDescription());
           categoryRepository.saveCategory(category);
           return newCategory;
       }
       return null;
    }
    
    public boolean deleteCategory(Integer id){
        Optional<Category> categoryExit =categoryRepository.getCategory(id);
        if(categoryExit.isPresent()){
            categoryRepository.deleteCategory(id);
            return true;
        }
        return false;
    
    }

}
