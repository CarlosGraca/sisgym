/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Recibos;
import persistence.DAORecibo;

/**
 *
 * @author Carlos
 */
public class ControllerRecibo {
    Recibos recModel;
    DAORecibo recDao;

    public ControllerRecibo() {
        recModel = new Recibos();
        recDao = new DAORecibo();
    }
    public boolean manutencaoRecibo(String acao, String doc, String numDoc, String desc, String sit, boolean est, int idCli, int idUser) {
        recModel.setDocumento(doc);
        recModel.setNumDoc(numDoc);
        recModel.setDescricao(desc);
        recModel.setSituacao(sit);
        recModel.setEstado(est);
        recModel.setIdCliente(idCli);
        recModel.setIdUser(idUser);
        try {
            switch (acao) {
                case "inserir":
                    if (recDao.incluir(recModel)) {
                        //JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterar":
                    if (recDao.editar(recModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Manutencao CLiente: "+ex.getMessage());
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Error Manutencao CLiente: "+ex.getMessage());
        }
        return false;
    }

}
