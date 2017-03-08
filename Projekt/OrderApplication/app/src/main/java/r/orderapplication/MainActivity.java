package r.orderapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static String tableNr;
    public static Integer tableNumber = 0;
    public static TextView bigNumber;
    private Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(tb);

        if(tb != null){
            setSupportActionBar(tb);
            tb.setLogo(R.mipmap.ic_launcher);
        }


        bigNumber = (TextView) findViewById(R.id.bigNumber);

        final EditText table;
        table = (EditText) findViewById(R.id.table);
        Button button;
        button = (Button) findViewById(R.id.btn5);

        table.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (!(table.getText().toString().equals(""))) {
                    bigNumber.setText(table.getText());
                }
                if (i == KeyEvent.KEYCODE_ENTER) {
                    if (!(table.getText().toString().equals(""))) {
                        tableNr = table.getText().toString();
                        tableNumber = Integer.parseInt(tableNr);
                    }
                    if (tableNumber > 0) {

                        startActivity(new Intent(MainActivity.this, TabActivity.class));
                    }
                    return true;
                }
                return false;
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(table.getText().toString().equals(""))) {
                    tableNr = table.getText().toString();
                    tableNumber = Integer.parseInt(tableNr);
                }
                if (tableNumber > 0) {

                    startActivity(new Intent(MainActivity.this, TabActivity.class));
                }

            }
        });


    }
}
