package sn.esmt.inscription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnexionActivity extends AppCompatActivity {
    private EditText emailtxt;
    private EditText mdptxt;
    private Button loginbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        //Recupération des valeurs saisies
        emailtxt = (EditText) findViewById(R.id.emailtxt);
        mdptxt = (EditText) findViewById(R.id.mdptxt);
        //Recuperation de l'ID du bouton login
        loginbt = (Button) findViewById(R.id.loginbt);

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailtxt.getText().toString();
                String mdp = mdptxt.getText().toString();
                if(email.isEmpty() || mdp.isEmpty()){
                    Toast.makeText(ConnexionActivity.this,"Veuillez renseigner les champs",Toast.LENGTH_LONG).show();
                }
                else{
                    if(email.equals("esmt@esmt.sn") && mdp.equals("123")){
                        Intent intent = new Intent(ConnexionActivity.this,AccueilActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(ConnexionActivity.this,"Email ou mot de passe incorrect",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}