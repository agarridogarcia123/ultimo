/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package email;

import stockw.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;   
/**
 *
 * @author Araceli, Marta
 */
public class EnviaEmail {
      String miCorreo;
        String miContraseña;
        String servidorSMTP = "smtp.gmail.com";
        String puertoEnvio = "465";
        String mailReceptor;
        String asunto;
        String cuerpo;
        
        public EnviaEmail(String miCorreo, String miContraseña, String mailReceptor, String asunto, String cuerpo) {
            this.miCorreo = miCorreo;
            this.miContraseña = miContraseña;
            this.mailReceptor = mailReceptor;
            this.asunto = asunto;
            this.cuerpo = cuerpo;
            Properties props = new Properties();
            props.put("mail.smtp.user", this.miCorreo);//correo origen
            props.put("mail.smtp.host", servidorSMTP);//tipo de servidor
            props.put("mail.smtp.port", puertoEnvio);//puesto de salida
            props.put("mail.smtp.starttls.enable", "true");//inicializar o servidor
            props.put("mail.smtp.auth", "true");//autentificacion
            props.put("mail.smtp.socketFactory.port", puertoEnvio);//activar o puerto
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            SecurityManager security = System.getSecurityManager();
            try {
                   Authenticator auth = new autentificadorSMTP();//autentificar o correo
            Session session = Session.getInstance(props, auth);//iniciamos sesion
           

            MimeMessage msg = new MimeMessage(session);//estructura do correo
            msg.setText(cuerpo);//corpo da mensaxe
            msg.setSubject(asunto);//asunto
            msg.addHeaderLine("Muchas gracias por confiar en STOCK WAREHOUSE");
            msg.setFrom(new InternetAddress(miCorreo));//agrega a propiedade do correo origen
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    mailReceptor));//agrega  destinatario
            Transport.send(msg);//envia mensaxe
             JOptionPane.showMessageDialog(null, "Email enviado");
                
              
            } catch (Exception mex) {
                JOptionPane.showMessageDialog(null, "Email no enviado");
            }
        }
        private class autentificadorSMTP extends javax.mail.Authenticator {
          
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(miCorreo, miContraseña);//autentifica correo e contrasinal
            }
        }
}
