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
public class StrategyPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Strategy Ascendinglist = new SortAscending();
        Strategy Descendinglist = new SortDescending();
        int[] list = {4,2,7,1,3,2};
        
        list = Ascendinglist.Operation(list);
        
        System.out.println("Ascending sort: \t" + Arrays.toString(list));
        
        list = Descendinglist.Operation(list);
        
        System.out.println("Descending sort: \t" + Arrays.toString(list));
        
        
    }
    
}
