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
public class Facade {
    private final Component CPU;
    private final Component GPU;
    
    public Facade() {
        CPU = new CPU();
        GPU = new GPU();
    }
    
    public void Start(){
        CPU.run();
        GPU.run();
    }
}
