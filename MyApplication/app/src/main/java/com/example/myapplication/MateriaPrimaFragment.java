package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class MateriaPrimaFragment extends Fragment {
    ItemViewModel viewModel;


    @Override
    @Nullable

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_materia_prima, container,false);

        CheckBox plastico=(CheckBox)rootView.findViewById(R.id.plastico);
        CheckBox tecido=(CheckBox)rootView.findViewById(R.id.tecido);
        CheckBox borracha=(CheckBox)rootView.findViewById(R.id.borracha);
        CheckBox elastico=(CheckBox)rootView.findViewById(R.id.elastico);

        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        ItemViewModel.Produto p = viewModel.getProduto().getValue();

        plastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(plastico.isChecked()){
                    p.plastico = true;
                } }
        });

        tecido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecido.isChecked()){
                    p.tecido = true;
                } }
        });
        borracha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(borracha.isChecked()){
                    p.borracha = true;
                } }
        });

        elastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(elastico.isChecked()){
                    p.elastico = true;
                } }
        });

        return rootView;

    }

    public static MateriaPrimaFragment newInstance() {
        return new MateriaPrimaFragment();
    }

}
