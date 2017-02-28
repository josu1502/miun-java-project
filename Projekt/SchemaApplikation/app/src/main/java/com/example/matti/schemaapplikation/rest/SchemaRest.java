package com.example.matti.schemaapplikation.rest;

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

public interface SchemaRest {
    @GET("service.scheduleentity")
    Call<SchemaEntities> selectScheman();

    @POST("service.scheduleentity")
    Call<SchemaEntity> createSchema(@Body SchemaEntity schemaEntity);

    @PUT("service.scheduleentity/{id}")
    Call<SchemaEntity> updateSchema(@Body SchemaEntity schemaEntity, @Path("id") Long id);

    @DELETE("service.scheduleentity/{id}")
    Call<SchemaEntity> deleteSchema( @Path("id") Long id);

}
