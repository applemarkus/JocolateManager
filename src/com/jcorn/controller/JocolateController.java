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

    public Double calculatePrice(JocolateModel model) {
        /*
        Type:
            * milk chocolate
            * white chocolate
            * dark chocolate
            * pure cocoa chocolate
        
        Size:
            * ultra-big
            * big
            * middle
            * small,
            * slim
        
        Logo:
            * Default
            * PetritzDesigns
            * jCorn
            * Happy Birthday
            * Text
        */
        
        String type = model.getType();
        //...
        
        return model.getAmount() * 10 + new Random().nextDouble();
    }

}
