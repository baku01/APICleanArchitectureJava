package com.api.clean.apicleanarchjava.infra.alunos.services;

import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExecaoAoCifrarSenhaAluno;
import com.api.clean.apicleanarchjava.gateway.alunos.AlunoGatewayCifrarSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AlunoCifradorDeSenhaMD5 implements AlunoGatewayCifrarSenha {
    @Override
    public String CifradorDeSenha(String senha) throws ExecaoAoCifrarSenhaAluno {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes [i] & 0xff) + 0x100));}
            return sb.toString();
        } catch (NoSuchAlgorithmException execaoAoCifrarSenhaAluno) {
            throw new ExecaoAoCifrarSenhaAluno("erro ao gerar hash da senha");
        }
    }

    @Override
    public boolean ValidarSenhaCifrada(String senhaCifrada, String senhaTextoClaro) throws ExecaoAoCifrarSenhaAluno {
        return senhaCifrada.equals(CifradorDeSenha(senhaTextoClaro)) ;
    }
}
