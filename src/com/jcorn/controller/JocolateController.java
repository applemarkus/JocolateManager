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
        return model.getAmount() * 10 + new Random().nextDouble();
    }
}
