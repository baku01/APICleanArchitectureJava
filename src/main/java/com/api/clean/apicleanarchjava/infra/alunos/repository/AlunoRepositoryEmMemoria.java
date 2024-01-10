package com.api.clean.apicleanarchjava.infra.alunos.repository;

import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.entity.alunos.CPF;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExcecaoDBAluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExecaoDeBuscaAluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExececaoDeLoginAluno;
import com.api.clean.apicleanarchjava.gateway.alunos.AlunoGateway;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryEmMemoria implements AlunoGateway {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void FazerMatricula(Aluno aluno) throws ExcecaoDBAluno {
        this.matriculados.add(aluno);
    }
    @Override
    public String FazerLogin(Aluno aluno) throws ExececaoDeLoginAluno {
        return null;
    }

    @Override
    public Aluno BuscarAlunoPorCPF(CPF cpf) throws ExecaoDeBuscaAluno {
        return this.matriculados.stream()
                .filter(a -> a.getCPF().equals(a.getCPF()))
                .findFirst()
                .orElseThrow(() -> new ExecaoDeBuscaAluno("Erro ao Buscar CPF, nada encontrado!"));
    }

    @Override
    public List<Aluno> ListarTodosAlunosMatriculados(Aluno aluno) throws ExcecaoDBAluno {
        return null;
    }
}
