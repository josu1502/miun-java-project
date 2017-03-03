package r.orderapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import r.orderapplication.dinnerRest.DinnerClient;
import r.orderapplication.dinnerRest.DinnerEntities;
import r.orderapplication.dinnerRest.DinnerEntity;
import r.orderapplication.dinnerRest.DinnerStatusListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Main_course extends Fragment implements DinnerStatusListener  {


    public Main_course() {

    }
    View fragView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf=getActivity().getLayoutInflater();
        fragView = lf.inflate(R.layout.fragment_main_course, container, false);
        setSettings();
        return fragView;
    }

    public void setSettings() {
        if ( fragView == null){
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

        String måltid = list.get(1).getName();
        måltid+="\n";
        måltid+= list.get(1).getDescription();
        måltid+="\n";
        måltid+=list.get(1).getPrice();
        måltid+=":-";

        TextView textView = (TextView)fragView.findViewById(R.id.mainCourse);
        textView.setText(måltid);
    }

    @Override
    public void dinnerUpdated() {

    }
}
