/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.costume.repository.dao.ScoreDaoRepository;

/**
 *
 * @author hugog
 */

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreDaoRepository scoreCrudRepository;
    
}
