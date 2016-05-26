package cl.usm.tallerappsmoviles1.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import cl.usm.tallerappsmoviles1.R;

public class HomeActivity extends AppCompatActivity {

    String[] opciones = {
            "Mis ramos",
            "Inscripción",
            "Certificados",
            "Ficha personal",
            "Resumen académico", "Encuesta docente"
            , "Planes de Carrera","Deuda","Avance Curricular"};

    private static final int OPCION_MIS_RAMOS = 0;
    private static final int OPCION_INSCRIPCION = 1;
    private static final int OPCION_CERTIFICADOS = 2;
    private static final int OPCION_FICHA_PERSONAL = 3;
    private static final int OPCION_RESUMEN_ACADEMICO = 4;
    private static final int OPCION_ENCUESTA_DOCENTE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String nombreUsuario = getIntent().getStringExtra(MainActivity.KEY_USUARIO);

        TextView textViewNombreUsuario =
                (TextView) findViewById(R.id.textViewBienvenida);

        textViewNombreUsuario.setText("Hola " + nombreUsuario);

        setListViewOpciones();
    }

    private void setListViewOpciones() {

        ListView listViewOpciones = (ListView) findViewById(R.id.listViewOpciones);

        ArrayAdapter<String> adapterOpciones =
                new ArrayAdapter<String>(this,
                        R.layout.fila_menu,
                        opciones);

        listViewOpciones.setAdapter(adapterOpciones);

        listViewOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {

                Intent intent;

                switch (position){
                    case OPCION_MIS_RAMOS:
                        intent = new Intent(HomeActivity.this,
                                BuscarPelicula.class);
                        startActivity(intent);
                        break;
                    case OPCION_INSCRIPCION:
                        intent = new Intent(HomeActivity.this,
                                InscripcionActivity.class);
                        startActivity(intent);
                        break;
                    case OPCION_CERTIFICADOS:
                        intent = new Intent(HomeActivity.this,
                                CertificadosActivity.class);
                        startActivity(intent);
                        break;
                    case OPCION_FICHA_PERSONAL:
                        intent = new Intent(HomeActivity.this,
                                FichaPersonalActivity.class);
                        startActivity(intent);
                        break;
                    case OPCION_RESUMEN_ACADEMICO:
                        intent = new Intent(HomeActivity.this,
                                ResumenAcademicoActivity.class);
                        startActivity(intent);
                        break;
                    case OPCION_ENCUESTA_DOCENTE:
                        intent = new Intent(HomeActivity.this,
                                EncuestaDocenteActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }
}
