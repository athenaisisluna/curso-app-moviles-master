package cl.usm.tallerappsmoviles1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import cl.usm.tallerappsmoviles1.R;
import cl.usm.tallerappsmoviles1.model.Ramo;

/**
 * Created by JulioAndres on 4/2/16.
 */
public class MisRamosListAdapter extends ArrayAdapter<Ramo> {

    private final Context context;
    private final Ramo[] ramos;

    public MisRamosListAdapter(Context context, Ramo[] ramos) {
        super(context, -1, ramos);
        this.context=context;
        this.ramos=ramos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.fila_mi_curso, parent, false);

        TextView nombreTextView = (TextView) rowView.findViewById(R.id.textViewFilaNombreCurso);
        TextView profesorTextView = (TextView) rowView.findViewById(R.id.textViewFilaProfesorCurso);
        TextView descripcionTextView = (TextView) rowView.findViewById(R.id.textViewDescripcionCurso);

        nombreTextView.setText(ramos[position].getNombre());
        profesorTextView.setText(ramos[position].getProfesor());
        descripcionTextView.setText(ramos[position].getDescripcion());


        return rowView;
    }
}
