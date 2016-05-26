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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cl.usm.tallerappsmoviles1.R;
import cl.usm.tallerappsmoviles1.adapters.CineListAdapter;
import cl.usm.tallerappsmoviles1.database.AppDatabaseHelper;
import cl.usm.tallerappsmoviles1.model.Cine;

public class CineActivity extends AppCompatActivity {

     //Button button = (Button) findViewById(R.id.button);
     ArrayList<Cine> cines = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine);
        getCinesFromDB();
        setCinesListView();
    }

    private void getCinesFromDB() {

        AppDatabaseHelper appDatabaseHelper = new AppDatabaseHelper(getApplicationContext());
        SQLiteDatabase database = appDatabaseHelper.getReadableDatabase();
        //Cursor resultados = database.query(AppDatabaseHelper.TABLE_CINES,null,null,null,null,null,AppDatabaseHelper.COLUMN_NOMBRE);
        String columnas[]={"nombre"};
        String busqueda ="1";
        //String[] args = new String[] {"usu1"};
        //Cursor c = database.rawQuery(" SELECT codigo,nombre FROM Usuarios WHERE nombre=? ", args)
        Cursor resultados = database.query(AppDatabaseHelper.TABLE_CINES, null," cine =" + busqueda, null, null, null, AppDatabaseHelper.COLUMN_NOMBRE);
        //String select = "Select _id, title, title_raw from search Where(title_raw like " + "'%Smith%'" +")";
        //Cursor resultados = database.query(AppDatabaseHelper.TABLE_CINES, FROM,select, null, null, null, null);

        while(resultados.moveToNext()){

            Cine Cine = new Cine();

            String nombreCine = resultados.getString(resultados.getColumnIndex(AppDatabaseHelper.COLUMN_NOMBRE));
            Cine.setNombre(nombreCine);

            cines.add(Cine);
        }
        database.close();

    }

    private void setCinesListView() {

        ListView listViewCines = (ListView) findViewById(R.id.listViewCines);
        Cine[] CinesArray = cines.toArray(new Cine[0]);

        listViewCines.setAdapter(new CineListAdapter(this, CinesArray));

        listViewCines.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(CineActivity.this,
                        MapaSalaActivity.class));
            }
        });
    }

}
