/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository;

import com.costume.model.Costume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.costume.repository.dao.CostumeDaoRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hugog
 */
@Repository
public class CostumeRepository {
    
    @Autowired
    private CostumeDaoRepository costumeDaoRepository;
    
    
    public List<Costume> getAllCostume(){
        List<Costume> listCostumes =(List<Costume>)costumeDaoRepository.findAll();
        
        return listCostumes;
    }
    
    
    public  Optional<Costume> getCostume(Integer id ){
        Optional<Costume> costumeGeById = costumeDaoRepository.findById(id);
    
    return costumeGeById;
    }
    
    
    public Costume saveCostume(Costume costume){
        Costume newCostume = costumeDaoRepository.save(costume);
    return newCostume;
    }
    
}
