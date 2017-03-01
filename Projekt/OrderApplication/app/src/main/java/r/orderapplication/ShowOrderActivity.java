package r.orderapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import r.orderapplication.orderRest.OrderClient;
import r.orderapplication.orderRest.OrderEntities;
import r.orderapplication.orderRest.OrderEntity;
import r.orderapplication.orderRest.OrderStatusListener;

public class ShowOrderActivity extends AppCompatActivity implements OrderStatusListener {

    OrderClient orderClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);

        orderClient = new OrderClient("http://10.250.121.144:8080/AntonsHemsida/webresources/"); /* Alex IP: */
        orderClient.setStatusListener(this);
        Button btn;
        btn = (Button) findViewById(R.id.PutOrder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("listan skickadesssss!");

                OrderEntity oe = new OrderEntity();
                oe.setId(1l);
                oe.setTableNr("3");
                oe.setOrderTime("17:23");
                oe.setCourseType("Förrätt");
                oe.setCourseName("Oxbringa");

                orderClient.postOrder(oe);
                System.out.println("listan skickades!");
            }
        });
    }

    @Override
    public void orderListRecived(OrderEntities oe) {

    }

    @Override
    public void orderUpdated() {

    }
}
