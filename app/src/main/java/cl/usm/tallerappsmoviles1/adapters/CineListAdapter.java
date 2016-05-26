package cl.usm.tallerappsmoviles1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import cl.usm.tallerappsmoviles1.R;
import cl.usm.tallerappsmoviles1.model.Cine;

/**
 * Created by JulioAndres on 4/2/16.
 */
public class CineListAdapter extends ArrayAdapter<Cine> {

    private final Context context;
    private final Cine[] cines;

    public CineListAdapter(Context context, Cine[] cines) {
        super(context, -1, cines);
        this.context=context;
        this.cines=cines;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.fila_mi_curso, parent, false);

        TextView nombreTextView = (TextView) rowView.findViewById(R.id.textViewFilaNombreCurso);

        nombreTextView.setText(cines[position].getNombre());

        return rowView;
    }
}
