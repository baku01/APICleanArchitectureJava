package com.api.clean.apicleanarchjava.gateway.alunos;

import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExcecaoAoEnviarEmailAluno;

public interface AlunoGatewayEnviarEmail {
    void EnviarEmailPara(Aluno alunoIndicado) throws ExcecaoAoEnviarEmailAluno;
}
