/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository.crud;

import com.costume.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hugog
 */
public interface AdminCrudRepository extends JpaRepository<Admin, Integer> {
    
}
