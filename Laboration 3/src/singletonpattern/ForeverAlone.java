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
public class ForeverAlone {
    private static ForeverAlone PoorSoul = new ForeverAlone();
    
    private ForeverAlone(){
    }
    
    public void test(){
        System.out.println("The object exists.");
    }
    
    public static ForeverAlone get(){
        return PoorSoul;
    }
}
