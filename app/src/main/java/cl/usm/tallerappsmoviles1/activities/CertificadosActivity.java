package cl.usm.tallerappsmoviles1.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cl.usm.tallerappsmoviles1.R;

public class CertificadosActivity extends AppCompatActivity {

    String[] certificados = {"Alumno regular",
            "Titulado",
            "Egreso",
            "Licenciado"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificados);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerCertificados);

        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,certificados );

        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(-1);
    }
}
