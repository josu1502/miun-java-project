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
    @GET("beans.entities.schemaentity")
    Call<SchemaEntities> selectScheman();

    @POST("beans.entities.schemaentity")
    Call<SchemaEntity> createSchema(@Body SchemaEntity schemaEntity);

    @PUT("beans.entities.schemaentity/{id}")
    Call<SchemaEntity> updateSchema(@Body SchemaEntity schemaEntity, @Path("id") Long id);

    @DELETE("beans.entities.schemaentity/{id}")
    Call<SchemaEntity> deleteSchema(@Path("id") Long id);

}
