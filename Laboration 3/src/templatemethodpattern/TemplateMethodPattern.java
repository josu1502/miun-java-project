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
public class TemplateMethodPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] list = {3, 1, 7, 4, 2, 8};
        SomeAlgorithm sort = new Sort(list);
        
        
        sort.start();
    }
    
}
