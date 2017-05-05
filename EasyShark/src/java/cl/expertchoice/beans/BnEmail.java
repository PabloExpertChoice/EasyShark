/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.expertchoice.beans;

import cl.expertchoice.mail.ConfeccionMail;
import cl.expertchoice.mail.Config_mail;
import cl.expertchoice.mail.MailUtil;
import cl.expertchoice.soporte.DEF;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import javax.mail.MessagingException;
import soporte.D;

/**
 *
 * @author jhonncard
 */
public class BnEmail {

    public static void main(String[] args) {
//        sendMailConfirmacionRegistro("jmmora2004@gmail.com");
    }

    public  void sendMailConfirmacionRegistro(String Correo, String codigo) {
        try {

            ConfeccionMail cx = new ConfeccionMail();
            
            String msgBody = "";
            msgBody += "<p style='font-family: Calibri;'>Se ha registrado la empresa.</p>";
            msgBody += "<p>Ingrese al siguiente link para completar el proceso.<br />";
            msgBody += "<a style='color: rgb(224,142,11);' href='http://" + D.DOMINIO + "/Svl_Password?key=" + codigo + "'>Cambiar contraseña</a></p>";
            
            String mail = cx.getMail(msgBody);
            boolean sendEmail;
            sendEmail = MailUtil.sendEmailT(Correo, "Registro de Empresa", mail, Config_mail.MAIL_USER_INFO, Config_mail.MAIL_PASS_INFO);

        } catch (IOException ex) {
            DEF.log().log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            DEF.log().log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            DEF.log().log(Level.SEVERE, null, ex);
        }
    }
    //correo para usuario comun
    public  void sendMailUsuarioComun(String Correo, String clave) {
        try {

            ConfeccionMail cx = new ConfeccionMail();
            
            String msgBody = "";
            msgBody += "<p style='font-family: Calibri;'>Usuario Registrado .</p>";
            msgBody += "<p>su contraseña temporal es la siguiente.<br />";
            msgBody += "<p>"+clave+"<br />";
            msgBody += "<p>Puede cambiarla cuando quiera .<br />";
            String mail = cx.getMail(msgBody);
            boolean sendEmail;
            sendEmail = MailUtil.sendEmailT(Correo, "Registro de Usuario", mail, Config_mail.MAIL_USER_INFO, Config_mail.MAIL_PASS_INFO);

        } catch (IOException ex) {
            DEF.log().log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            DEF.log().log(Level.SEVERE, null, ex);
        } catch (GeneralSecurityException ex) {
            DEF.log().log(Level.SEVERE, null, ex);
        }
    }
}
