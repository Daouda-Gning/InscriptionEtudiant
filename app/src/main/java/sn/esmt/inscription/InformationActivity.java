package sn.esmt.inscription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.inscription.http.Api;
import sn.esmt.inscription.http.EtudiantResponse;

public class InformationActivity extends AppCompatActivity {
    private EditText matriculetxt;
    private Button retourInfbt;
    private EditText nomtxt;
    private EditText prenomtxt;
    private EditText adressetxt;
    private EditText telephonetxt;
    private EditText fraistxt;
    private Button enregistrerbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        matriculetxt = (EditText) findViewById(R.id.matriculetxt);
        retourInfbt = (Button) findViewById(R.id.retourInfbt);
        nomtxt = (EditText) findViewById(R.id.nomtxt);
        prenomtxt = (EditText) findViewById(R.id.prenomtxt);
        adressetxt = (EditText) findViewById(R.id.adressetxt);
        telephonetxt = (EditText) findViewById(R.id.telephonetxt);
        fraistxt = (EditText) findViewById(R.id.fraistxt);
        enregistrerbt = (Button) findViewById(R.id.enregistrerbt);


        enregistrerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8082")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api = retrofit.create(Api.class);
                //Création de l'objet étudiant a ajouter dans la base
                EtudiantResponse e = new EtudiantResponse();
                e.setMat((matriculetxt.getText().toString()));
                e.setNom((nomtxt.getText().toString()));
                e.setPrenom((prenomtxt.getText().toString()));
                e.setAdr((adressetxt.getText().toString()));
                e.setTel(Integer.parseInt(telephonetxt.getText().toString()));
                e.setFrais(Double.parseDouble(fraistxt.getText().toString()));
                //Appel de l'API
                Call<EtudiantResponse> callSave = api.saveEtudiant(e);
                callSave.enqueue(new Callback<EtudiantResponse>() {
                    @Override
                    public void onResponse(Call<EtudiantResponse> call, Response<EtudiantResponse> response) {
                        Toast.makeText(InformationActivity.this,
                                "Etudiant inscrit avec succes",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<EtudiantResponse> call, Throwable t) {
                        Toast.makeText(InformationActivity.this,
                                "Impossible d'acceder au serveur!",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        retourInfbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationActivity.this,AccueilActivity.class);
                startActivity(intent);

            }
        });
    }
}