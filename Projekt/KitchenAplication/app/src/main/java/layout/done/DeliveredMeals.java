package layout.done;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and12edi.kitchenaplication.R;

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
        return deliveredView;
    }

}
