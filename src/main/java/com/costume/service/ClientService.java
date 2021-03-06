/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.service;

import com.costume.model.Client;
import com.costume.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugog
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient() {
        List<Client> listClient = clientRepository.getAllClient();
        return listClient;
    }
    
     public Client getClientId(Integer id){
        Optional clientOptional = clientRepository.getClient(id);
        if(clientOptional.isPresent()){
            return (Client)clientOptional.get();
        
        }
        return null;
    
    }

    public Client saveClient(Client client) {
        Client newClient;
        if (client.getIdClient() == null) {
            newClient = clientRepository.saveClient(client);
            return newClient;
        } else {
            Optional<Client> clientOptional = clientRepository.getClient(client.getIdClient());
            if (clientOptional.isPresent()) {
                return client;

            } else {
                newClient = clientRepository.saveClient(client);
                return newClient;

            }

        }

    
    }
    
    public Client updateClient(Client client){
       Client clientForUpdate= clientRepository.updateClient(client);
       if (clientForUpdate!=null){
           Client newClient = clientForUpdate;
           newClient.setEmail(client.getEmail());
           newClient.setPassword(client.getPassword());
           newClient.setName(client.getName());
           newClient.setAge(client.getAge());
           clientRepository.saveClient(newClient);
          
           return newClient;
       }
       return null;
    
    }
    
     public boolean deleteClient(Integer id){
        Optional<Client> clientExits =clientRepository.getClient(id);
        if(clientExits.isPresent()){
            clientRepository.deleteClient(id);
            return true;
        
        }
        return false;
    
    }

}
