package com.miun.appguestbook.josu1502.appguestbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.miun.appguestbook.josu1502.appguestbook.rest.LunchEntities;
import com.miun.appguestbook.josu1502.appguestbook.rest.RestaurantEndpoints;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MessageListener {
    TextView lunchTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Jockes IP-adress: "http://192.168.43.80:8080/AntonsHemsida/webresources/beans.entities.lunchentity"*/

        lunchTextView = (TextView) findViewById(R.id.textViewer);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("http://192.168.43.80:8080/AntonsHemsida/webresources/")
                .client(httpClient.build()).addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        RestaurantEndpoints rep = rf.create(RestaurantEndpoints.class);
        Call<LunchEntities> call = rep.getLunches();
        call.enqueue(new Callback<LunchEntities>() {
            @Override
            public void onResponse(Call<LunchEntities> call, Response<LunchEntities> response) {
                lunchTextView.setText("Success");
            }

            @Override
            public void onFailure(Call<LunchEntities> call, Throwable t) {
                lunchTextView.setText("Failed" + t);

            }
        });

    }

    @Override
    public void onClick(View v) {
        /*Action for Add button*/
    }

    @Override
    public void messageRecived(List<Message> lom) {
        TextView textView = (TextView) findViewById(R.id.textViewer);
        String contents = "";

        for(Message m:lom) {
        contents += m.getName() +": " + m.getMessage() + "\n";
        }
        textView.setText(contents);
    }
}
