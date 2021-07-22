package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EpiFinalFragment extends Fragment {
    ItemViewModel viewModel;
    private Spinner epiFinal;
    private EditText Descricao;
    private Button botao;
    private String cpf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_epi_final, container,false);

/*
        Bundle args = getArguments();
        String id = args.getString("cpf");
        cpf =id;*/

        cpf = ((MainActivity6) getActivity()).GetCpf();
        FirebaseDatabase db = FirebaseDatabase.getInstance();



        DatabaseReference produtos = db.getReference("produtos");



    /*    CheckBox mascara=(CheckBox)rootView.findViewById(R.id.plastico);
        CheckBox oculos=(CheckBox)rootView.findViewById(R.id.tecido);
        CheckBox pijama=(CheckBox)rootView.findViewById(R.id.borracha);
        CheckBox sapato=(CheckBox)rootView.findViewById(R.id.elastico);
        CheckBox alcool=(CheckBox)rootView.findViewById(R.id.alcool);
        CheckBox faceShield=(CheckBox)rootView.findViewById(R.id.faceShield);
        CheckBox luva=(CheckBox)rootView.findViewById(R.id.luva);
        CheckBox prope=(CheckBox)rootView.findViewById(R.id.prope);
        CheckBox capote=(CheckBox)rootView.findViewById(R.id.capote);
        CheckBox touca=(CheckBox)rootView.findViewById(R.id.touca);
        CheckBox avental=(CheckBox)rootView.findViewById(R.id.avental);
        CheckBox macacao=(CheckBox)rootView.findViewById(R.id.macacao);*/
        epiFinal = (Spinner) rootView.findViewById(R.id.DropBoxFinal);
        Descricao = (EditText) rootView.findViewById(R.id.desc);
        botao = (Button) rootView.findViewById(R.id.add);
        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        ItemViewModel.Produto p = viewModel.getProduto().getValue();
        Spinner dropdownEpiFinal =rootView.findViewById(R.id.DropBoxFinal);
        //create a list of items for the spinner.
        String[] Epis = new String[]{"EpiFinal",
                "Mascara",
                "Oculos",
                "Pijama",
                "Sapato",
                "Alcool",
                "FaceShield",
                "Luva",
                "Prope",
                "Capote",
                "Touca",
                "Avental",
                "Macacao"
        };
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapterRedeSocial = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, Epis);
//set the spinners adapter to the previously created one.
        dropdownEpiFinal.setAdapter(adapterRedeSocial);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posicao;
                String dropdown = dropdownEpiFinal.getSelectedItem().toString();
                String descricao = Descricao.getText().toString();
                if(dropdown =="Mascara"){


                    People c = new People();
                    //produtos.child("mascara").child(cpf).setValue(true);
                   // produtos.child("mascara").child(cpf).child("descrição").setValue(descricao);
                    c.setNome("mascara");
                    c.setDescricao(descricao);
                    c.setCpf(cpf);
                    produtos.child("Mascara").child(c.getCpf()).setValue(c);
                  //  produtos.child(c.getCpf()).setValue(c);

                    //produtos.child("mascara").child(cpf).setValue(c);
                 //   produtos.child("mascara").child(cpf).child("descrição").setValue(descricao);
                    //p.mascaraDesc = descricao;

                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";

                }

                if(dropdown =="Oculos"){
                    People d = new People();

                    d.setNome("oculos de proteção");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Oculos").child(d.getCpf()).setValue(d);


                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Pijama"){
                    People d = new People();

                    d.setNome("Pijama Hospitalar");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Pijama").child(d.getCpf()).setValue(d);


                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Sapato"){
                    People d = new People();

                    d.setNome("Sapato");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Sapato").child(d.getCpf()).setValue(d);


                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Alcool"){
                    People d = new People();

                    d.setNome("Alcool em Gel");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Alcool em gel").child(d.getCpf()).setValue(d);
                   // produtos.child(d.getCpf()).setValue(d);



                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="FaceShield"){
                    People d = new People();

                    d.setNome("Faceshield");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Faceshield").child(d.getCpf()).setValue(d);
                   // produtos.child(d.getCpf()).setValue(d);


                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Luva"){
                    People d = new People();

                    d.setNome("Luva");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Luva").child(d.getCpf()).setValue(d);
                  //  produtos.child(d.getCpf()).setValue(d);



                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Prope"){
                    People d = new People();

                    d.setNome("Prope");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Prope").child(d.getCpf()).setValue(d);
                    //produtos.child(d.getCpf()).setValue(d);



                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Capote"){
                    People d = new People();

                    d.setNome("Capote");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Capote").child(d.getCpf()).setValue(d);
                    //produtos.child(d.getCpf()).setValue(d);



                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Touca"){
                    People d = new People();

                    d.setNome("Touca");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Touca").child(d.getCpf()).setValue(d);
                    //produtos.child(d.getCpf()).setValue(d);



                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Avental"){
                    People d = new People();

                    d.setNome("Avental");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Avental").child(d.getCpf()).setValue(d);
                    //produtos.child(d.getCpf()).setValue(d);



                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
                if(dropdown =="Macacao"){
                    People d = new People();

                    d.setNome("Macacao");
                    d.setDescricao(descricao);
                    d.setCpf(cpf);
                    produtos.child("Macacao").child(d.getCpf()).setValue(d);
                   // produtos.child(d.getCpf()).setValue(d);



                    posicao = dropdownEpiFinal.getSelectedItemPosition();
                    Epis[posicao] ="";
                }
            }
        });
        /*mascara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mascara.isChecked()){
                    p.mascara = true;
                } }
                });

    oculos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(oculos.isChecked()){
                p.oculos = true;
            } }
    });
    pijama.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(pijama.isChecked()){
                p.pijama = true;
            } }
    });

    sapato.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(sapato.isChecked()){
                p.sapato = true;
            } }
    });

    alcool.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(alcool.isChecked()){
                p.alcoolEmGel = true;
            } }
    });

    faceShield.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(faceShield.isChecked()){
                p.faceShield = true;
            } }
    });

    luva.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(luva.isChecked()){
                p.luva = true;
            } }
    });
    prope.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(prope.isChecked()){
                p.prope = true;
            } }
    });
    capote.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(capote.isChecked()){
                p.capote = true;
            } }
    });

    touca.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(touca.isChecked()){
                p.touca = true;
            } }
    });
    avental.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(avental.isChecked()){
                p.avental = true;
            } }
    });

    macacao.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(macacao.isChecked()){
                p.macacao = true;
            } }
    });*/



        return rootView;
    }


    public static MateriaPrimaFragment newInstance() {


        return new MateriaPrimaFragment();
    }



}
