/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.service;

import com.costume.model.Costume;
import com.costume.repository.CostumeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugog
 */
@Service
public class CostumeService {

    @Autowired
    private CostumeRepository costumeRepository;

    
    
    public List<Costume> getAllCostume() {
        List<Costume> listCostumes = costumeRepository.getAllCostume();
        return listCostumes;
    }

    
    /**
     * permite validar cuando costume viene con id o sin id
     */  
     
     
    public Costume saveCostume(Costume costume) {
        Costume newCostume;
        if (costume.getId() == null) {
            newCostume = costumeRepository.saveCostume(costume);
            return newCostume;
        } else {
            Optional<Costume> costumeOptional = costumeRepository.getCostume(costume.getId());
            if (costumeOptional.isPresent()) {
                return costume;

            } else {
                newCostume = costumeRepository.saveCostume(costume);
                return newCostume;

            }

        }

    }

}
