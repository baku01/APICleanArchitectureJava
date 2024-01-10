package com.api.clean.apicleanarchjava.infra.alunos.dto;


import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.entity.alunos.CPF;
import com.api.clean.apicleanarchjava.core.entity.alunos.Email;
import jakarta.persistence.*;

//Vou intrgrar o dto a uma persistencia para teste
@Entity
@Table(name = "Alunos")
public class MatricularAlunoDto {

    @Id
    private String cpfAluno;
    @Column(nullable = false)
    private  String nomeAluno;
    @Column(nullable = false)
    private String senhaAluno;
    @Column(nullable = false)
    private String emailAluno;

    public Aluno CriarAluno(){
        return new Aluno(new CPF("123.123.123-12"), "Pedro Correa Siqueira", new Email("pedro@pedro.com.br"), "123");

    }
}


