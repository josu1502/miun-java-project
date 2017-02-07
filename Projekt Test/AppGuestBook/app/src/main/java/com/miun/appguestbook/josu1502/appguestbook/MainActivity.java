package com.miun.appguestbook.josu1502.appguestbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MessageListener {
    RestMessageClient restMessageClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but = (Button)findViewById(R.id.buttonSend);
        but.setOnClickListener(this);

        try {
            restMessageClient = new RestMessageClient(
                    new URL("http://192.168.43.80:8080/WebGuestBook/webresources/beans.entities.messagelog/"));
            restMessageClient.setMessageListener(this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            but.setText("Bad URL");
        }
    }

    @Override
    public void onClick(View v) {

        restMessageClient.requestMessages();
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
