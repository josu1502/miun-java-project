package r.orderapplication;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import r.orderapplication.dinnerRest.DinnerClient;
import r.orderapplication.dinnerRest.DinnerEntities;
import r.orderapplication.dinnerRest.DinnerEntity;
import r.orderapplication.dinnerRest.DinnerStatusListener;
import r.orderapplication.orderRest.OrderClient;
import r.orderapplication.orderRest.OrderEntities;
import r.orderapplication.orderRest.OrderEntity;
import r.orderapplication.orderRest.OrderStatusListener;

import static r.orderapplication.TabActivity.dbc;


public class ShowOrderActivity extends AppCompatActivity implements OrderStatusListener {

    List<OrderEntity> list;
    OrderClient orderClient;
    DinnerClient dinnerClient;
    TextView orderTextView;

    private List<OrderEntity> appetFinalOrder;
    private List<OrderEntity> mainFinalOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);
        orderTextView = (TextView)findViewById(R.id.orderTextView);

        appetFinalOrder = dbc.getOrderAppetList();
        mainFinalOrder = dbc.getOrderMainList();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < appetFinalOrder.size(); i++){
            if(appetFinalOrder.get(i).getAmount() > 0){
                sb.append(appetFinalOrder.get(i).getAmount().toString());
                sb.append("st ");
                sb.append(appetFinalOrder.get(i).getCourseName());
                sb.append("\n");
            }
        }

        for(int i = 0; i < mainFinalOrder.size(); i++){
            if(mainFinalOrder.get(i).getAmount() > 0){
                sb.append(mainFinalOrder.get(i).getAmount().toString());
                sb.append("st ");
                sb.append(mainFinalOrder.get(i).getCourseName());
                sb.append("\n");
            }
        }
        orderTextView.setTextSize(22);
        orderTextView.setText(sb);

        orderClient = new OrderClient("http://10.250.110.144:8080/AntonsHemsida/webresources/"); /* Alex IP: */
        orderClient.setStatusListener(this);
        orderClient.fetchOrderList();

        Button btn;
        btn = (Button) findViewById(R.id.PutOrder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar currentTime = Calendar.getInstance(Locale.GERMAN);

                Calendar currentMainTime = currentTime;

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.GERMAN);

                String clockAppetTime = sdf.format(currentMainTime.getTime());
                currentMainTime.add(Calendar.MINUTE, 30);
                String clockMainTime =  sdf.format(currentTime.getTime());

               boolean containAppet = false;
                for(int i = 0; i < appetFinalOrder.size(); i++){
                   if(appetFinalOrder.get(i).getAmount() > 0){
                       containAppet = true;
                        appetFinalOrder.get(i).setOrderTime(clockAppetTime);
                        orderClient.postOrder(appetFinalOrder.get(i));
                   }

               }

                for(int i = 0; i < mainFinalOrder.size(); i++){
                    if(mainFinalOrder.get(i).getAmount() > 0){
                        if(containAppet){
                            mainFinalOrder.get(i).setOrderTime(clockMainTime);
                        }
                        else{
                            mainFinalOrder.get(i).setOrderTime(clockAppetTime);
                        }

                        orderClient.postOrder(mainFinalOrder.get(i));
                    }

                }
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                System.exit(0);
            }
        });
    }

    @Override
    public void orderListRecived(OrderEntities oe) {

        list =oe.orderEntity;
    }

    @Override
    public void orderUpdated() {

    }

}
