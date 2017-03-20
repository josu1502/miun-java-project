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
public class GPU implements Component {
    @Override
    public void run() {
        System.out.println("GPU is running...");
    }
}
