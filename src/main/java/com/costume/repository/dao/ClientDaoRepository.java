/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository.dao;

import com.costume.model.Client;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hugog
 */
public interface ClientDaoRepository extends CrudRepository<Client, Integer> {
    
}
