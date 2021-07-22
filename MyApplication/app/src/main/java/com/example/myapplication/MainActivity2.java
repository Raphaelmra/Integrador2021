package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    public String nomeFornecedor;
    public String cidade;
    public String estado;
    public String telefone;
    public String site;
    public String redeSocial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inicializarFirebase();//passo - inicializar a conexão e pegar a referencia do Banco Firebase
    }

    private void pesquisarFornecedor(String palavra) {
        Query query;
        if (palavra.equals("")){

            query = databaseReference.child("cadastro");


        }else{

            query = databaseReference.child("cadastro").child(palavra);

        }




        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Pessoa p = dataSnapshot.getValue(Pessoa.class);// salvo cada um deles na variavel pessoa;
                nomeFornecedor = p.getNomeFantasia();
                telefone = p.getTelefone();
                cidade = p.getCidade();
                estado = p.getEstado();
                redeSocial = p.getRedeSocial();
                site = p.getSite();
                Intent intent4 = new Intent(getApplicationContext(), MainActivity4.class);

                Bundle parametros = new Bundle();
                parametros.putString("nomeF", nomeFornecedor);
                parametros.putString("telefoneF", telefone);
                parametros.putString("cidadeF", cidade);
                parametros.putString("estadoF", estado);
                parametros.putString("siteF", site);
                parametros.putString("redeSocialF", redeSocial);


                intent4.putExtras(parametros);
                startActivity(intent4);






            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(MainActivity2.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void voltarTela1(View view){
        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent2);
    }

    public void irParaTela5(View view){
        Intent intent2 = new Intent(getApplicationContext(), MainActivity5.class);
        startActivity(intent2);
    }
    public void irTelaCadastro(View view){
        Intent intentCadastro = new Intent(getApplicationContext(), cadastro.class);
        startActivity(intentCadastro);
    }
}