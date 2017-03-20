/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratordemo;

/**
 *
 * @author Adam Hjernquist
 */
public class IteratorDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        System.out.println("The products are: ");
        for (Iterator i = shoppingCart.createIterator(); i.hasNext();) {
            String product = (String)i.Next();
            System.out.println(product);
        }
    }
    
}
