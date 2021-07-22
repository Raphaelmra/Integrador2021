package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.Nullable;

public class BiotecnologiaFragment extends Fragment {
    ItemViewModel viewModel;



    @Override
    @Nullable


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_biotecnologia, container,false);

        CheckBox nanoprata=(CheckBox)rootView.findViewById(R.id.nano);


        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        ItemViewModel.Produto p = viewModel.getProduto().getValue();

        nanoprata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nanoprata.isChecked()){
                    p.nanoprata = true;
                } }
        });



        return rootView;
    }


    public static MateriaPrimaFragment newInstance() {
        return new MateriaPrimaFragment();
    }
}

