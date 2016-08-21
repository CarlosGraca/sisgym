package controller;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.xml.transform.TransformerException;
import model.MConexao;
import persistence.Conexao;

public class ControllerConexao {

    MConexao conModel;
    Conexao con;

    public ControllerConexao() {
        conModel = new MConexao();
        con = new Conexao();
    }

    public boolean manutencaoConexao(String acao,String nomeBanco, String pass, String driver, String driverManager, String baseDados, String msg) {
        conModel.setDriver(driver);
        conModel.setDriverManager(driverManager);
        conModel.setBaseDados(baseDados);
        conModel.setMensagem(msg);
        conModel.setNomeBanco(nomeBanco);
        conModel.setPass(pass);
        try {
            switch (acao) {
                case "inserir":
                    if (con.ModifyXMLFile(conModel)) {
                        JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        //conDao.executeSQL();
                        con.preencherCampos();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;                
            }
        } catch (TransformerException | HeadlessException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao pesquisar dados conexao: "+ex);
        }
        return false;
    }

//    public void manutencaoPesquisa() throws IOException {
//        try {
//            conDao.executeSQL();
//            conDao.resultSet.next();
//            VJDialogConexao.id = conDao.resultSet.getString(1);
//            jTextFieldDriver.setText(conDao.resultSet.getString(2));
//            jTextFieldDrivermanager.setText(conDao.resultSet.getString(3));
//            jTextFieldBaseDados.setText(conDao.resultSet.getString(4));
//            jTextFieldMsg.setText(conDao.resultSet.getString(5));
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro ao ler dados conexao: "+erro);
//        }
//    }
//
//    public void manutencaoDadosToConexao() throws IOException {
//        try {
//            conDao.executeSQL();
//            conDao.resultSet.next();
//            VJDialogConexao.id = conDao.resultSet.getString(1);
//            Conexao.driverConexion = conDao.resultSet.getString(2);
//            Conexao.driverManagerConexion = conDao.resultSet.getString(3);
//            Conexao.baseDadosConexion = conDao.resultSet.getString(4);
//            Conexao.msgConexion = conDao.resultSet.getString(5);
//
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro ao passar dados conexao: "+erro);
//        }
//    }

}
