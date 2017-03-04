package r.orderapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import r.orderapplication.dinnerRest.DinnerClient;
import r.orderapplication.dinnerRest.DinnerEntities;
import r.orderapplication.dinnerRest.DinnerEntity;
import r.orderapplication.dinnerRest.DinnerStatusListener;
import r.orderapplication.orderRest.OrderClient;
import r.orderapplication.orderRest.OrderEntities;
import r.orderapplication.orderRest.OrderEntity;
import r.orderapplication.orderRest.OrderStatusListener;


public class ShowOrderActivity extends AppCompatActivity implements OrderStatusListener {

    List<OrderEntity> list;
    OrderClient orderClient;
    DinnerClient dinnerClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);

        orderClient = new OrderClient("http://192.168.1.7:8080/AntonsHemsida/webresources/"); /* Alex IP: */
        orderClient.setStatusListener(this);
        orderClient.fetchOrderList();

        Button btn;
        btn = (Button) findViewById(R.id.PutOrder);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OrderEntity oe = new OrderEntity();

                oe.setTableNr(3);
                oe.setOrderTime("17:23");
                oe.setCourseType("appetizer");
                oe.setCourseName("Oxbringa");
                oe.setAmount(2);
                oe.setFinished(true);

                orderClient.postOrder(oe);

                System.out.println("listan skickades!");
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
