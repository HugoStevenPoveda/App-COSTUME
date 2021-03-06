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
    
     public Costume getCostumetId(Integer id){
        Optional costumeOptional = costumeRepository.getCostume(id);
        if(costumeOptional.isPresent()){
            return (Costume)costumeOptional.get();
        
        }
        return null;
    
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

   public Costume updateCostume(Costume costume) {
        Costume costumeForUpdate = costumeRepository.UpdateCostume(costume);
        Optional<Costume> costumeForCategory = costumeRepository.getCostume(costume.getId());
        if(costumeForCategory.isPresent()){
            costume.setCategory(costumeForCategory.get().getCategory());
        }
        if (costumeForUpdate != null) {
            Costume newCostume = costumeForUpdate;
            newCostume.setName(costume.getName());
            newCostume.setBrand(costume.getBrand());
            newCostume.setYear(costume.getYear());
            newCostume.setDescription(costume.getDescription());
            newCostume.setCategory(costume.getCategory());
            costumeRepository.saveCostume(newCostume);
            return newCostume;
        }

        return null;
    }
    

    public boolean  deleteCostume(Integer id) {
        Optional<Costume> costumeExits = costumeRepository.getCostume(id);
        if (costumeExits.isPresent()) {
            costumeRepository.deleteCostume(id);
            return true;

        }
        return false;

    }
    
    
}
