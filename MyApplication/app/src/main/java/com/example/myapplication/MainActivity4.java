package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    public TextView nomeFornecedor;
    public TextView cidade;
    public TextView estado;
    public TextView telefone;
    public TextView site;
    public TextView redeSocial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        nomeFornecedor = (TextView) findViewById(R.id.textView2);
        cidade = (TextView) findViewById(R.id.textView3);
        estado = (TextView) findViewById(R.id.textView4);
        telefone = (TextView) findViewById(R.id.textView5);
        site = (TextView) findViewById(R.id.textView11);
        redeSocial = (TextView) findViewById(R.id.textView12);
        Intent intentRecebedora = getIntent();
        Bundle parametros = intentRecebedora.getExtras();

        if(parametros!=null){
            String id = parametros.getString("nomeF");
            nomeFornecedor.setText(id);

            String Cidade = parametros.getString("cidadeF");
            cidade.setText(Cidade);
            String Estado = parametros.getString("estadoF");
            estado.setText(Estado);
            String Telefone = parametros.getString("telefoneF");
            telefone.setText(Telefone);
            String Site = parametros.getString("siteF");
            site.setText(Site);
            String RedeSocial = parametros.getString("redeSocialF");
            redeSocial.setText(RedeSocial);


        }
    }
    public void voltarTela3(View view){
        Intent intent5 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent5);
    }

}