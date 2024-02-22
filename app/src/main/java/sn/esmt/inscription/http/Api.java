package sn.esmt.inscription.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @POST("/etudiants")
    Call<EtudiantResponse> saveEtudiant(@Body EtudiantResponse e);
    @GET("/etudiants")
    Call<List<EtudiantResponse>> getAllEtudiant();

}
