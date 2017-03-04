package layout.recived;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.and12edi.kitchenaplication.R;
import com.example.and12edi.kitchenaplication.deleteRow;
import com.example.and12edi.kitchenaplication.rest.OrderClient;
import com.example.and12edi.kitchenaplication.rest.OrderEntities;
import com.example.and12edi.kitchenaplication.rest.OrderEntity;
import com.example.and12edi.kitchenaplication.rest.OrderStatusListener;

import java.util.List;

import static layout.recived.Orders.fragView;

/**
 * Created by Mvangman on 2017-03-03.
 */

public class Read_Orders extends AppCompatActivity implements OrderStatusListener{
    public static OrderClient orderClient;
    List<OrderEntity> orderList;
    TabLayout tabLayout ;

    public static TableLayout tl;
    public void set(){
        orderClient = new OrderClient("http://10.250.111.2:8080/AntonsHemsida/webresources/");
        orderClient.setStatusListener(this);
        orderClient.fetchOrderList();
    }
    @Override
    public void orderListRecived(OrderEntities oe) {

        orderList = oe.orderEntities;
        System.out.println(orderList.size());
        tl = (TableLayout) fragView.findViewById(R.id.tableLayout2);

        TableRow tableRowTitle = new TableRow(this);
        TextView bord = new TextView(this);
        bord.setText("Bord");
        bord.setTextSize(32);
        TextView course = new TextView(this);
        course.setText("Förrätt/Varmrätt");
        course.setTextSize(32);
        TextView meal = new TextView(this);
        meal.setText("Maträtt");
        meal.setTextSize(32);
        TextView antal = new TextView(this);
        antal.setText("Antal");
        antal.setTextSize(32);
        TextView tid = new TextView(this);
        tid.setText("Tid");
        tid.setTextSize(32);
        TextView status = new TextView(this);
        status.setText("Status");
        status.setTextSize(32);
        tableRowTitle.addView(bord);
        tableRowTitle.addView(course);
        tableRowTitle.addView(meal);
        tableRowTitle.addView(antal);
        tableRowTitle.addView(tid);
        tableRowTitle.addView(status);
        tl.addView(tableRowTitle);

        for(int i = 0; i <orderList.size(); i++) {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(lp);

            TextView tableNumber = new TextView(this);
            tableNumber.setText(oe.orderEntities.get(i).getTableNr().toString());
            TextView courseType = new TextView(this);
            courseType.setText(oe.orderEntities.get(i).getCourseType());
            TextView courseName = new TextView(this);
            courseName.setText(oe.orderEntities.get(i).getCourseName());
            TextView amount = new TextView(this);
            amount.setText(oe.orderEntities.get(i).getAmount().toString());
            TextView time = new TextView(this);
            time.setText(oe.orderEntities.get(i).getOrderTime().toString());

            Button done = new Button(this);
            done.setText("klar");

            done.setOnClickListener(new deleteRow(oe.orderEntities.get(i)));

            tableRow.addView(tableNumber);
            tableRow.addView(courseType);
            tableRow.addView(courseName);
            tableRow.addView(amount);
            tableRow.addView(time);
            tableRow.addView(done);
            tl.addView(tableRow);
        }



    }

    @Override
    public void orderUpdated() {

    }
}
