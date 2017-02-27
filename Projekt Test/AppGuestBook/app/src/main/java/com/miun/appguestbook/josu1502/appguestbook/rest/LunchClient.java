package com.miun.appguestbook.josu1502.appguestbook.rest;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Joakim on 17-02-27.
 */

public class LunchClient {

    private LunchStatusListener lsl;
    private LunchRest client;

    public LunchClient(String dataBaseURL) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(dataBaseURL)
                .client(httpClient.build()).addConverterFactory(SimpleXmlConverterFactory.create());

        Retrofit retrofit = builder.build();

        client = retrofit.create(LunchRest.class);
    }

    public void setStatusListener(LunchStatusListener lsl) {
        this.lsl = lsl;
    }

    public void fetchLunchList() {
        Call<LunchEntities> call = client.selectLunches();
        call.enqueue(new Callback<LunchEntities>() {
            @Override
            public void onResponse(Call<LunchEntities> call, Response<LunchEntities> response) {
                LunchEntities lunches = response.body();
                lsl.lunchListRecived(lunches);
            }

            @Override
            public void onFailure(Call<LunchEntities> call, Throwable t) {

            }
        });
    }

    public void postLunch(LunchEntity lunchEntity) {
        Call<LunchEntity> call = client.createLunch(lunchEntity);
        call.enqueue(new Callback<LunchEntity>() {
            @Override
            public void onResponse(Call<LunchEntity> call, Response<LunchEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<LunchEntity> call, Throwable t) {

            }
        });
    }

    public void updateLunch(LunchEntity lunchEntity) {
        Call<LunchEntity> call = client.updateLunch(lunchEntity, lunchEntity.getId());
        call.enqueue(new Callback<LunchEntity>() {
            @Override
            public void onResponse(Call<LunchEntity> call, Response<LunchEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<LunchEntity> call, Throwable t) {

            }
        });
    }

    public void deleteLunch(LunchEntity lunchEntity) {
        Call<LunchEntity> call = client.deleteLunch(lunchEntity.getId());
        call.enqueue(new Callback<LunchEntity>() {
            @Override
            public void onResponse(Call<LunchEntity> call, Response<LunchEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<LunchEntity> call, Throwable t) {

            }
        });
    }
}
