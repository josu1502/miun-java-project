package r.orderapplication.dinnerRest;

import r.orderapplication.orderRest.OrderEntities;

/**
 * Created by Alex on 2017-03-02.
 */

public interface DinnerStatusListener {

    void dinnerListRecived(DinnerEntities de);
    void dinnerUpdated();
}
