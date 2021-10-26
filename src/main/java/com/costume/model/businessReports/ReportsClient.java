/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.model.businessReports;

import com.costume.model.Client;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hugog
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportsClient implements Serializable, Comparable<ReportsClient> {

    private Integer total;
    private Client client;

    @Override
    public int compareTo(ReportsClient o) {
        if (total < o.getTotal()) {
            return 1;
        }
        if (total > o.getTotal()) {

            return -1;
        }
        return 0;

    }

}
