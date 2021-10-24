/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.controller;

import com.costume.model.Admin;
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
import com.costume.repository.dao.AdminDaoRepository;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Admin")
public class AdminRestController {
    
    @Autowired
    private AdminDaoRepository adminRepository;
    
    @GetMapping("all")
    public List<Admin> listAdmis() {
      
        return adminRepository.findAll();
        
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        /**@TODO*/
        return null;
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
         /**@TODO*/
        return null;
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin post(@RequestBody Admin admin) {
        Admin newAdmin=adminRepository.save(admin);
        return adminRepository.save(admin);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> delete(@PathVariable String id) {
        /**@TODO*/
        return null;
    }
    
}
