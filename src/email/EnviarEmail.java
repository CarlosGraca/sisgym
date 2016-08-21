package email;

import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class EnviarEmail {
     public static String usuer;
     public static String port;
     public static String smtp;
     public static String seh;
     public void EnviaEmail(String destinario, String assunto, String mensagem, String caminho) throws IOException {
       
        
        final String usuario = usuer;
        //JOptionPane.showMessageDialog(null, usuer);
        final String usuariodestino = destinario;
        final String senha = seh;
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", smtp);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(usuario, senha);
                    }
                });
        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario)); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(usuariodestino);
            message.setRecipients(Message.RecipientType.TO, toUser);

            //mensagem que vai no corpo do email
            MimeBodyPart mbpMensagem = new MimeBodyPart();
            mbpMensagem.setText(mensagem);

            //partes do email
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbpMensagem);

            // String fileToSend = System.getProperty("user.dir") + "/src/email" + "/" + "test.txt"; 
            String endereco = caminho;
            if (caminho != null) {

                MimeBodyPart mbpAnexo = new MimeBodyPart();
                FileDataSource imgFds = new FileDataSource(endereco);
                mbpAnexo.setDataHandler(new DataHandler(imgFds));
                mbpAnexo.setFileName(imgFds.getName());

                mbpAnexo.setDataHandler(new DataHandler(imgFds));
//            //imagem que sera enviada em anexo, ta no mesmo diretorio da classe.
//            String imagem = "test.txt";
//            InputStream is = getClass().getResourceAsStream(imagem);
//
//            //setando o anexo
//            System.out.println("Tes" + caminho);
//            MimeBodyPart mbpAnexo = new MimeBodyPart();
//            mbpAnexo.setDataHandler(new DataHandler(new ByteArrayDataSource(is, "application/image")));
                // mbpAnexo.setFileName(imagem);
                mp.addBodyPart(mbpAnexo);
            }
            //assunto do email
            message.setSubject(assunto);//Assunto

            //seleciona o conteudo
            message.setContent(mp);

            //envia o email
            Transport.send(message);

            JOptionPane.showMessageDialog(null, "Mensagem enviado com sucesso!");

        } catch (MessagingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
