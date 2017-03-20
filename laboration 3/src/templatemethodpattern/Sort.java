/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templatemethodpattern;

import java.util.Arrays;

/**
 *
 * @author Adam Hjernquist
 */
public class Sort extends SomeAlgorithm {
    private final int[] list;
    
    public Sort (int[] list) {
        this.list = list;
    }

    @Override
    void stepOne() {
        System.out.println("Original list: " + Arrays.toString(list));
        Arrays.sort(list);
    }

    @Override
    void stepTwo() {
        System.out.println("Sorted list: " + Arrays.toString(list));
    }

    
}
