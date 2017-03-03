package r.orderapplication;


import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import r.orderapplication.dinnerRest.DinnerClient;
import r.orderapplication.dinnerRest.DinnerEntities;
import r.orderapplication.dinnerRest.DinnerEntity;
import r.orderapplication.dinnerRest.DinnerStatusListener;
import r.orderapplication.orderRest.OrderClient;
import r.orderapplication.orderRest.OrderEntities;
import r.orderapplication.orderRest.OrderStatusListener;


/**
 * A simple {@link Fragment} subclass.
 */

public class Appetizer extends Fragment implements DinnerStatusListener{
    View fragView;
    TextView textView;

    public Appetizer() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf = getActivity().getLayoutInflater();
        fragView = lf.inflate(R.layout.fragment_appetizer, container, false);
        setSettings();
        return fragView;
    }

    public void setSettings() {
        if (fragView == null) {
            Log.d(this.getClass().toString(), "Fragment has never been created. fragView is null in setSettings");
            return;
        }
        Log.d(this.getClass().toString(), "Fragment is created. Lets change the text!");
        DinnerClient dc = new DinnerClient("http://10.250.110.164:8080/AntonsHemsida/webresources/");
        dc.setStatusListener(this);
        dc.fetchDinnerList();

    }

    @Override
    public void dinnerListRecived(DinnerEntities de) {

        List<DinnerEntity> list = de.dinnerEntity;
        textView = (TextView)fragView.findViewById(R.id.textView);


        String måltid = list.get(0).getName();
        måltid+="\n";
        måltid+= list.get(0).getDescription();
        måltid+=" ";
        måltid+=list.get(0).getPrice().toString();
        måltid+=":-";

        textView.setText(måltid);

    }

    @Override
    public void dinnerUpdated() {

    }
}
