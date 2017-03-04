package r.orderapplication;


import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
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

public class Appetizer extends Fragment{
    public static View fragView;

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

    }


}
