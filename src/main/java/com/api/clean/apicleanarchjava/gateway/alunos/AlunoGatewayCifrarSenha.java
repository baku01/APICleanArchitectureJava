package com.api.clean.apicleanarchjava.gateway.alunos;

import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExecaoAoCifrarSenhaAluno;

public interface AlunoGatewayCifrarSenha {
    String CifradorDeSenha(String senha) throws ExecaoAoCifrarSenhaAluno;
    boolean ValidarSenhaCifrada(String senhaCifrada, String senhaTextoClaro) throws ExecaoAoCifrarSenhaAluno;
}
