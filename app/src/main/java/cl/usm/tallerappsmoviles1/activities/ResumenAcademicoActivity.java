package cl.usm.tallerappsmoviles1.activities;

import android.animation.Animator;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import cl.usm.tallerappsmoviles1.R;
import cl.usm.tallerappsmoviles1.fragments.ResumenAcademicoCabaceraFragment;
import cl.usm.tallerappsmoviles1.fragments.ResumenAcademicoDetalleFragment;

public class ResumenAcademicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_academico);

        ResumenAcademicoCabaceraFragment resumenAcademicoCabaceraFragment =
                new ResumenAcademicoCabaceraFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentsContainerFrameLayout,
                resumenAcademicoCabaceraFragment);
        fragmentTransaction.commit();

        setearBoton();
    }

    private void setearBoton() {

        ToggleButton detalleButton = (ToggleButton)
                findViewById(R.id.detalleToggleButton);

        if(detalleButton != null){
            detalleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton,
                                             boolean isOn) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    if(isOn){
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_left,
                                R.anim.slide_out_to_right);
                        fragmentTransaction.replace(R.id.fragmentsContainerFrameLayout,
                                new ResumenAcademicoDetalleFragment());
                    }else{
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_from_right,
                                R.anim.slide_out_to_left);
                        fragmentTransaction.replace(R.id.fragmentsContainerFrameLayout,
                                new ResumenAcademicoCabaceraFragment());
                    }
                    fragmentTransaction.commit();
                }
            });
        }
    }
}
