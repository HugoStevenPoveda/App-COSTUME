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

}
