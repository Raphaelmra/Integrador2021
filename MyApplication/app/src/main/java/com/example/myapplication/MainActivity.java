package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    //Componentes da tela arquivo.xml

    private EditText editPalavra;
    private TextView editPalavra2;
    private TextView editPalavra3;
    private ListView listVPesquisa;
    //    //android:icon="@mipmap/ic_launcher"
    //Objetos de conexão com o Banco Firebase
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    //Objetos de manipulação da List View
    private List<People> listPessoa = new ArrayList<People>();
    private ArrayAdapter<People> arrayAdapterPessoa;
    private People pessoaSelecionada;

    //Objetos de manipulação da List View
    private List<Pessoa> listPessoa2 = new ArrayList<Pessoa>();
    private ArrayAdapter<Pessoa> arrayAdapterPessoa2;
    private Pessoa pessoaSelecionada2;

    public String nomeFornecedor;
    public String cidade;
    public String estado;
    public String telefone;
    public String site;
    public String redeSocial;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editPalavra = (EditText)findViewById(R.id.editTextTextPersonName);

        editPalavra2 = (TextView) findViewById(R.id.textView9);
        editPalavra3 = (TextView) findViewById(R.id.textView10);
        // Write a message to the database
        // myRef.setValue("Hello, World!");
        inicializarComponentes();// inicializar os componentes da tela e referencia-los
        inicializarFirebase();//passo - inicializar a conexão e pegar a referencia do Banco Firebase
        eventoEdit();// passo - implementos os eventos que serão utilizando durante a aplicação

        listVPesquisa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pessoaSelecionada = (People)parent.getItemAtPosition(position);
                pesquisarFornecedor(pessoaSelecionada.getCpf());

                Toast.makeText(getApplicationContext(),"produto: " + pessoaSelecionada.getCpf(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void eventoEdit() {
        editPalavra.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) { // apos digitar
                String palavra = editPalavra.getText().toString().trim(); // armaze o valor do editText
                //  pesquisarPalavra(palavra); // 4º passo - enviar a palavra para ser pesquisada no banco
            }
        });
    }
   /* private void pesquisarFornecedor(String palavra) {
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("cadastro");
        usersRef.orderByChild("11")

                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        listaFornc = new ArrayList<>();
                        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                            Pessoa user = postSnapshot.getValue(Pessoa.class);


                            listaFornc.add(user);
                        }

                        arrayFornc = new ArrayAdapter<Pessoa>(MainActivity.this,
                                android.R.layout.simple_list_item_1,listaFornc);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("onQueryTextChange: " ,databaseError.getMessage());
                    }
                });



    }*/


    private void pesquisarFornecedor(String palavra) {
        Query query; // cria o objeto que ira receber os dados da pesquisa
        if (palavra.equals("")){// verifica o conteudo da variavel
            // caso a palavra esteja vazia, sejá exibido todos os objetos da tabela produto
            query = databaseReference.child("cadastro");
            ;
            //query = databaseReference.child("produtos");

        }else{
            /// caso palavra tenha algum valor
            // trazermos todos os objetos de formar que o primeiro a ser buscado no banco
            // é exatamente iqual a palavra enviada - starAt
            // e os seguintes sera a palavra e mais qualquer outro valor de string - endAt
            // a string  "\uf8ff" indica que retornará qualquer valor apos a palavra inicial
            query = databaseReference.child("cadastro").child(palavra);

        }



        // implemento o metodo na query
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Pessoa p = dataSnapshot.getValue(Pessoa.class);// salvo cada um deles na variavel pessoa;

               // String palavra1 = p.getCpf(); // armaze o valor do editText
                //editPalavra2.setText(palavra);
               // String palavra2 = p.getNomeFantasia(); // armaze o valor do editText
               // editPalavra3.setText(palavra2);
               // editPalavra3.setText(palavra2);

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






    private void pesquisarPalavra(String palavra) {
        Query query; // cria o objeto que ira receber os dados da pesquisa
        if (palavra.equals("")){// verifica o conteudo da variavel
            // caso a palavra esteja vazia, sejá exibido todos os objetos da tabela produto
            query = databaseReference.child("produtos");
            ;
            //query = databaseReference.child("produtos");

        }else{
            /// caso palavra tenha algum valor
            // trazermos todos os objetos de formar que o primeiro a ser buscado no banco
            // é exatamente iqual a palavra enviada - starAt
            // e os seguintes sera a palavra e mais qualquer outro valor de string - endAt
            // a string  "\uf8ff" indica que retornará qualquer valor apos a palavra inicial
            query = databaseReference.child("produtos").child(palavra);

        }



        // implemento o metodo na query
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){// separo cada objeto contido na dataSnapshot
                    People p = objSnapshot.getValue(People.class);// salvo cada um deles na variavel pessoa;
                    listPessoa.add(p);// adiciono na list<Pessoa>
                }

                // inicializo o arrayAdapter passando o contexto da aplicação
                // a tipo de layout da lista, e a list<Pessoa> contendo os objetos
                arrayAdapterPessoa = new ArrayAdapter<People>(MainActivity.this,
                        android.R.layout.simple_list_item_1,listPessoa);

                // incluo na ListView o arrayAdapter
                listVPesquisa.setAdapter(arrayAdapterPessoa);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }



    private void inicializarFirebase() {
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void inicializarComponentes() {
        editPalavra = (EditText) findViewById(R.id.editTextTextPersonName);
        listVPesquisa = (ListView) findViewById(R.id.listVPesquisa);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // ultimo passo - assim que mostra a tela quero que seja exibido todos os dados contidos no Banco
        //pesquisarPalavra("Alcool em gel");
        //pesquisarFornecedor("");
    }






    public void irParaTela2(View view){

        Intent intent1 = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent1);

    }
    public void irParaTela1(View view){

        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent1);

    }
    public void buscar(View view){
        String palavra = editPalavra.getText().toString(); // armaze o valor do editText
        // editPalavra2.setText(palavra);
        pesquisarPalavra(palavra); // 4º passo - enviar a palavra para ser pesquisada no banc

    }

    public void irParaTela3(View view){
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

        // String palavra = editPalavra.getText().toString(); // armaze o valor do editText
        // editPalavra2.setText(palavra);
        // pesquisarPalavra(palavra); // 4º passo - enviar a palavra para ser pesquisada no banc
        // Intent intent3 = new Intent(getApplicationContext(), MainActivity3.class);
        // startActivity(intent3);
    }
    public void irParaTela4(View view){


    }
}


