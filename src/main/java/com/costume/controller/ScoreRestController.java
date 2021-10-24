/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.controller;

import com.costume.model.Score;
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
import com.costume.service.ScoreService;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Score")
public class ScoreRestController {
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/all")
    public List<Score> listScores() {
           /** @TODO*/
        return null;
        
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        /** @TODO*/
        return null;
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
         /** @TODO*/
        return null;
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score post(@RequestBody Score score) {
        /** @TODO*/
        return null;
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable String id) {
         /** @TODO*/
        return null;
    }
    
}
