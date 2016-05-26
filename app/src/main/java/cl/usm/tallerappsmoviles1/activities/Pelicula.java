package cl.usm.tallerappsmoviles1.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import cl.usm.tallerappsmoviles1.R;
import cl.usm.tallerappsmoviles1.database.AppDatabaseHelper;
import cl.usm.tallerappsmoviles1.model.Cine;

/**
 * Created by FCBDAIL on 22-05-2016.
 */
public class Pelicula extends AppCompatActivity {

    private TextView resumenpelicula;
    private ImageView imagenpelicula;
    private String IdPelicula;
    //Button button = (Button) findViewById(R.id.button);
    ArrayList<Cine> cines = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);
        //Localizar los controles
        imagenpelicula = (ImageView)findViewById(R.id.imagenpelicula);
        resumenpelicula = (TextView)findViewById(R.id.textopelicula);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        IdPelicula = bundle.getString("IdPelicula");

        getPeliFromDB(IdPelicula);


    }
    private void getPeliFromDB(String IdPeli) {

        AppDatabaseHelper appDatabaseHelper = new AppDatabaseHelper(getApplicationContext());
        SQLiteDatabase database = appDatabaseHelper.getReadableDatabase();
        //
        //String columnas[]={"nombre"};
        String busqueda ="1";
        //String[] args = new String[] {"usu1"};
        //Cursor c = database.rawQuery(" SELECT codigo,nombre FROM Usuarios WHERE nombre=? ", args)
        Cursor resultados;
        resultados = database.query(AppDatabaseHelper.TABLE_CINES, null," cine = '" + IdPeli+"'", null, null, null,null);
        //String select = "Select _id, title, title_raw from search Where(title_raw like " + "'%Smith%'" +")";
        //Cursor resultados = database.query(AppDatabaseHelper.TABLE_CINES, FROM,select, null, null, null, null);

        while(resultados.moveToNext()){

            Cine Cine = new Cine();

            resumenpelicula.setText(resultados.getString(resultados.getColumnIndex(AppDatabaseHelper.COLUMN_NOMBRE)));
        }
        resultados.close();
        database.close();

    }
}
