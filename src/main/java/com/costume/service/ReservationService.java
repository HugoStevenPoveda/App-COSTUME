/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.service;

import com.costume.model.Reservation;
import com.costume.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hugog
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservation() {
        List<Reservation> listReservation = reservationRepository.getAllReservation();
        return listReservation;
    }

    
    public Reservation saveReservation(Reservation reservation) {
        Reservation newReservation;
        if (reservation.getIdReservation() == null) {
            newReservation = reservationRepository.saveReservation(reservation);
            return newReservation;
        } else {
            Optional<Reservation> messageOptional = reservationRepository.getReservation(reservation.getIdReservation());
            if (messageOptional.isPresent()) {
                return reservation;

            } else {
                newReservation = reservationRepository.saveReservation(reservation);
                return newReservation;

            }

        }

    }

}
