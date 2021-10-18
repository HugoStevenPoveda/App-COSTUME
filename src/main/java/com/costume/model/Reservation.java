/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "reservations")
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation ;
    @Column(nullable = false,length = 6)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startDate;
    
    @Column(nullable = false,length = 6)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar devolutionDate;
    
    @Column(nullable = false,length = 255)
    private String status = "created";
  
    @ManyToOne
    @JsonIgnoreProperties({"reservations"})
   
    private Costume costume;
   
    @ManyToOne
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    private Score score = null;
            
    
    
 
}
