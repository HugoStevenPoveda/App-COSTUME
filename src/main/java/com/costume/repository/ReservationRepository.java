/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.repository;

import com.costume.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.costume.repository.dao.ReservationDaoRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author hugog
 */
@Repository
public class ReservationRepository {

    @Autowired
    private ReservationDaoRepository reservationDaoRepository;

    public List<Reservation> getAllReservation() {
        List<Reservation> listReservation = (List<Reservation>) reservationDaoRepository.findAll();
        return listReservation;
    }

    public Optional<Reservation> getReservation(Integer id) {
        Optional<Reservation> reservationGeById = reservationDaoRepository.findById(id);

        return reservationGeById;
    }

    public Reservation saveReservation(Reservation reservation) {
        Reservation newReservation = reservationDaoRepository.save(reservation);
        return newReservation;
    }

    public Reservation UpdateReservation(Reservation reservation) {
        Optional<Reservation> reservetionOptional = reservationDaoRepository
                .findById(reservation.getIdReservation());
        if (reservetionOptional.isPresent()) {
            return reservation;
        }
        return null;
    }

    public void deleteReservation(Integer id) {

        reservationDaoRepository.deleteById(id);

    }

}
