/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcdemo;

/**
 *
 * @author Adam Hjernquist
 */

// Model == data
public class Model {
    private int SID;
    
    public Model(int SID) {
        this.SID = SID;
    }
    
    public int getSID() {
        return SID;
    }
    
    public void setSID(int SID) {
        this.SID = SID;
    }
}
