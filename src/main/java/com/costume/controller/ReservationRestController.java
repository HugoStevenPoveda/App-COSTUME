/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.controller;

import com.costume.model.Reservation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.costume.service.ReservationService;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Reservation")
public class ReservationRestController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation>listReservations() {
         
        return reservationService.getAllReservation();
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
          /** @TODO */
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
          /** @TODO */
        return null;
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation post(@RequestBody Reservation reservation) {
       
        return reservationService.saveReservation(reservation);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
          /** @TODO */
        return null;
    }
    
}
