package com.miun.appguestbook.josu1502.appguestbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miun.appguestbook.josu1502.appguestbook.rest.LunchClient;
import com.miun.appguestbook.josu1502.appguestbook.rest.LunchEntities;
import com.miun.appguestbook.josu1502.appguestbook.rest.LunchEntity;
import com.miun.appguestbook.josu1502.appguestbook.rest.LunchRest;
import com.miun.appguestbook.josu1502.appguestbook.rest.LunchStatusListener;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity implements LunchStatusListener {
    TextView textView;
    LunchClient lunchClient;
    private LunchEntity lunch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Jockes IP-adress: "http://192.168.43.80:8080/AntonsHemsida/webresources/beans.entities.lunchentity"*/

        textView = (TextView) findViewById(R.id.textView);
        lunchClient = new LunchClient("http://192.168.43.80:8080/AntonsHemsida/webresources/");
        lunchClient.setStatusListener(this);
        lunchClient.fetchLunchList();

        Button button = (Button) findViewById(R.id.buttonSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Create entity example*/
                /* LunchEntity le = new LunchEntity();
                le.setDayNo(1);
                le.setDescription("Big Mac");
                le.setId(0l);
                le.setLunchday("Måndag");
                le.setName("McDonalds");
                le.setPrice(185);

                lunchClient.postLunch(le);
                */

                /*Tar bort angiven lunch från listan*/
                lunchClient.deleteLunch(lunch);

            }
        });
    }

    @Override
    public void lunchListRecived(LunchEntities le) {
        textView.setText("Lyckat! " + le.lunchEntity.size());
        lunch = le.lunchEntity.get(0);
        lunch.setName("Körv me mos");

    }

    @Override
    public void lunchUpdated() {

    }
}
