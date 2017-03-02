package r.orderapplication.orderRest;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Alex on 2017-03-01.
 */

@Root(name="OrderEntities")
public class OrderEntities {
    @ElementList(entry="orderEntity", inline=true)
    public List<OrderEntity> orderEntity;
}
