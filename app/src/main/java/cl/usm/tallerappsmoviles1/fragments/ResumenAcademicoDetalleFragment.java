package cl.usm.tallerappsmoviles1.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.usm.tallerappsmoviles1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResumenAcademicoDetalleFragment extends Fragment {


    public ResumenAcademicoDetalleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //setear datos alumno

        return inflater.inflate(R.layout.fragment_resumen_academico_detalle, container, false);
    }

}
