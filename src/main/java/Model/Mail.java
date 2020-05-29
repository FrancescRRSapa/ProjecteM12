/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ferna
 */
public class Mail {
    private final Properties props;
    public Mail() {
        props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        props.put("from", "s.fernandez@sapalomera.cat");
        props.put("username", "s.fernandez@sapalomera.cat");
        props.put("password", "12kalamar34");
    }

    public void enviar(String to, String subject, String content, String rutaArchivo) throws MessagingException {
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
                }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(props.getProperty("from")));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        //message.setText(content);
        BodyPart texto = new MimeBodyPart();
        texto.setText(content);
        BodyPart adjunto = new MimeBodyPart();
        
        adjunto.setDataHandler(new DataHandler(new FileDataSource(rutaArchivo)));
        adjunto.setFileName("Manual de uso del Practice Test - Con entorno.pdf");
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        multiParte.addBodyPart(adjunto);
        message.setContent(multiParte);
        Transport.send(message);

        System.out.println("mensaje enviado!");
    }
    /*
    public static void main(String[] args) throws MessagingException, ClassNotFoundException {
        Mail m = new Mail();
        m.enviar("s.fernandez@sapalomera.cat", "Hola! Soy un mensaje!", "ejemplo de email enviado con Jakarta Mail", ".\\src\\main\\java\\Fitxers\\Manual de uso del Practice Test - Con entorno.pdf");
    }
    */
}