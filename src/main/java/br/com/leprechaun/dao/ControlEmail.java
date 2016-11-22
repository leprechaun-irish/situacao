package br.com.leprechaun.dao;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class ControlEmail {

    private String mailSMTPServer;
    private String mailSMTPServerPort;
    private String mailSenha;

    public void sendMail(String remetente, String destinatario, String assunto, String mensagem) {

        Properties props = new Properties();

        mailSMTPServer = "smtp.gmail.com";
        mailSMTPServerPort = "587";
        mailSenha = "melhorequipe";

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", mailSMTPServer);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.user", remetente);
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", mailSMTPServerPort);
        props.put("mail.smtp.sockerFactory.port", mailSMTPServerPort);
        props.put("mail.smtp.sockerFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.sockerFactory.fallback", "false");

        SimpleAuth auth = new SimpleAuth(remetente, mailSenha);

        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(true);

        Message msg = new MimeMessage(session);

        try {
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

            msg.setFrom(new InternetAddress(remetente));

            msg.setSubject(assunto);

            //msg.setContent("SENAI", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            msg.setText(mensagem);

        } catch (Exception e) {
            System.err.println(">>Erro ao enviar mensagem!\n" + e);
        }

        Transport tr;
        try {
            tr = session.getTransport("smtp");
            tr.connect(mailSMTPServer, remetente, mailSenha);

            msg.saveChanges();
            tr.sendMessage(msg, msg.getAllRecipients());

            tr.close();

        } catch (Exception e) {
            System.err.println(">>Erro ao enviar mensagem!\n" + e);
        }
    }
}

class SimpleAuth extends Authenticator {

    public String username = null;
    public String password = null;

    public SimpleAuth(String user, String pwd) {
        username = user;
        password = pwd;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
