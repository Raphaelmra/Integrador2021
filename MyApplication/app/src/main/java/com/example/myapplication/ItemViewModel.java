package com.example.myapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    public class Produto {

        public String nomE;
        public String descricaO;
        public boolean oculos;
        public String oculosDesc;
        public boolean pijama;
        public String pijamaDesc;
        public boolean mascara;
        public String mascaraDesc;
        public boolean luva;
        public String luvaDesc;
        public boolean sapato;
        public String sapatoDesc;
        public boolean alcoolEmGel;
        public String alcoolEmGelDesc;
        public boolean faceShield;
        public String faceShieldDesc;
        public boolean prope;
        public String propeDesc;
        public boolean capote;
        public String capoteDesc;
        public boolean touca;
        public String toucaDesc;
        public boolean avental;
        public String aventalDesc;
        public boolean macacao;
        public String macacaoDesc;


        public boolean nanoprata;

        public boolean tecido;
        public boolean plastico;
        public boolean borracha;
        public boolean elastico;

    }

    @Override
    public String toString() {
        return produto.getValue().nomE;
    }
    public ItemViewModel(){
        produto.setValue(new Produto());
    }

    private MutableLiveData<Produto> produto = new MutableLiveData<Produto>();

    public LiveData<Produto> getProduto(){
        return produto;
    }
}
