package com.api.clean.apicleanarchjava.gateway.alunos;

import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.entity.alunos.CPF;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExcecaoDBAluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExecaoDeBuscaAluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExececaoDeLoginAluno;

import java.util.List;

// A interface diz quais métodos ou funções podem ser implementados pelas entidades
public interface AlunoGateway {
    void FazerMatricula(Aluno aluno) throws ExcecaoDBAluno;
    String FazerLogin(Aluno aluno) throws ExececaoDeLoginAluno;
    Aluno BuscarAlunoPorCPF(CPF cpf) throws ExcecaoDBAluno, ExecaoDeBuscaAluno;
    List<Aluno> ListarTodosAlunosMatriculados(Aluno aluno) throws ExcecaoDBAluno, ExecaoDeBuscaAluno;
}
