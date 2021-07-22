package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity8 extends AppCompatActivity {
    ItemViewModel viewModel;
    public boolean produzMascara;
    String Cpf;
    Boolean mascara;
    String mascaraDesc;
    Boolean oculos;
    Boolean pijama;
    Boolean sapato;
    Boolean alcoolEmGel;
    Boolean faceshield;
    Boolean luva;
    Boolean prope;
    Boolean capote;
    Boolean touca;
    Boolean avental;
    Boolean macacao;
    Boolean nanoPrata;
    Boolean tecido;
    Boolean plastico;
    Boolean borracha;
    Boolean elastico;
    CheckBox norte;
    CheckBox sul;
    CheckBox sudeste;
    CheckBox centroOeste;
    CheckBox nordeste;

    Boolean Norte;
    Boolean Sul;
    Boolean Sudeste;
    Boolean CentroOeste;
    Boolean Nordeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        produzMascara=true;
        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);





        Intent intentRecebedora = getIntent();
        Bundle parametros = intentRecebedora.getExtras();
        /*sudeste = (CheckBox)findViewById(R.id.sudest);
        sul = (CheckBox)findViewById(R.id.sul);
        norte =(CheckBox)findViewById(R.id.norte);
        nordeste=(CheckBox)findViewById(R.id.nordeste);
        centroOeste=(CheckBox)findViewById(R.id.co);*/

        if(parametros!=null){
            String id = parametros.getString("chave_id");

            //Toast.makeText(MainActivity7.this, "razao social: "+ id+"nome fantasia"+nome, Toast.LENGTH_LONG).show();
            Cpf = id;
            Boolean Mascara = parametros.getBoolean("mascara");
            mascara= Mascara;
            Boolean Oculos = parametros.getBoolean("oculos");
            String MascaraDesc  = parametros.getString("mascaraDesc");
            mascaraDesc = MascaraDesc;
            oculos= Oculos;
            Boolean Pijama = parametros.getBoolean("pijama");
            pijama= Pijama;
            Boolean Sapato = parametros.getBoolean("sapato");
            sapato = Sapato;

            Boolean Alcool = parametros.getBoolean("sapato");
            alcoolEmGel = Alcool;

            Boolean FaceShield = parametros.getBoolean("faceShield");
            faceshield = FaceShield;

            Boolean Luva = parametros.getBoolean("luva");
            luva = Luva;

            Boolean Prope = parametros.getBoolean("prope");
            prope = Prope;

            Boolean Capote = parametros.getBoolean("capote");
            capote = Capote;

            Boolean Touca = parametros.getBoolean("touca");
            touca = Touca;

            Boolean Avental = parametros.getBoolean("avental");
            avental = Avental;

            Boolean Macacao = parametros.getBoolean("macacao");
            macacao = Macacao;

            Boolean NanoPrata = parametros.getBoolean("nanoPrata");
            nanoPrata=NanoPrata;

            Boolean Tecido = parametros.getBoolean("tecido");
            tecido = Tecido;

            Boolean Plastico = parametros.getBoolean("plastico");
            plastico = Plastico;

            Boolean Borracha = parametros.getBoolean("borracha");
            borracha = Borracha;

            Boolean Elastico = parametros.getBoolean("elastico");
            elastico = Elastico;


        }

      /* sudeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sudeste.isChecked()){
                   Sudeste = true;
                } }
        });
        sul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sul.isChecked()){
                    Sul = true;
                } }
        });

        nordeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nordeste.isChecked()){
                    Nordeste = true;
                } }
        });

        centroOeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(centroOeste.isChecked()){
                    CentroOeste = true;
                } }
        });
        norte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(norte.isChecked()){
                    Norte = true;
                } }
        });
*/

    }

    public void voltarTela7(View view){

        //ItemViewModel.Produto y = viewModel.getProduto().getValue();
        Pessoa p =new Pessoa();
        Produto product = new Produto();


        p.setCpf(Cpf);


        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("cadastro");

/*if(Norte==true){
    myRef.child(p.getCpf()).child("entrega").child("norte").setValue(true);
}
if(Nordeste==true){
   myRef.child(p.getCpf()).child("entrega").child("nordeste").setValue(true);
}
if(Sul==true){
    myRef.child(p.getCpf()).child("entrega").child("sul").setValue(true);
}
if(CentroOeste==true){
    myRef.child(p.getCpf()).child("entrega").child("centroOeste").setValue(true);
}
if(Sudeste==true){
            myRef.child(p.getCpf()).child("entrega").child("sudeste").setValue(true);
}*/







        FirebaseDatabase db = FirebaseDatabase.getInstance();



        String a = p.getCpf();
        DatabaseReference produtos = db.getReference("produtos");
        if(mascara!=false){
            produtos.child("mascara").child(a).setValue(true);
            produtos.child("mascara").child(a).child("descrição").setValue(mascaraDesc);

            product.setMascara("true");

        }
        if(oculos!=false){
            produtos.child("oculos deprotecao").child(a).setValue(true);
            product.setOculosDeProtecao("true");
        }
        if(pijama!=false){
            produtos.child("pijama hospitalar").child(a).setValue(true);
            product.setPijamaHospitalar("true");
        }

        if(alcoolEmGel!=false){
            produtos.child("alcool em gel").child(a).setValue(true);
            product.setAlcoolEmGel("true");
        }
        if(faceshield!=false){
            produtos.child("faceshield").child(a).setValue(true);
            product.setFaceshield("true");
        }
        if(luva!=false){
            produtos.child("luva").child(a).setValue(true);
            product.setLuva("true");
        }

        if(sapato!=false){
            produtos.child("sapato").child(a).setValue(true);
            product.setSapato("true");
        }
        if(prope!=false){
            produtos.child("prope").child(a).setValue(true);
            product.setPrope("true");
        }
        if(capote!=false){
            produtos.child("capote").child(a).setValue(true);
            product.setCapote("true");
        }

        if(touca!=false){
            produtos.child("touca").child(a).setValue(true);
            product.setTouca("true");
        }
        if(avental!=false){
            produtos.child("avental").child(a).setValue(true);
            product.setAvental("true");
        }
        if(macacao!=false){
            produtos.child("macacao").child(a).setValue(true);
            product.setMacacao("true");
        }
        if(tecido!=false){
            produtos.child("tecido").child(a).setValue(true);
            product.setTecido("true");
        }
        if(plastico!=false){
            produtos.child("plastico").child(a).setValue(true);
            //product.setPlastico("true");
        }
        if(borracha!=false){
            produtos.child("borracha").child(a).setValue(true);
            //product.setBorracha("true");
        }
        if(elastico!=false){
            produtos.child("elastico").child(a).setValue(true);
            //  product.setElastico("true");
        }
        if(nanoPrata!=false){
            produtos.child("nanoprata").child(a).setValue(true);
            //product.setNanoprata("true");
        }

        //  myRef.child(p.getCpf()).child("produz").setValue(product);











        Intent intent7 = new Intent(getApplicationContext(), MainActivity7.class);
        startActivity(intent7);
    }
}