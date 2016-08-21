/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ParamIva;
import persistence.DAOIva;
import static view.VJDialogRecebimento.jTextFieldIva;

public class ControllerIva {

    ParamIva ivaModel;
    DAOIva ivaDao;

    public ControllerIva() {
        ivaModel = new ParamIva();
        ivaDao = new DAOIva();
        ivaDao.executeSQL();
    }

    public boolean manutencaoIva(String acao, double valor_iva, double iva) throws IOException {
        ivaModel.setValorIva(valor_iva);
        ivaModel.setIva(iva);
        try {
            switch (acao) {               
                case "alterarIva":
                    if (ivaDao.editar(ivaModel)) {
//                       // JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        ivaDao.executeSQL();
                        manutencaoPesquisa();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro na alteração do iva :"+ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração do iva :"+ex.getMessage());
        } 
        return false;
    }
    public void manutencaoPesquisa() throws IOException {
        try {
            ivaDao.executeSQL();
            ivaDao.resultSet.next();
            jTextFieldIva.setText(ivaDao.resultSet.getString(2));
        } catch (SQLException erro) {
        }
    }

}
