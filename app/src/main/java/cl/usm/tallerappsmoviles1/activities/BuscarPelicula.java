package cl.usm.tallerappsmoviles1.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import cl.usm.tallerappsmoviles1.R;
import cl.usm.tallerappsmoviles1.adapters.CineListAdapter;
import cl.usm.tallerappsmoviles1.database.AppDatabaseHelper;
import cl.usm.tallerappsmoviles1.model.Cine;

public class BuscarPelicula extends AppCompatActivity  {
    private TextView txtPelicula;
    private EditText txtNombre;
    private Button btnAceptar;
    private ToggleButton btnToggle;
    private ToggleButton btnToggleCineMax;
    //Button button = (Button) findViewById(R.id.button);

    ArrayList<Cine> cines = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine);

        //Localizar los controles
        txtPelicula = (TextView)findViewById(R.id.editText);
        btnToggle = (ToggleButton)findViewById(R.id.Hoyts);
        btnToggleCineMax = (ToggleButton)findViewById(R.id.CineMark);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();
        //Obtenemos la busqueda
        String SearchPeli = null;
        String SearchCine = null;

        if (bundle != null && !bundle.isEmpty() && !bundle.equals("null")) {
            SearchPeli=bundle.getString("Pelicula");
            SearchCine = bundle.getString("Cine");
        }
        if (SearchCine != null && !SearchCine.isEmpty() && !SearchCine.equals("null")) {
            btnToggle.setChecked(true);
        }
        //Agregamos el texto de busqueda
        txtPelicula.setText(SearchPeli);

        getCinesFromDB(SearchPeli,SearchCine);
        setCinesListView();
        btnAceptar = (Button)findViewById(R.id.button);

        //Implementamos el evento click del botón
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(BuscarPelicula.this, BuscarPelicula.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("Pelicula", txtPelicula.getText().toString());
                if (btnToggle.isChecked()){
                    b.putString("Cine", "1");//txtPelicula.getText().toString());
                }
                if (btnToggle.isChecked()){
                    b.putString("Cine", "1");//txtPelicula.getText().toString());
                }
                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });



    }


    private void getCinesFromDB(String Pelis,String Cines) {

        AppDatabaseHelper appDatabaseHelper = new AppDatabaseHelper(getApplicationContext());
        SQLiteDatabase database = appDatabaseHelper.getReadableDatabase();
        //
        //String columnas[]={"nombre"};
        String busqueda ="1";
        //String[] args = new String[] {"usu1"};
        //Cursor c = database.rawQuery(" SELECT codigo,nombre FROM Usuarios WHERE nombre=? ", args)
        Cursor resultados;
        if (!(Pelis != null && !Pelis.isEmpty() && !Pelis.equals("null") )
                && (Cines != null && !Cines.isEmpty() && !Cines.equals("null"))){
            resultados = database.query(AppDatabaseHelper.TABLE_CINES, null," cine = '" + Cines+"'", null, null, null, AppDatabaseHelper.COLUMN_NOMBRE);
        }
        if ((Pelis != null && !Pelis.isEmpty() && !Pelis.equals("null") )
                &&!(Cines != null && !Cines.isEmpty() && !Cines.equals("null") ))
        {

            resultados = database.query(AppDatabaseHelper.TABLE_CINES, null,"  nombre like '%" + Pelis+"%'", null, null, null, AppDatabaseHelper.COLUMN_NOMBRE);
        }
        if ((Pelis != null && !Pelis.isEmpty() && !Pelis.equals("null") )
                && (Cines != null && !Cines.isEmpty() && !Cines.equals("null") ))
        {

            resultados = database.query(AppDatabaseHelper.TABLE_CINES, null," nombre like '%" + Pelis+"%' and cine = '" + Cines+"' ", null, null, null, AppDatabaseHelper.COLUMN_NOMBRE);
        }
        else   {
            resultados = database.query(AppDatabaseHelper.TABLE_CINES,null,null,null,null,null,AppDatabaseHelper.COLUMN_NOMBRE);
        }

        //String select = "Select _id, title, title_raw from search Where(title_raw like " + "'%Smith%'" +")";
        //Cursor resultados = database.query(AppDatabaseHelper.TABLE_CINES, FROM,select, null, null, null, null);

        while(resultados.moveToNext()){

            Cine Cine = new Cine();

            String nombreCine = resultados.getString(resultados.getColumnIndex(AppDatabaseHelper.COLUMN_NOMBRE));
            Cine.setNombre(nombreCine);

            cines.add(Cine);
        }
        resultados.close();
        database.close();

    }

    private void setCinesListView() {

        ListView listViewCines = (ListView) findViewById(R.id.listViewCines);
        Cine[] CinesArray = cines.toArray(new Cine[0]);

        listViewCines.setAdapter(new CineListAdapter(this, CinesArray));

        listViewCines.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Creamos el Intent
                Intent intent =new Intent(BuscarPelicula.this, Pelicula.class);
                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("IdPelicula", "1");
                //startActivity(new Intent(BuscarPelicula.this,                        MapaSalaActivity.class));
                //Añadimos la información al intent
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}
