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
            * milk chocolate        0,00 t1
            * white chocolate       0,05 t2
            * dark chocolate        0,10 t3
            * pure cocoa chocolate  0,20 t4
        
        Size:
            * ultra-big         8,99 s1
            * big               7,99 s2
            * middle            6,99 s3
            * small             4,99 s4
            * slim              2,99 s5
        
        Logo:
            * Default           0,00 l1
            * PetritzDesigns    0,50 l2
            * jCorn             0,30 l3
            * Happy Birthday    0,80 l4
            * Text              1,00 l5
        */
        double t1 = 0.00;
        double t2 = 0.05;
        double t3 = 0.10;
        double t4 = 0.20;
        
        double s1 = 8.99;
        double s2 = 7.99;
        double s3 = 6.99;
        double s4 = 4.99;
        double s5 = 2.99;
        
        double l1 = 0.00;
        double l2 = 0.50;
        double l3 = 0.30;
        double l4 = 0.80;
        double l5 = 1.00;
        
        String type = model.getType();
        String size = model.getSize();
        String logo = model.getLogo();
       
        Double price = 0.0;
        
        switch(type) {
            case "milk chocolate":
                price += t1;
                break;
            case "white chocolate":
                price += t2;
                break;
            case "dark chocolate":
                price += t3;
                break;
            case "pure cocoa chocolate":
                price += t4;
                break;
        }
        
        switch(size) {
            
        }
        
        return model.getAmount() * price * new Random().nextDouble();
    }

}
