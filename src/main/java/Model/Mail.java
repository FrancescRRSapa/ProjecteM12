/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.ConfiguracioDAO;
import DAO.UsuarisDAO;
import java.sql.SQLException;
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
 * @author Sergio Fernández s.fernandez@sapalomera.cat
 * @author Francesc Roca f.roca@sapalomera.cat
 * @version 1.0 01/06/2020
 */
public class Mail {
    /**
     * Envia mail per els codis
     * @param from
     * @param to
     * @param content
     * @param password
     * @throws MessagingException 
     */
    public static void enviarCodis(String from ,String to, String content, String password) throws MessagingException {
        final Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        props.put("from", from);
        props.put("username", from);
        props.put("password", password);
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
                }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(props.getProperty("from")));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Codis");
        MimeBodyPart texto = new MimeBodyPart();
        texto.setContent(content, "text/html");
        BodyPart adjunto = new MimeBodyPart();
        
        //adjunto.setDataHandler(new DataHandler(new FileDataSource(".\\src\\main\\java\\Fitxers\\Manual de uso del Practice Test - Con entorno.pdf")));
        //adjunto.setFileName("Manual de uso del Practice Test - Con entorno.pdf");
        MimeMultipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(texto);
        //multiParte.addBodyPart(adjunto);
        message.setContent(multiParte);
        Transport.send(message);

        //System.out.println("mensaje enviado!");
    }

    public static void main(String[] args) throws MessagingException, ClassNotFoundException, SQLException, Exception {
        Usuari u = UsuarisDAO.buscar(1);
        Configuracio c = ConfiguracioDAO.llistar();
        Mail.enviarCodis(c.getDireccioCorreu() ,u.getCorreu(), c.getCorreuEnviaCodis(), c.getContrasenyaCorreu());
    }
}