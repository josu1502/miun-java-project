package r.orderapplication.dinnerRest;

import okhttp3.OkHttpClient;
import r.orderapplication.orderRest.OrderEntities;
import r.orderapplication.orderRest.OrderEntity;
import r.orderapplication.orderRest.OrderRest;
import r.orderapplication.orderRest.OrderStatusListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Alex on 2017-03-02.
 */

public class DinnerClient {
    private DinnerStatusListener dsl;
    private DinnerRest client;

    public DinnerClient(String dataBaseURL) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(dataBaseURL)
                .client(httpClient.build()).addConverterFactory(SimpleXmlConverterFactory.create());

        Retrofit retrofit = builder.build();

        client = retrofit.create(DinnerRest.class);
    }

    public void setStatusListener(DinnerStatusListener dsl) {this.dsl = dsl;
    }

    public void fetchDinnerList() {
        Call<DinnerEntities> call = client.selectDinner();
        call.enqueue(new Callback<DinnerEntities>() {
            @Override
            public void onResponse(Call<DinnerEntities> call, Response<DinnerEntities> response) {
                DinnerEntities dinners = response.body();
                dsl.dinnerListRecived(dinners);
                System.out.println("onResponse Lyckat!");
            }

            @Override
            public void onFailure(Call<DinnerEntities> call, Throwable t) {
                System.out.println("onResponse Misslyckat!");
            }
        });
    }

    public void postDinner(DinnerEntity dinnerEntity) {
        Call<DinnerEntity> call = client.createDinner(dinnerEntity);
        call.enqueue(new Callback<DinnerEntity>() {
            @Override
            public void onResponse(Call<DinnerEntity> call, Response<DinnerEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<DinnerEntity> call, Throwable t) {

            }
        });

    }

    public void updateDinner(DinnerEntity dinnerEntity) {
        Call<DinnerEntity> call = client.updateDinner(dinnerEntity, dinnerEntity.getId());
        call.enqueue(new Callback<DinnerEntity>() {
            @Override
            public void onResponse(Call<DinnerEntity> call, Response<DinnerEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<DinnerEntity> call, Throwable t) {

            }
        });
    }

    public void deleteDinner(DinnerEntity dinnerEntity) {
        Call<DinnerEntity> call = client.deleteDinner(dinnerEntity.getId());
        call.enqueue(new Callback<DinnerEntity>() {
            @Override
            public void onResponse(Call<DinnerEntity> call, Response<DinnerEntity> response) {
                int resp_orig = response.code();
                int resp = resp_orig / 100;

                if (resp != 2) {
                    throw new RuntimeException(resp_orig + ": Fel kod. Inte 200.");
                }
            }

            @Override
            public void onFailure(Call<DinnerEntity> call, Throwable t) {

            }
        });
    }
}
