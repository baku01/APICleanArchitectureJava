package com.api.clean.apicleanarchjava.core.entity.alunos;

public class Telefone  {


    private final String ddd;
    private final String numero;

    public Telefone(String ddd, String numero) {
        if (ddd == null || numero == null) {
            throw new IllegalArgumentException("DDD e Número são obrigadtorios!!");
        }

        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("DDD invalido!");
        }
        if (!numero.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Número invalido!");
        }

        this.ddd = ddd;
        this.numero = numero;
        }

    public String getDdd() {
        return ddd;
    }

    public String getNumero(){
        return numero;

    }
}
