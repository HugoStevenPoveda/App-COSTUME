/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.controller;

import com.costume.model.Message;
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
import com.costume.repository.crud.MessageCrudRepository;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Message")
public class MessageRestController {
    @Autowired
    private MessageCrudRepository messageRepository;
    
    @GetMapping("/all")
    public ResponseEntity<List<Message>> listaLLMesage() {
        List<Message> listMessages = ( List<Message> )messageRepository.findAll();
        
        return ResponseEntity.ok(listMessages);
    }
        
        
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        /** @TODO*/
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        /** @TODO*/
        return null;
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Message> postMessage(@RequestBody Message message ) {
        Message newMessage = messageRepository.save(message);
        return ResponseEntity.ok(newMessage);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        /** @TODO*/
        return null;
    }
    
}
