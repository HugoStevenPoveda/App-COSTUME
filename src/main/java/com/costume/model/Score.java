/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hugog
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SCORES")
public class Score implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id_score;
    @Column(nullable = false,length = 255)
     private String message_text;
    @Column(nullable = false,length = 11)
     private Integer stars;
    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
     private Reservation reservation_id;
     
    
}
