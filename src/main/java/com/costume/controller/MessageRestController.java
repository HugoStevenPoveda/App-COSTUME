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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.costume.service.MessageService;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageRestController {
    @Autowired
    private MessageService messageService;
    
    @GetMapping("/all")
    public List<Message> listaLLMesage() {
        return messageService.getAllMessage();
    }
       
        
        
        
    
    @GetMapping("/{id}")
    public Message get(@PathVariable Integer id) {
        return messageService.getMessagetId(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message put( @RequestBody Message message) {
        return messageService.updateMessage(message);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message postMessage(@RequestBody Message message ) {
        
        return messageService.saveMessage(message);
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
       return messageService.deleteMessage(id);
            
    }
    
}
