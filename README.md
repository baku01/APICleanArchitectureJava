# API Clean Architecture em Java 🚀

## Visão Geral

Este projeto implementa uma arquitetura limpa para gerenciar alunos em uma API baseada em Java. Siga as instruções abaixo para adicionar um banco de dados funcional ao seu projeto.

## Entidades Principais

### Aluno (Aluno.java)

A classe `Aluno` representa um aluno no sistema. Ela possui atributos como CPF, nome, email, senha e uma lista de telefones. Além disso, inclui métodos para adicionar telefones e acessar informações como CPF, senha, nome, email e lista de telefones.

```java
package com.api.clean.apicleanarchjava.core.entity.alunos;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private CPF cpf;
    private String nome;
    private Email email;

    private String senha;
    private List<Telefone> telefones = new ArrayList<>();

    public Aluno(CPF cpf, String nome, Email email, String senha){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public void AdicionarTelefone(String ddd, String numero){
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCPF() {
        return cpf.getNumero();
    }

    public String getSenha(){
        return senha;
    }

    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email.getEndereco();
    }
    public List<Telefone>getTelefones(){
        return  telefones;
    }
}

```

## Interfaces de Gateway

### AlunoGateway (AlunoGateway.java)

A interface `AlunoGateway` define os métodos que devem ser implementados por classes que lidam com a persistência de alunos, como matrícula, busca e login.

```java
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

```

## Infraestrutura

### CadastrarAluno (CadastrarAluno.java)

A classe `CadastrarAluno` é um controlador que recebe dados para matricular um aluno através da API. Para implementar um banco de dados funcional, siga os passos abaixo:

### Banco de Dados

1. Escolha um sistema de gerenciamento de banco de dados (por exemplo, MySQL, PostgreSQL).
2. Configure a dependência do banco de dados no seu projeto (use Maven ou Gradle).
3. Implemente uma classe de repositório para interagir com o banco de dados, por exemplo, `AlunoRepository`.
4. Atualize a classe `CadastrarAluno` para utilizar `AlunoRepository` para persistência.

```java
// Exemplo: CadastrarAluno atualizado com AlunoRepository
@RestController
@RequestMapping("/api/alunos/")
public class CadastrarAluno {

    private final AlunoRepository alunoRepository;

    public CadastrarAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping("/cadastrar")
    public String MatricularAlunoWEB(@RequestBody MatricularAlunoDto dados) throws ExcecaoDBAluno {
        Aluno novoAluno = dados.CriarAluno();
        alunoRepository.save(novoAluno); // Utilizando o repositório para salvar no banco de dados
        return "Aluno criado com sucesso!";
    }
}
```
## Todo: Implementação de Banco de Dados

Para adicionar persistência de dados ao projeto e torná-lo completamente funcional, siga os passos abaixo para integrar um banco de dados:

1. **Escolha um Sistema de Gerenciamento de Banco de Dados (SGBD):**
    - Escolha um SGBD como MySQL, PostgreSQL, ou outro de sua preferência.

2. **Configure a Dependência do Banco de Dados:**
    - Adicione a dependência do SGBD escolhido ao arquivo de configuração do seu projeto (utilize Maven ou Gradle).

3. **Implemente a Classe de Repositório:**
    - Crie uma classe de repositório, por exemplo, `AlunoRepository`, para interagir com o banco de dados. Utilize o JPA ou outra tecnologia de persistência.

4. **Atualize a Classe `CadastrarAluno`:**
    - Modifique a classe `CadastrarAluno` para utilizar `AlunoRepository` para a persistência dos dados. Atualize o método `MatricularAlunoWEB` para salvar o aluno no banco de dados.

```java
// Exemplo: CadastrarAluno atualizado com AlunoRepository
@RestController
@RequestMapping("/api/alunos/")
public class CadastrarAluno {

    private final AlunoRepository alunoRepository; // Substitua AlunoRepository pelo nome correto

    public CadastrarAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping("/cadastrar")
    public String MatricularAlunoWEB(@RequestBody MatricularAlunoDto dados) throws ExcecaoDBAluno {
        Aluno novoAluno = dados.CriarAluno();
        alunoRepository.save(novoAluno); // Utilizando o repositório para salvar no banco de dados
        return "Aluno criado com sucesso!";
    }
}
```
Lembre-se de configurar corretamente as propriedades do banco de dados no arquivo de configuração do seu projeto.



