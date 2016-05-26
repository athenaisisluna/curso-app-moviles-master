package cl.usm.tallerappsmoviles1.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cl.usm.tallerappsmoviles1.R;
import cl.usm.tallerappsmoviles1.adapters.MisRamosListAdapter;
import cl.usm.tallerappsmoviles1.database.AppDatabaseHelper;
import cl.usm.tallerappsmoviles1.model.Ramo;

public class MisRamosActivity extends AppCompatActivity {

    ArrayList<Ramo> ramos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_ramos);

        getRamosFromDB();
        setRamosListView();
    }

    private void getRamosFromDB() {

        AppDatabaseHelper appDatabaseHelper = new AppDatabaseHelper(getApplicationContext());
        SQLiteDatabase database = appDatabaseHelper.getReadableDatabase();

        Cursor resultados = database.query(AppDatabaseHelper.TABLE_RAMOS,
                null,null,null,null,null,AppDatabaseHelper.COLUMN_NOMBRE);

        while(resultados.moveToNext()){

            Ramo ramo = new Ramo();

            String nombreCurso = resultados.getString(resultados.getColumnIndex(AppDatabaseHelper.COLUMN_NOMBRE));
            ramo.setNombre(nombreCurso);

            String profesorCurso = resultados.getString(resultados.getColumnIndex(AppDatabaseHelper.COLUMN_PROFESOR));
            ramo.setProfesor(profesorCurso);

            String descripcionCurso = resultados.getString(resultados.getColumnIndex(AppDatabaseHelper.COLUMN_DESCRIPCION));
            ramo.setDescripcion(descripcionCurso);

            ramos.add(ramo);
        }

    }

    private void setRamosListView() {

        ListView listViewRamos = (ListView) findViewById(R.id.listViewRamos);
        Ramo[] ramosArray = ramos.toArray(new Ramo[0]);

        listViewRamos.setAdapter(new MisRamosListAdapter(this, ramosArray));

        listViewRamos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MisRamosActivity.this,
                        MapaSalaActivity.class));
            }
        });
    }

}
