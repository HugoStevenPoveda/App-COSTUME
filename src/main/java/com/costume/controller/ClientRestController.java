/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.controller;

import com.costume.model.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.costume.service.ClientService;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientRestController {
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/all")
    public List<Client>listClients() {
           
        return clientService.getAllClient();
    }
    
        
    
    @GetMapping("/{id}")
    public Client get(@PathVariable Integer id) {
     
        return clientService.getClientId(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client put(@RequestBody Client client) {
        
        return clientService.updateClient(client);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client post(@RequestBody Client client) {
        
        return clientService.saveClient(client);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }
    
}
