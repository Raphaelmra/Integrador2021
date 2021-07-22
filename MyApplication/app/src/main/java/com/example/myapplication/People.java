package com.example.myapplication;

public class People {


    private String nome;
    private String descricao;
    private String cpf;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String email) {
        this.descricao = email;
    }

    @Override
    public String toString() {
        return nome + " " + descricao;
    }
}
