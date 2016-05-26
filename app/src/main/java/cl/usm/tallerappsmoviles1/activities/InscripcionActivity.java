package cl.usm.tallerappsmoviles1.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import cl.usm.tallerappsmoviles1.R;
import cl.usm.tallerappsmoviles1.model.Ramo;
import cl.usm.tallerappsmoviles1.model.RamoDTO;
import cl.usm.tallerappsmoviles1.network.BackEndAPI;
import cl.usm.tallerappsmoviles1.network.BackEndClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class InscripcionActivity extends AppCompatActivity implements Callback<RamoDTO> {

    private static final String getCursosURL = "http://wearenicecorp.com/apps/siga_app/cursos.php";

    ArrayList<Ramo> ramos = new ArrayList<>();
    private CursosAdapter cursosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscripcion);

        ListView listViewRamos = (ListView) findViewById(R.id.listViewRamos);

        cursosAdapter = new CursosAdapter();
        listViewRamos.setAdapter(cursosAdapter);

        getRamos();
    }

    public void getRamos(){

        //Se hacen los llamados al webservice
        Retrofit retrofit = BackEndClient.getClient();
        BackEndAPI backEndAPI = retrofit.create(BackEndAPI.class);
        Call<RamoDTO> call = backEndAPI.getCursos();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<RamoDTO> call, Response<RamoDTO> response) {

        if(response.isSuccessful()){
            ramos.addAll(response.body().getRamos());
            cursosAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onFailure(Call<RamoDTO> call, Throwable t) {

    }

    private class CursosAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return ramos.size();
        }

        @Override
        public Ramo getItem(int pos) {
            return ramos.get(pos);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Ramo ramo = getItem(position);

            View row = getLayoutInflater().inflate(R.layout.fila_curso, parent, false);

            TextView nombreTextView = (TextView)row.findViewById(R.id.textViewFilaNombreCurso);
            nombreTextView.setText(ramo.getNombre());

            TextView descripcionTextView = (TextView)row.findViewById(R.id.textViewFilaDescCurso);
            descripcionTextView.setText(ramo.getDescripcion());

            return row;
        }
    }
}
