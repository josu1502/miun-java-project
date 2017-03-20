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
public class ShoppingCart implements Collection {
    private final String products[] = {"Apples", "Cake", "GPU"};
    
    @Override
    public Iterator createIterator() {
        return new CartIterator();
    }
    
    private class CartIterator implements Iterator {
        private int pos;
        
        @Override
        public boolean hasNext() {
            if (pos < products.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object Next() {
            if (this.hasNext()) {
                return products[pos++];
            }
            return null;
        }
    
    }
    
    
}
