/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern;

/**
 *
 * @author Adam Hjernquist
 */
public class CommandPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reciever r = new Reciever();
        
        Buy WhatToBuy = new Buy(r);
        Sell WhatToSell = new Sell(r);
        
        Invoker i = new Invoker();
        i.newOrder(WhatToBuy);
        i.newOrder(WhatToSell);
        
        // execute the list of commands
        i.executeCommands();
        
    }
    
}
