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



// the mechanics
public class Controller {
    private final Model model;
    private final View view;
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
    public void setSID (int SID) {
        model.setSID(SID);
    }
    
    public int getSID () {
        return model.getSID();
    }
    
    public void print() {
        view.print(model.getSID());
    }
}

