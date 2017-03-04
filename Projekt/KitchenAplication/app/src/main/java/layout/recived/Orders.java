package layout.recived;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and12edi.kitchenaplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Orders extends Fragment{
    public static View fragView;
    ReadOrders readOrders = new ReadOrders();

    public Orders() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        fragView = lf.inflate(R.layout.fragment_orders, container, false);

       //setContent();

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

