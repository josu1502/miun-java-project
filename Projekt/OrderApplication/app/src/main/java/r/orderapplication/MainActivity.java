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
   public static Integer tableNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText table;
        table = (EditText)findViewById(R.id.table);
        Button button;
        button = (Button)findViewById(R.id.btn5);



      button.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {

                tableNr = table.getText().toString();
                tableNumber=Integer.parseInt(tableNr);
                if (!tableNr.equals("0") && !tableNr.equals("")) {
                    startActivity(new Intent(MainActivity.this, TabActivity.class));
                }

                }
       });
    }

}
