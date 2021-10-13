/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.controller;

import com.costume.model.Costume;
import com.costume.repository.CostumeRepository;
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

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Costume")
public class CostumeRestController {
    
    @Autowired
    private CostumeRepository costumeRepository;
    
    @GetMapping("/all")
    public ResponseEntity<List<Costume>> getAllCostume() {
          List<Costume> listCostumes =(List<Costume>)costumeRepository.findAll();
        return ResponseEntity.ok(listCostumes);
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        /** @TODO */
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        /** @TODO */
        return null;
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Costume> postCostume(@RequestBody Costume costume) {
        Costume newCostume = costumeRepository.save(costume);
        /** @TODO */
        return ResponseEntity.ok(newCostume);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        /** @TODO */
        return null;
    }
    
}
