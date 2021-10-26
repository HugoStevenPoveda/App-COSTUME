/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.costume.model.businessReports;

import java.io.Serializable;
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
public class Reports  implements Serializable {
    
    private int completed = 0;
    private int cancelled = 0;
    
    
    
    
    
}
