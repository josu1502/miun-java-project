package r.orderapplication.orderRest;

/**
 * Created by Alex on 2017-03-01.
 */

public interface OrderStatusListener {
    void orderListRecived(OrderEntities oe);
    void orderUpdated();
}
