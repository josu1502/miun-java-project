package com.example.matti.schemaapplikation.rest;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Joakim on 17-02-27.
 */

public class SchemaClient {

    private SchemaStatusListener ssl;
    private SchemaRest client;

    public SchemaClient(String dataBaseURL) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(dataBaseURL)
                .client(httpClient.build()).addConverterFactory(SimpleXmlConverterFactory.create());

        Retrofit retrofit = builder.build();

        client = retrofit.create(SchemaRest.class);
    }

    public void setStatusListener(SchemaStatusListener ssl) {
        this.ssl = ssl;
    }

    public void fetchSchemaList() {
        Call<SchemaEntities> call = client.selectScheman();
        call.enqueue(new Callback<SchemaEntities>() {
            @Override
            public void onResponse(Call<SchemaEntities> call, Response<SchemaEntities> response) {
                SchemaEntities scheman = response.body();
                ssl.schemaListRecived(scheman);
            }

            @Override
            public void onFailure(Call<SchemaEntities> call, Throwable t) {

            }
        });
    }

    public void postSchema(SchemaEntity schemaEntity) {
        Call<SchemaEntity> call = client.createSchema(schemaEntity);
        call.enqueue(new Callback<SchemaEntity>() {
            @Override
            public void onResponse(Call<SchemaEntity> call, Response<SchemaEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<SchemaEntity> call, Throwable t) {

            }
        });
    }

    public void updateSchema(SchemaEntity schemaEntity) {
        Call<SchemaEntity> call = client.updateSchema(schemaEntity, schemaEntity.getId());
        call.enqueue(new Callback<SchemaEntity>() {
            @Override
            public void onResponse(Call<SchemaEntity> call, Response<SchemaEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<SchemaEntity> call, Throwable t) {

            }
        });
    }

    public void deleteSchema(SchemaEntity schemaEntity) {
        Call<SchemaEntity> call = client.deleteSchema(schemaEntity.getId());
        call.enqueue(new Callback<SchemaEntity>() {
            @Override
            public void onResponse(Call<SchemaEntity> call, Response<SchemaEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<SchemaEntity> call, Throwable t) {

            }
        });
    }
}
