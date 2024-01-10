package com.api.clean.apicleanarchjava.core;

import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.entity.alunos.CPF;
import com.api.clean.apicleanarchjava.core.entity.alunos.Email;

public class FabricaAluno {

    private Aluno aluno;
    public FabricaAluno comNomeCPFEmail(String nome, String cpf, String email,String senha){
        this.aluno = new Aluno(new CPF(cpf),
                nome,
                new Email(email),
                senha);
            return this;
    }
    public FabricaAluno AdicionarTelefone(String ddd, String numero){
        this.aluno.AdicionarTelefone(ddd,numero);
            return this;
    }
}
