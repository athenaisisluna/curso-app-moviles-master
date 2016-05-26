package cl.usm.tallerappsmoviles1.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.usm.tallerappsmoviles1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FichaPersonalFragment extends Fragment {


    public FichaPersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ficha_personal, container, false);
    }

}
