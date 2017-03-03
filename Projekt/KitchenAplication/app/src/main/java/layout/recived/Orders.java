package layout.recived;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class Orders extends Fragment{
    public static View fragView;
    Read_Orders readOrders = new Read_Orders();




    public Orders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        fragView = lf.inflate(R.layout.fragment_orders, container, false);

       // setContent();

        return fragView;
    }

    public void setContent() {
        if(fragView == null){
            Log.d(this.getClass().toString(), "Fragment has never been created!");
            return;
        }
        Log.d(this.getClass().toString(),"Fragment is created!");
        readOrders.set();


        }


}

