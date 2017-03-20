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
public class Buy implements OrderMeal{
    private final Reciever meal;
    
    @Override
    public void execute() {
        meal.buy();
    }
    
    public Buy(Reciever meal) {
        this.meal = meal;
    }
}
