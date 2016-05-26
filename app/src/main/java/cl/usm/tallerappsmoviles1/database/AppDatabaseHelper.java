package cl.usm.tallerappsmoviles1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JulioAndres on 3/31/16.
 */
public class AppDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sigaxzx_app.db";
    private static final int DB_VERSION = 5;
    private static final String CREATE_TABLE_RAMOS ="CREATE TABLE ramos (codigo TEXT, nombre TEXT,descripcion TEXT, profesor TEXT)";
    private static final String CREATE_TABLE_CINES ="CREATE TABLE cines (cine TEXT, nombre TEXT,longitug TEXT, latitud TEXT)";
    private static final String CREATE_TABLE_PELICULAS ="CREATE TABLE peliculas (cine TEXT, nombre TEXT,categoria TEXT,)";

    public static final String TABLE_RAMOS= "ramos";
    public static final String TABLE_CINES= "cines";
    public static final String COLUMN_CODIGO = "codigo";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_CINE = "cine";
    public static final String COLUMN_DESCRIPCION = "descripcion";
    public static final String COLUMN_PROFESOR = "profesor";

    public AppDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(CREATE_TABLE_RAMOS);
        crearDatosFalsos(database);

        database.execSQL(CREATE_TABLE_CINES);
        crearDatosFalsos(database);
    }

    private void crearDatosFalsos(SQLiteDatabase database) {

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CINE, "1");
        cv.put(COLUMN_NOMBRE, "Hoyts");

        database.insert(TABLE_CINES, null, cv);

        cv.clear();

        cv.put(COLUMN_CINE, "2");
        cv.put(COLUMN_NOMBRE, "CineMarx");

        database.insert(TABLE_CINES, null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldDBVersion, int newDBVersion) {
        
        onCreate(database);
        crearDatosFalsos(database);

    }
}
