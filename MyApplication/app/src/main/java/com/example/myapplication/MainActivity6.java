package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity6 extends AppCompatActivity {
    ItemViewModel viewModel;
    private androidx.constraintlayout.widget.Group grupo;
    private androidx.constraintlayout.widget.Group grupo2;
    private androidx.constraintlayout.widget.Group grupo3;
private CheckBox mascara;
private CheckBox pijama;
private CheckBox luva;
private CheckBox prope;
String Cpf;

    final Fragment fragment1 = new EpiFinalFragment();
    final Fragment fragment2 = new MateriaPrimaFragment();
    final Fragment fragment3 = new BiotecnologiaFragment();
    Fragment active = fragment1;
    final FragmentManager fm = getSupportFragmentManager();



    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main6);
        mascara = (CheckBox) findViewById(R.id.plastico);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
 //BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
       // bottomNavigationView.setOnNavigationItemSelectedListener(navListener);





        fm.beginTransaction().add(R.id.fragment_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.fragment_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.fragment_container,fragment1, "1").commit();
      //  grupo = (androidx.constraintlayout.widget.Group) findViewById(R.id.group);
       // grupo2 = (androidx.constraintlayout.widget.Group) findViewById(R.id.group3);
      //  grupo3 = (androidx.constraintlayout.widget.Group) findViewById(R.id.group4);
        Intent intentRecebedora = getIntent();
        Bundle parametros = intentRecebedora.getExtras();

        if(parametros!=null){
            String id = parametros.getString("chave_id");

            //Toast.makeText(MainActivity7.this, "razao social: "+ id+"nome fantasia"+nome, Toast.LENGTH_LONG).show();
            Cpf = id;


        }

       viewModel = new ViewModelProvider(this).get(ItemViewModel.class);





    }
 /*   public static EpiFinalFragment newInstance() {
        EpiFinalFragment f = new EpiFinalFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putString("cpf", cpf);
        f.setArguments(args);
        return f;
    }*/
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ItemViewModel.Produto it = viewModel.getProduto().getValue();

            switch (item.getItemId()) {
                case R.id.epiFinal:
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;


                    return true;

                case R.id.materiaPrima:
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2;
                    return true;

                case R.id.biotecnologia2:
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;
                    return true;


            }

            return false;
        }
    };

    /*private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;
                    switch(item.getItemId()){
                        case R.id.epiFinal:



                            selectedFragment = new EpiFinalFragment();



                            break;
                        case R.id.materiaPrima:

                            selectedFragment = new MateriaPrimaFragment();

                            break;
                        case R.id.biotecnologia2:

                            selectedFragment = new BiotecnologiaFragment();


                            break;
                    }

                    //(selectedFragment);
                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };
*/



/*private void switchFragments(Fragment fragment){
    Fragment.SavedState savedState = getSupportFragmentManager().saveFragmentInstanceState(fragment);
    if(savedState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

    }else{
        fragment.setInitialSavedState(savedState);
    }

}*/











    public void voltarTela7(View view){
        Intent intent7 = new Intent(getApplicationContext(), MainActivity7.class);
        startActivity(intent7);
    }
    public String GetCpf(){
        return Cpf;
    }
    public void irTela8(View view){
      ItemViewModel.Produto it = viewModel.getProduto().getValue();


        ItemViewModel.Produto y = viewModel.getProduto().getValue();
        Pessoa p =new Pessoa();
        p.setCpf(Cpf);


      /*  FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("cadastro");
        Pessoa q =new Pessoa();
        myRef.child(p.getCpf()).child("produz").setValue(it);
*/
        Intent intent7 = new Intent(getApplicationContext(), MainActivity8.class);

        Bundle parametros = new Bundle();
        parametros.putString("chave_id", Cpf);

        parametros.putBoolean("mascara", it.mascara);
        parametros.putString("mascaraDesc", it.mascaraDesc);
        parametros.putBoolean("oculos", it.oculos);
        parametros.putBoolean("pijama", it.pijama);
        parametros.putBoolean("sapato", it.sapato);
        parametros.putBoolean("alcool", it.alcoolEmGel);
        parametros.putBoolean("faceShield", it.faceShield);
        parametros.putBoolean("luva", it.luva);
        parametros.putBoolean("prope", it.prope);
        parametros.putBoolean("capote", it.capote);
        parametros.putBoolean("touca", it.touca);
        parametros.putBoolean("avental", it.avental);
        parametros.putBoolean("macacao", it.macacao);
        parametros.putBoolean("tecido",it.tecido);
        parametros.putBoolean("plastico",it.plastico);
        parametros.putBoolean("elastico",it.elastico);
        parametros.putBoolean("borracha",it.borracha);
        parametros.putBoolean("nanoPrata",it.nanoprata);



        intent7.putExtras(parametros);
        startActivity(intent7);
    }


    public void mostrarEpiFinal(View view){

               grupo.setVisibility(View.VISIBLE);
               grupo2.setVisibility(View.INVISIBLE);
               grupo3.setVisibility(View.INVISIBLE);
    }
    public void mostrarMateriaPrima(View view){
        grupo.setVisibility(View.INVISIBLE);
        grupo2.setVisibility(View.VISIBLE);
        grupo3.setVisibility(View.INVISIBLE);
    }

    public void mostrarBiotec(View view){
        grupo.setVisibility(View.INVISIBLE);
        grupo2.setVisibility(View.INVISIBLE);
        grupo3.setVisibility(View.VISIBLE);
    }

}