/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository;

import com.costume.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.costume.repository.dao.CategoryDaoRepository;

/**
 *
 * @author hugog
 */
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryDaoRepository categoryDaoRepository;

    public List<Category> getAllCategory() {
        List<Category> listCategory = (List<Category>) categoryDaoRepository.findAll();
        return listCategory;
    }

    public Category saveCategory(Category category) {
        Category newCategory = categoryDaoRepository.save(category);
        return newCategory;
    }

    public Optional<Category> getCategory(Integer id) {
        Optional<Category> categoryById = categoryDaoRepository.findById(id);
        return categoryById;
    }

    public Category updateCategory(Category category) {

        Optional<Category> categrOptional = categoryDaoRepository.findById(category.getId());
        if (categrOptional.isPresent()) {
            return category;
        }
        return null;
    }

    public void deleteCategory(Integer id) {

        categoryDaoRepository.deleteById(id);

    }

}
