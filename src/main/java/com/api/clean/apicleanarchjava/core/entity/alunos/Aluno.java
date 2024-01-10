package com.api.clean.apicleanarchjava.core.entity.alunos;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private CPF cpf;
    private String nome;
    private Email email;

    private String senha;
    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(CPF cpf, String nome, Email email, String senha){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public void AdicionarTelefone(String ddd, String numero){
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCPF() {
        return cpf.getNumero();
    }

    public String getSenha(){
        return senha;
    }

    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email.getEndereco();
    }
    public List<Telefone>getTelefones(){
        return  telefones;
    }
}
