/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern;

import java.util.ArrayList;

/**
 *
 * @author Adam Hjernquist
 */
public class Invoker {
    private final ArrayList<OrderMeal> que = new ArrayList();
    
    void newOrder(OrderMeal ordermeal) {
        que.add(ordermeal);
    }
    
    public void executeCommands() {
        que.forEach((orderMeal) -> {
            orderMeal.execute();
        });
        
    }
}
