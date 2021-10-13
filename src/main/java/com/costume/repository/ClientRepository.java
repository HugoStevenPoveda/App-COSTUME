/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository;

import com.costume.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.costume.repository.dao.ClientDaoRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hugog
 */
@Repository
public class ClientRepository {

    @Autowired
    private ClientDaoRepository clientDaoRepository;

    public List<Client> getAllClient() {
        List<Client> listClients = (List<Client>) clientDaoRepository.findAll();

        return listClients;
    }

    public Optional<Client> getClient(Integer id) {
        Optional<Client> clientGeById = clientDaoRepository.findById(id);

        return clientGeById;
    }

    public Client saveClient(Client client) {
        Client newClient = clientDaoRepository.save(client);
        return newClient;
    }

}
