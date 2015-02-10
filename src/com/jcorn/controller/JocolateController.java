package com.jcorn.controller;

import com.jcorn.model.JocolateModel;
import java.util.Random;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class JocolateController {

    public static Double calculatePrice(JocolateModel model) {
        /*
        Type:
            * milk chocolate        0,00
            * white chocolate       0,05
            * dark chocolate        0,10
            * pure cocoa chocolate  0,20
        
        Size:
            * ultra-big         8,99
            * big               7,99
            * middle            6,99
            * small             4,99
            * slim              2,99
        
        Logo:
            * Default           0,00
            * PetritzDesigns    0,50
            * jCorn             0,30
            * Happy Birthday    0,80
            * Text              1,00
        */
        
        String type = model.getType();
        String size = model.getSize();
        String logo = model.getLogo();
       
        Double price = 0.0;
        
        return model.getAmount() * 10 + new Random().nextDouble();
    }

}
