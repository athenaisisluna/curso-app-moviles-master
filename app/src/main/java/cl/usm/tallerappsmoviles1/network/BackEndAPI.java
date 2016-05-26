package cl.usm.tallerappsmoviles1.network;

import cl.usm.tallerappsmoviles1.model.RamoDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by JulioAndres on 4/26/16.
 */
public interface BackEndAPI {

    @GET("cursos.php")
    Call<RamoDTO> getCursos();

    @POST("preguntas")
    Call<RamoDTO> postearPregunta();

}
