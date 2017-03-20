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
public class MVCDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int SID = 3;
        
        Model model = new Model(SID);
        View view = new View();
        Controller controller = new Controller(model, view);
        
        controller.print();
        SID++;
        controller.setSID(SID);
        controller.print();
        
        
    }
    
}
