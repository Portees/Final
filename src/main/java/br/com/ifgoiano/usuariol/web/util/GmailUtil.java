package br.com.ifgoiano.usuariol.web.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import javax.mail.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.ifgoiano.usuariol.util.UtilException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GmailUtil {
	
    public void enviarEmail(String de, String para, String assunto, String mensagem) throws UtilException {
		 Properties prop = new Properties();
                 String password = "WEB2201902";
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(de, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(de));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(para)
            );
            message.setSubject(assunto);
            message.setText(mensagem);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        }
}

