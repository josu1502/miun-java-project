package r.orderapplication.orderRest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Alex on 2017-03-01.
 */

public interface OrderRest {
    @GET("beans.entities.orderentity")
    Call<OrderEntities> selectOrder();

    @POST("beans.entities.orderentity")
    Call<OrderEntity> createOrder(@Body OrderEntity orderEntity);

    @PUT("beans.entities.orderentity/{id}")
    Call<OrderEntity> updateOrder(@Body OrderEntity orderEntity, @Path("id") Long id);

    @DELETE("beans.entities.orderentity/{id}")
    Call<OrderEntity> deleteOrder(@Path("id") Long id);
}
