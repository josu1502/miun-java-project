package r.orderapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Appetizer extends Fragment {


    public Appetizer() {
        // Required empty public constructor
    }
    View fragView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater lf=getActivity().getLayoutInflater();
        fragView = lf.inflate(R.layout.fragment_appetizer, container, false);
        setSettings();
        return fragView;
    }

    public void setSettings() {
        if ( fragView == null){
            Log.d(this.getClass().toString(), "Fragment has never been created. fragView is null in setSettings");
            return;
        }
        Log.d(this.getClass().toString(), "Fragment is created. Lets change the text!");

        TextView appetizer = (TextView) fragView.findViewById(R.id.appetizer);
        appetizer.setText("TJENNAAAAAA!!!!");
    }

}
