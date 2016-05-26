package cl.usm.tallerappsmoviles1.model;

/**
 * Created by FCBDAIL on 19-05-2016.
 */
public class Cine {

    private String Cine;
    private String Nombre;

    public String getCine(){return Cine;}

    public void setCine(String Cine) {
        this.Cine = Cine;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    @Override
    public String toString() {
        return Nombre;
    }
}
