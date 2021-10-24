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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.costume.service.ReservationService;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author hugog
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationRestController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation>listReservations() {
         
        return reservationService.getAllReservation();
    }
    
    @GetMapping("/{id}")
    public Reservation get(@PathVariable Integer id) {
        return reservationService.getReservationId(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation put( @RequestBody Reservation reservation) {
       
        return reservationService.updateReservation(reservation);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation post(@RequestBody Reservation reservation) {
       
        return reservationService.saveReservation(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean delete(@PathVariable Integer id) {
          return reservationService.deleteReservation(id);
    }
    
}
