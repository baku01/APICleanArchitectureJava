package com.api.clean.apicleanarchjava.infra.alunos.controller;

import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExcecaoDBAluno;
import com.api.clean.apicleanarchjava.gateway.alunos.AlunoGateway;
import com.api.clean.apicleanarchjava.infra.alunos.dto.MatricularAlunoDto;
import com.api.clean.apicleanarchjava.infra.alunos.repository.AlunoRepositoryJDBC;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alunos/")
public class CadastrarAluno {

    private final AlunoGateway alunoGateway;
    public CadastrarAluno(AlunoGateway alunoGateway) {
        this.alunoGateway = alunoGateway;
    }

    @PostMapping("/cadastrar")
    public String MatricularAlunoWEB(@RequestBody MatricularAlunoDto dados) throws ExcecaoDBAluno {
        Aluno novoAluno = dados.CriarAluno();
        alunoGateway.FazerMatricula(novoAluno);
        return "Aluno criado com sucesso!";

    }

}
