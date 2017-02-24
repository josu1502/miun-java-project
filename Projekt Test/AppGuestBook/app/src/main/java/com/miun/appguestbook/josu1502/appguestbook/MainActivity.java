package com.miun.appguestbook.josu1502.appguestbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miun.appguestbook.josu1502.appguestbook.rest.LunchEntity;
import com.miun.appguestbook.josu1502.appguestbook.rest.GitHubClient;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Jockes IP-adress: "http://192.168.43.80:8080/AntonsHemsida/webresources/beans.entities.lunchentity"*/

        testList = (ListView) findViewById(R.id.listView);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.43.80:8080/AntonsHemsida/webresources/")
                .client(httpClient.build()).addConverterFactory(SimpleXmlConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient client = retrofit.create(GitHubClient.class);
        Call<List<LunchEntity>> call = client.getLunches();

        call.enqueue(new Callback<List<LunchEntity>>() {
            @Override
            public void onResponse(Call<List<LunchEntity>> call, Response<List<LunchEntity>> response) {
                //Toast.makeText(MainActivity.this, "Connected to database", Toast.LENGTH_SHORT).show();
                List<LunchEntity> lunches = response.body();


            }

            @Override
            public void onFailure(Call<List<LunchEntity>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Could not connect to database", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
