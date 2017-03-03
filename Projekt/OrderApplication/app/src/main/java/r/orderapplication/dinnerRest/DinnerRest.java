package r.orderapplication.dinnerRest;

import r.orderapplication.orderRest.OrderEntities;
import r.orderapplication.orderRest.OrderEntity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Alex on 2017-03-02.
 */

public interface DinnerRest {

    @GET("beans.entities.dinnerentity")
    Call<DinnerEntities> selectDinner();

    @POST("beans.entities.dinnerentity")
    Call<DinnerEntity> createDinner(@Body DinnerEntity dinnerEntity);

    @PUT("beans.entities.dinnerentity/{id}")
    Call<DinnerEntity> updateDinner(@Body DinnerEntity dinnerEntity, @Path("id") Long id);

    @DELETE("beans.entities.dinnerentity/{id}")
    Call<DinnerEntity> deleteDinner(@Path("id") Long id);
}


