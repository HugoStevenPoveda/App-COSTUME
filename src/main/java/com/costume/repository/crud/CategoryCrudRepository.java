/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.costume.model.Category;

/**
 *
 * @author hugog
 */
public interface CategoryCrudRepository  extends CrudRepository<Category, Integer>{
    
    
}
