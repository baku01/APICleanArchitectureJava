package com.api.clean.apicleanarchjava.config;

import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.entity.alunos.CPF;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExcecaoDBAluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExecaoDeBuscaAluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExececaoDeLoginAluno;
import com.api.clean.apicleanarchjava.gateway.alunos.AlunoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public AlunoGateway alunoGateway(){
        return new AlunoGateway() {
            @Override
            public void FazerMatricula(Aluno aluno) throws ExcecaoDBAluno {

            }

            @Override
            public String FazerLogin(Aluno aluno) throws ExececaoDeLoginAluno {
                return null;
            }

            @Override
            public Aluno BuscarAlunoPorCPF(CPF cpf) throws ExcecaoDBAluno, ExecaoDeBuscaAluno {
                return null;
            }

            @Override
            public List<Aluno> ListarTodosAlunosMatriculados(Aluno aluno) throws ExcecaoDBAluno, ExecaoDeBuscaAluno {
                return null;
            }
        };
    }
}
