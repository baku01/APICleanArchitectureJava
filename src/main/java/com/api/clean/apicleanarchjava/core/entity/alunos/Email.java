package com.api.clean.apicleanarchjava.core.entity.alunos;

public class Email {

    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b"))
            throw new IllegalArgumentException("Email inválido");

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}