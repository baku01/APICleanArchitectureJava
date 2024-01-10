package com.api.clean.apicleanarchjava.infra.alunos.services;

import com.api.clean.apicleanarchjava.core.entity.alunos.Aluno;
import com.api.clean.apicleanarchjava.core.exceptions.alunos.ExcecaoAoEnviarEmailAluno;
import com.api.clean.apicleanarchjava.gateway.alunos.AlunoGatewayEnviarEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AlunoEnviarEmailPara implements AlunoGatewayEnviarEmail {

    public void EnviarEmailPara(Aluno alunoIndicado) throws ExcecaoAoEnviarEmailAluno {
        // Configurações do servidor de e-mail
        String host = "smtp.seuhost.com";
        String usuario = "seu_usuario";
        String senha = "sua_senha";
        int porta = 587;

        // Configurações adicionais, se necessário
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", porta);

        // Criação da sessão
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, senha);
            }
        });

        try {
            // Criação da mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(alunoIndicado.getEmail()));
            message.setSubject("Assunto do E-mail");
            message.setText("Conteúdo do E-mail");

            // Envio do e-mail
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso para: " + alunoIndicado.getEmail());

        } catch (MessagingException excecaoAoEnviarEmailAluno) {
            throw new ExcecaoAoEnviarEmailAluno("Erro ao enviar e-mail: " + excecaoAoEnviarEmailAluno.getMessage());
        }
    }
}


