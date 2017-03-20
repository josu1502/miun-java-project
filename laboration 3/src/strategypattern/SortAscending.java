/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern;


import java.util.Arrays;




/**
 *
 * @author Adam Hjernquist
 */
public class SortAscending implements Strategy {

    @Override
    public int[] Operation(int[] list) {
        Arrays.sort(list);
        return list;
    }
    
    @Override
    public int[] Option(int[] list) {
        return list;
    }
    
}
