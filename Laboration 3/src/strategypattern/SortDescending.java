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
public class SortDescending implements Strategy {

    @Override
    public int[] Operation(int[] list) {
        Arrays.sort(list);
        list = Option(list);
        
        return list;
    }

    @Override
    public int[] Option(int[] list) {
        for(int i = 0; i < list.length / 2; i++) {
            int temp = list[i];
            list[i] = list[list.length - i - 1];
            list[list.length - i - 1] = temp;
        }
        
        return list;
    }
    
}
