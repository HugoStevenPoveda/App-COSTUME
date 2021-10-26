/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.service;

import com.costume.model.Client;
import com.costume.model.businessReports.Reports;
import com.costume.model.businessReports.ReportsClient;
import com.costume.model.Reservation;
import com.costume.repository.ClientRepository;
import com.costume.repository.ReservationRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
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
    @Autowired
    private ClientRepository clientRepository;

    public List<Reservation> getAllReservation() {
        List<Reservation> listReservation = reservationRepository.getAllReservation();
        return listReservation;
    }

    public Reservation getReservationId(Integer id) {
        Optional reservationOptional = reservationRepository.getReservation(id);
        if (reservationOptional.isPresent()) {
            return (Reservation) reservationOptional.get();

        }
        return null;

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

    public boolean deleteReservation(Integer id) {
        Optional<Reservation> reservationExits = reservationRepository.getReservation(id);
        if (reservationExits.isPresent()) {
            reservationRepository.deleteReservation(id);
            return true;

        }
        return false;

    }

    public Reports reporteCompleCancel() {
        Reports reports = reservationRepository.reporteCompleCancel();
        int comple = 0;
        int cancel = 0;
        List<Reservation> listReservation = getAllReservation();
        for (Reservation res : listReservation) {
            if (res.getStatus().equals("completed")) {
                comple += 1;
            }
            if (res.getStatus().equals("cancelled")) {
                cancel += 1;
            }
        }
        reports.setCompleted(comple);
        reports.setCancelled(cancel);

        return reports;

    }

    public List<ReportsClient> reportsClient() {
        List<Client> listClients = clientRepository.getAllClient();
        List<ReportsClient> reportsClients = new ArrayList<>();

        listClients.forEach(client -> {
            int total = client.getReservations().size();
            reportsClients.add(reservationRepository.reportsClient(total, client));

        });
        Collections.sort(reportsClients);

        return reportsClients;

    }

    public List<Reservation> ReportReservation(Calendar startDate,
             Calendar devolutionDate) {
        List<Reservation> listReservations = getAllReservation();
        List<Reservation> listCalendar = new ArrayList<>();

        listReservations.forEach(res -> {

            if (startDate.before(res.getStartDate())
                    && devolutionDate.after(res.getStartDate())) {
                listCalendar.add(res);

            }
        });

        return listCalendar;

    }

    public Calendar strigTOCalendar(String fechaString) {

        int posAnio = fechaString.indexOf("-");
        int posMes = fechaString.lastIndexOf("-");
        //AÑO 
        String sAnio = fechaString.substring(0, posAnio);
        int anio = Integer.parseInt(sAnio);
        //Mes
        String sMes = fechaString.substring(posAnio + 1, posMes);
        int mes = Integer.parseInt(sMes);

        //DIA
        String sDia = fechaString.substring(posMes + 1);
        int dia = Integer.parseInt(sDia);
        Calendar calendar = new GregorianCalendar(anio, mes, dia);

        return calendar;

    }

}
