package com.miun.appguestbook.josu1502.appguestbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miun.appguestbook.josu1502.appguestbook.rest.LunchEntities;
import com.miun.appguestbook.josu1502.appguestbook.rest.LunchEntity;
import com.miun.appguestbook.josu1502.appguestbook.rest.LunchRest;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Jockes IP-adress: "http://192.168.43.80:8080/AntonsHemsida/webresources/beans.entities.lunchentity"*/

        textView = (TextView) findViewById(R.id.textView);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.43.80:8080/AntonsHemsida/webresources/")
                .client(httpClient.build()).addConverterFactory(SimpleXmlConverterFactory.create());

        Retrofit retrofit = builder.build();

        LunchRest client = retrofit.create(LunchRest.class);
        Call<LunchEntities> call = client.getLunches();

        call.enqueue(new Callback<LunchEntities>() {
            @Override
            public void onResponse(Call<LunchEntities> call, Response<LunchEntities> response) {
                Toast.makeText(MainActivity.this, "Connected to database", Toast.LENGTH_SHORT).show();
                LunchEntities lunches = response.body();

                String testMsg = "";

                for (int i = 0; i < lunches.lunchEntity.size(); i++) {
                    testMsg += lunches.lunchEntity.get(i).getName();
                    testMsg += "\n";
                    testMsg += lunches.lunchEntity.get(i).getDescription();
                    testMsg += "\n";
                    testMsg += "\n";
                }

                textView.setText(testMsg);
            }

            @Override
            public void onFailure(Call<LunchEntities> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Could not connect to database", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
