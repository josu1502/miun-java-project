/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatemethodpattern;

/**
 *
 * @author Adam Hjernquist
 */
public abstract class SomeAlgorithm {
    abstract void stepOne();
    abstract void stepTwo();
    
    public final void start(){
        stepOne();
        
        stepTwo();
    }
}
