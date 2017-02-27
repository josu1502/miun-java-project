package com.miun.appguestbook.josu1502.appguestbook.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Joakim on 17-02-16.
 */

public interface LunchRest {
    @GET("beans.entities.lunchentity")
    Call<LunchEntities> selectLunches();

    @POST("beans.entities.lunchentity")
    Call<LunchEntity> createLunch(@Body LunchEntity lunchEntity);

    @PUT("beans.entities.lunchentity/{id}")
    Call<LunchEntity> updateLunch(@Body LunchEntity lunchEntity, @Path("id") Long id);


    @DELETE("beans.entities.lunchentity/{id}")
    Call<LunchEntity> deleteLunch( @Path("id") Long id);

}
