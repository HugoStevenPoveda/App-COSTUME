/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "costumes")
public class Costume implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false , length = 45)
    private String name;
    
    @Column(nullable = false , length = 45)
    private String brand;
    
    @Column( nullable = false , length = 4)
    private Integer year;
    @Column(nullable = false , length = 250)
    private String description;
    
    
    
    
    @ManyToOne
    @JsonIgnoreProperties("costumes")
    //category_id
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "costume")
    @JsonIgnoreProperties({"costume","client"})
    private List<Message> messages;
    
    
   @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "costume")
   @JsonIgnoreProperties("costume")
    private List<Reservation> reservations;
   
    
 
    
    
    
    
}
