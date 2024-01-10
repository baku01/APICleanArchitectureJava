package com.api.clean.apicleanarchjava.infra.alunos.repository;

import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.entity.alunos.CPF;
import com.api.clean.apicleanarchjava.core.entity.alunos.Telefone;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExcecaoDBAluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExececaoDeLoginAluno;
import com.api.clean.apicleanarchjava.gateway.alunos.AlunoGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//O repository é responsavél por dar forma aos metodos definidos pela interface ( ou gateway )
//No setindo de Arquitetura Limpa instanciamos a variavel de conexão sem definir qual serviço vamos utlizar, isso flexibiliza a implementação
//O ponto chave é ABSTRAÇÃO

public class AlunoRepositoryJDBC implements AlunoGateway {

    private final Connection connection;

    public AlunoRepositoryJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void FazerMatricula(Aluno aluno) throws ExcecaoDBAluno {
        try{
            String ExecSQL = "INSERT INTO ALUNO VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(ExecSQL);
            preparedStatement.setString(1,aluno.getCPF());
            preparedStatement.setString(2,aluno.getNome());
            preparedStatement.setString(3,aluno.getEmail());
            preparedStatement.execute();

            ExecSQL = "INSERT INTO TELEFONE VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(ExecSQL);
            for(Telefone telefone: aluno.getTelefones()){
                preparedStatement.setString(1, telefone.getDdd());
                preparedStatement.setString(2,telefone.getNumero());
                preparedStatement.execute();
            }

        } catch (SQLException excecaoDBAluno){
            throw new ExcecaoDBAluno("Erro ao Inserir Aluno no Banco de dados, favor contatar suporte!!!");
        }

    }

    @Override
    public String FazerLogin(Aluno aluno) throws ExececaoDeLoginAluno {
        return null;
    }

    @Override
    public Aluno BuscarAlunoPorCPF(CPF cpf) throws ExcecaoDBAluno {
        try {
            String ExecBuscaCPF = "SELECT * FROM ALUNO WHERE CPF =?";
            PreparedStatement preparedStatement = connection.prepareStatement(ExecBuscaCPF);
            preparedStatement.setString(1,cpf.getNumero());
            preparedStatement.execute();
        } catch (SQLException excecaoDBAluno) {
            throw new ExcecaoDBAluno("Erro ao Buscar CPF, favor contatar suporte!!!");
        }
    return null;
    }

    @Override
    public List<Aluno> ListarTodosAlunosMatriculados(Aluno aluno) throws ExcecaoDBAluno {
        try {
            String ExecBuscaTodosAlunos = "SELECT * FROM ALUNOS";
            PreparedStatement preparedStatement = connection.prepareStatement(ExecBuscaTodosAlunos);
            preparedStatement.execute();
        } catch (SQLException excecaoDBInserirAluno) {
            throw new ExcecaoDBAluno("Erro Ao buscar todos alunos, favor contatar suporte!!!");
        }
        return null;
    }
}
