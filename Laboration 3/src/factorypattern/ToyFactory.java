/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPattern;

/**
 *
 * @author Adam Hjernquist
 */
public class ToyFactory {
    public Toy getToy(String type) {
        if ("CAR".equals(type)) {
            return new ToyCar();
        } else if ("AIRPLANE".equals(type)) {
            return new ToyAirplane();
        }
        
        return null;
    }
    
}
