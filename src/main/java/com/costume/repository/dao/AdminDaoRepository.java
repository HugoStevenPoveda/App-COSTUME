/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository.dao;

import com.costume.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hugog
 */
public interface AdminDaoRepository extends JpaRepository<Admin, Integer> {
    
}
