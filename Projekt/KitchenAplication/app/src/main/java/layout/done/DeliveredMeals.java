package layout.done;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.and12edi.kitchenaplication.R;
import com.example.and12edi.kitchenaplication.rest.OrderEntity;

import java.util.List;

import static com.example.and12edi.kitchenaplication.MainActivity.dbConverter;
import static com.example.and12edi.kitchenaplication.MainActivity.finishedTable;
import static com.example.and12edi.kitchenaplication.MainActivity.orderClient;
import static com.example.and12edi.kitchenaplication.MainActivity.orderList;
import static com.example.and12edi.kitchenaplication.MainActivity.unFinishedTable;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveredMeals extends Fragment {
    public static View deliveredView;

    public DeliveredMeals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        deliveredView = lf.inflate(R.layout.fragment_delivered__meals, container, false);

        Button clearButton = (Button) deliveredView.findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(orderList == null){
                    return;
                }

                if(orderList.size() >0) {
                    List<OrderEntity> finishedOrders = dbConverter.getFinishedOrders();
                    List <OrderEntity> unFinishedOrders = dbConverter.getUnfinishedOrders();

                    for (int i = 0; i < finishedOrders.size(); i++) {
                        orderClient.deleteOrder(finishedOrders.get(i));

                    }

                    if(finishedOrders.size() >= 1 && unFinishedOrders.size() == 0){
                        finishedTable.removeAllViews();
                        unFinishedTable.removeAllViews();
                        orderList.clear();
                    }
                }
            }
        });


        return deliveredView;
    }

}
