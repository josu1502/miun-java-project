/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern;

/**
 *
 * @author Adam Hjernquist
 */
public interface Strategy {
    public int[] Operation(int[] list);
    public int[] Option(int[] list);
    
}
