/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadepattern;

/**
 *
 * @author Adam Hjernquist
 */
public class FacadePattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Facade System = new Facade();
        System.Start();
    }
}
