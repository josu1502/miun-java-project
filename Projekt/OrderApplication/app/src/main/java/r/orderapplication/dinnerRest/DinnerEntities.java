package r.orderapplication.dinnerRest;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import r.orderapplication.orderRest.OrderEntity;

/**
 * Created by Alex on 2017-03-02.
 */

@Root(name="OrderEntities")
public class DinnerEntities {

    @ElementList(entry="dinnerEntity", inline=true)
    public List<DinnerEntity> dinnerEntity;
}
