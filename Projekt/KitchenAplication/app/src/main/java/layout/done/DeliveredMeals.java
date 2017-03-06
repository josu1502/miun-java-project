package layout.done;


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
import static com.example.and12edi.kitchenaplication.MainActivity.orderClient;

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
                List<OrderEntity> finishedOrders = dbConverter.getFinishedOrders();

                for (int i = 0; i < finishedOrders.size(); i++) {
                    orderClient.deleteOrder(finishedOrders.get(i));

                }
                orderClient.fetchOrderList();
            }
        });


        return deliveredView;
    }

}
