/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonpattern;

/**
 *
 * @author Adam Hjernquist
 */
public class SingletonPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ForeverAlone singletonObject = ForeverAlone.get();
        singletonObject.test();
        
    }
    
    
    
}
