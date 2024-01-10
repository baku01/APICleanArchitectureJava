package com.api.clean.apicleanarchjava.core.entity.alunos;

import java.time.LocalDateTime;

public class Indicacao {
    private Aluno AlunoIndicado;
    private Aluno AlunoIndicante;
    private LocalDateTime DataIndicacao;

    public Indicacao(Aluno AlunoIndicado, Aluno AlunoIndicante){
        this.AlunoIndicado = AlunoIndicado;
        this.AlunoIndicante = AlunoIndicante;
        this.DataIndicacao = LocalDateTime.now();
    }
}
