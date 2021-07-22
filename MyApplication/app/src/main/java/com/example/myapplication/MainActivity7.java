package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity7 extends AppCompatActivity {

    String Cpf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);


        TextView nomeText =  findViewById(R.id.rsocial);
        TextView fantasiaText =  findViewById(R.id.rfantasia);
        TextView siteText =  findViewById(R.id.rsite);
        TextView telText =  findViewById(R.id.rtel);
        TextView cidadeText =  findViewById(R.id.rcidade);
        TextView estadoText =  findViewById(R.id.restado);


        Intent intentRecebedora = getIntent();
        Bundle parametros = intentRecebedora.getExtras();

        if(parametros!=null){
            String id = parametros.getString("chave_id");
            String nome = parametros.getString("chave_nome");
            String site = parametros.getString("chave_site");
            String tel = parametros.getString("chave_tel");
            String cidade = parametros.getString("chave_cidade");
            String estado = parametros.getString("chave_estado");
            //Toast.makeText(MainActivity7.this, "razao social: "+ id+"nome fantasia"+nome, Toast.LENGTH_LONG).show();
            Cpf = id;
            nomeText.setText(id);
            fantasiaText.setText(nome);
            siteText.setText(site);
            telText.setText(tel);
            cidadeText.setText(cidade);
            estadoText.setText(estado);

        }
    }

    public void cadastrarEPI(View view){




        Intent intent7 = new Intent(getApplicationContext(), MainActivity6.class);


        Bundle parametros = new Bundle();
        parametros.putString("chave_id", Cpf);



        intent7.putExtras(parametros);

        startActivity(intent7);
    }
}