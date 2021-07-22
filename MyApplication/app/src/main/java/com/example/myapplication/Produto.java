package com.example.myapplication;

import android.widget.ListView;

import com.google.android.gms.common.internal.Objects;

public class Produto {

    public String nome;
    public String descricao;
    private String Mascara;
    private ListView MascaraProdutores;
    private String PijamaHospitalar;
    private String PijamaHospitalarProdutores;
    private String OculosDeProtecao;
    private String Sapato;
    private String AlcoolEmGel;
    private String Faceshield;
    private String Luva;
    private String Prope;
    private String Capote;
    private String Touca;
    private String Avental;
    private String Macacao;

    private String Tecido;
    private String Elastico;

    private String Nanoprata;
    private String Plastico;
    private String Borracha;

    @Override
    public String toString() {
        return nome;
    }

    public String getMascara() {
        return Mascara;
    }

    public void setMascara(String mascara) {
        Mascara = mascara;
    }

    public String getPijamaHospitalar() {
        return PijamaHospitalar;
    }

    public void setPijamaHospitalar(String pijamaHospitalar) {
        PijamaHospitalar = pijamaHospitalar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        nome = Nome;
    }


    public String getOculosDeProtecao() {
        return OculosDeProtecao;
    }

    public void setOculosDeProtecao(String oculosDeProtecao) {
        OculosDeProtecao = oculosDeProtecao;
    }

    public String getSapato() {
        return Sapato;
    }

    public void setSapato(String sapato) {
        Sapato = sapato;
    }

    public String getAlcoolEmGel() {
        return AlcoolEmGel;
    }

    public void setAlcoolEmGel(String alcoolEmGel) {
        AlcoolEmGel = alcoolEmGel;
    }

    public String getFaceshield() {
        return Faceshield;
    }

    public void setFaceshield(String faceshield) {
        Faceshield = faceshield;
    }

    public String getLuva() {
        return Luva;
    }

    public void setLuva(String luva) {
        Luva = luva;
    }

    public String getPrope() {
        return Prope;
    }

    public void setPrope(String prope) {
        Prope = prope;
    }

    public String getCapote() {
        return Capote;
    }

    public void setCapote(String capote) {
        Capote = capote;
    }

    public String getTouca() {
        return Touca;
    }

    public void setTouca(String touca) {
        Touca = touca;
    }

    public String getAvental() {
        return Avental;
    }

    public void setAvental(String avental) {
        Avental = avental;
    }

    public String getMacacao() {
        return Macacao;
    }

    public void setMacacao(String macacao) {
        Macacao = macacao;
    }

    public String getPlastico() {
        return Plastico;
    }

    public void setPlastico(String plastico) {
        Plastico = plastico;
    }

    public String getBorracha() {
        return Borracha;
    }

    public void setBorracha(String borracha) {
        Borracha = borracha;
    }

    public String getTecido() {
        return Tecido;
    }

    public void setTecido(String tecido) {
        Tecido = tecido;
    }

    public String getElastico() {
        return Elastico;
    }

    public void setElastico(String elastico) {
        Elastico = elastico;
    }

    public String getNanoprata() {
        return Nanoprata;
    }

    public void setNanoprata(String nanoprata) {
        Nanoprata = nanoprata;
    }


}
