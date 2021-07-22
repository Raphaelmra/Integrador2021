package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity5 extends AppCompatActivity {

    private EditText CPF;
    private EditText senha;
    private EditText senha2;
    private EditText textoId;
    private EditText nomeFantasia;
    private EditText telefone;
    private EditText cidade;
    private Spinner estado;
    private EditText site;
    private EditText redeSocial;
    private Spinner tipoRedeSocial;
    private CheckBox doador;
    private String eDoador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        doador = (CheckBox) findViewById(R.id.doador);
        tipoRedeSocial = (Spinner) findViewById(R.id.tipoRedeSocial);
        redeSocial = (EditText) findViewById(R.id.redeSocial);
        CPF = (EditText) findViewById((R.id.id));
        senha = (EditText) findViewById((R.id.senha));
        senha2 = (EditText) findViewById((R.id.senha2));
        textoId = (EditText) findViewById(R.id.social);
        nomeFantasia = (EditText) findViewById(R.id.fantasia);
        nomeFantasia = (EditText) findViewById(R.id.fantasia);
        telefone = (EditText) findViewById(R.id.tel);
        cidade = (EditText) findViewById(R.id.cidade);
        estado = (Spinner) findViewById(R.id.estado);
        site =(EditText) findViewById(R.id.site);


    //get the spinner from the xml.
    Spinner dropdownEstado = findViewById(R.id.estado);
    //create a list of items for the spinner.
    String[] items = new String[]{"Estado que atua", "AC",
            "AL",
            "AP",
            "AM",
            "BA",
            "CE",
            "DF",
            "ES",
            "GO",
            "MA",
            "MT",
            "MS",
            "MG",
            "PA",
            "PB",
            "PR",
            "PE",
            "PI",
            "RJ",
            "RN",
            "RS",
            "RO",
            "RR",
            "SC",
            "SP",
            "SE",
            "TO"};
    //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdownEstado.setAdapter(adapter);

        //get the spinner from the xml.
        Spinner dropdownRedeSocial = findViewById(R.id.tipoRedeSocial);
        //create a list of items for the spinner.
        String[] redes = new String[]{"Tipo de rede social", "Instagram",
                "Facebook",
                "Outro"
                };
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapterRedeSocial = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, redes);
//set the spinners adapter to the previously created one.
        dropdownRedeSocial.setAdapter(adapterRedeSocial);
}
    public void irTela7(View view){

        //if(senha.getText().toString()=="" || s){

       // }

        String TipoRedeSocial = tipoRedeSocial.getSelectedItem().toString();
        String estadoqAtua = estado.getSelectedItem().toString();
        String s3nha = senha.getText().toString();
        String s3nha2 = senha2.getText().toString();
        String cpf = CPF.getText().toString();
        String id = textoId.getText().toString(); //razao social
        String textoNome = nomeFantasia.getText().toString(); //nome fantasia
        String textoTel = telefone.getText().toString(); //telefone
        String textoSite =  site.getText().toString(); //site
        String textoCidade =  cidade.getText().toString(); //cidade que atua
        String RedeSocial = redeSocial.getText().toString();//rede social
        if(doador.isChecked()){
            eDoador = "é doador";
        }else{
            eDoador = "não é doador";
        }
        String doadoor = eDoador.toString();


       /* if(senha.getText().toString().equals("")||senha2.getText().toString().equals("") ||CPF.getText().toString().equals("")||textoId.getText().toString().equals("") ||nomeFantasia.getText().toString().equals("") ||telefone.getText().toString().equals("")||site.getText().toString().equals("") ||cidade.getText().toString().equals("")||redeSocial.getText().toString().equals("")){
            Toast.makeText(getApplicationContext()," por favor cheque o preenchimento dos campos", Toast.LENGTH_LONG).show();
        }else{*/






             /* FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference CPFouCNPJ = database.getReference("CPF ou CNPJ");
    CPFouCNPJ.push().setValue(cpf);
    DatabaseReference RazaoSocial = database.getReference("Razao Social");
    RazaoSocial.push().setValue(id);*/
            FirebaseDatabase database = FirebaseDatabase.getInstance();

            DatabaseReference myRef = database.getReference("cadastro");

            // myRef.child("CPF ou CNPJ").push().setValue(cpf); //cpf




            Pessoa p = new Pessoa();
            p.setCpf(cpf);
            p.setRazaoSocial(id);
            p.setNomeFantasia(textoNome);
            p.setTelefone(textoTel);
            p.setSite(textoSite);
            p.setCidade(textoCidade);
            p.setTipoRedeSocial(TipoRedeSocial);
            p.setRedeSocial(RedeSocial);
            p.setSenha(s3nha);
            p.setSenhaConf(s3nha2);
            p.setDoador(doadoor);
            p.setEstado(estadoqAtua);

            Pessoa q = new Pessoa();
            //q.setMascara("true");
            //  q.setMacacao("true");


            myRef.child(p.getCpf()).setValue(p);
            myRef.child(p.getCpf()).child("produz").setValue("nada");

            //  myRef.child(p.getCpf()).child("produz").setValue(g);


       /* myRef.child("razao social").push().setValue(id); //razao social
        myRef.child("nome fantasia").push().setValue(textoNome); //nome fantasia
        myRef.child("senha").push().setValue(s3nha); //senha
        myRef.child("Confirmacao de senha").push().setValue(s3nha2); //senha2
        myRef.child("textoTel").push().setValue(textoTel); //telefone
        myRef.child("Estado que atua").push().setValue(estadoqAtua); // estado que atua
        myRef.child("Cidade que atua").push().setValue(textoCidade); //cidade
        myRef.child("textoSite").push().setValue(textoSite); //site
        myRef.child("Tipo de rede social").push().setValue(TipoRedeSocial); // Tipo Rede social
        myRef.child("Rede Social").push().setValue(RedeSocial); //rede social
        myRef.child("É doador:").push().setValue(doadoor);*/

            Intent intent8 = new Intent(getApplicationContext(), MainActivity7.class);

            Bundle parametros = new Bundle();
            parametros.putString("chave_id", cpf);
            parametros.putString("chave_nome", textoNome);
            parametros.putString("chave_site", textoSite);
            parametros.putString("chave_tel", textoTel);
            parametros.putString("chave_cidade", textoCidade);


            intent8.putExtras(parametros);
            startActivity(intent8);
      //  }





    }
    public void voltarTela3(View view){



        Intent intent7 = new Intent(getApplicationContext(), MainActivity3.class);
        startActivity(intent7);
    }
}