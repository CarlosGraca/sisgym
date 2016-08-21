/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import email.EnviarEmail;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ServidorEmail;
import persistence.DAOEmail;
import static view.VEmail.jpCE_Senha;
import static view.VEmail.jtCE_Email;
import static view.VEmail.jtCE_serverPorta;
import static view.VEmail.jtCE_serverSMTP;
import static view.VEmail.jtaCE_assinatura;

public class ControllerEmail {

    ServidorEmail servModel;
    DAOEmail serviDao;

    public ControllerEmail() {
        servModel = new ServidorEmail();
        serviDao = new DAOEmail();
        serviDao.executeSQL();
    }

    public boolean manutencaoEmail(String acao, String smpt, String porta, String email, String senha, String assinatura) {
        servModel.setSerSmtp(smpt);
        servModel.setSerPorta(Integer.parseInt(porta));
        servModel.setSerEmail(email);
        servModel.setSerSenha(senha);
        servModel.setSerAssinatura(assinatura);
        try {
            switch (acao) {
                case "inserir":
                    if (serviDao.incluir(servModel)) {
                        JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        serviDao.executeSQL();
                        manutencaoPesquisa();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterar":
                    if (serviDao.editar(servModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        serviDao.executeSQL();
                        manutencaoPesquisa();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void manutencaoPesquisa() throws IOException {
        try {
            serviDao.executeSQL();
            serviDao.resultSet.next();
            jtCE_serverSMTP.setText(serviDao.resultSet.getString(2));
            jtCE_serverPorta.setText(serviDao.resultSet.getString(3));
            jtCE_Email.setText(serviDao.resultSet.getString(4));
            jpCE_Senha.setText(serviDao.resultSet.getString(5));
            jtaCE_assinatura.setText(serviDao.resultSet.getString(6));

        } catch (SQLException erro) {
        }
    }

    public void manutencaoDadosToEmail() throws IOException {
        try {
            serviDao.executeSQL();
            serviDao.resultSet.next();
            EnviarEmail.smtp = serviDao.resultSet.getString(2);
            EnviarEmail.port = serviDao.resultSet.getString(3);
            EnviarEmail.usuer = serviDao.resultSet.getString(4);
            EnviarEmail.seh = serviDao.resultSet.getString(5);
//            jtaCE_assinatura.setText(serviDao.resultSet.getString(6));

        } catch (SQLException erro) {
        }
    }

}
