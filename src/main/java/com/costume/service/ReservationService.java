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

    public Reservation updateReservation(Reservation reservation) {
        Reservation reservationForUpdate = reservationRepository
                .UpdateReservation(reservation);
        if (reservationForUpdate != null) {
            Reservation newReser = reservationForUpdate;
            newReser.setStartDate(reservation.getStartDate());
            newReser.setDevolutionDate(reservation.getDevolutionDate());
            newReser.setCostume(reservation.getCostume());
            newReser.setClient(reservation.getClient());
            reservationRepository.saveReservation(newReser);
            return newReser;
        }
        return null;
    }
            
            
            



    public void deleteReservation(Integer id) {
        Optional<Reservation> reservationExits = reservationRepository.getReservation(id);
        if (reservationExits.isPresent()) {
            reservationRepository.deleteReservation(id);

        }

    }

}
