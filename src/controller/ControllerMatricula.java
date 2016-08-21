/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Matricula;
import model.Modalidade;
import persistence.DAOMatricula;
import persistence.DAOModalidade;
import table.ModeloTabelaCliente;

public class ControllerMatricula {

    Matricula matModel;
    DAOMatricula matDao;
    Modalidade modalModel;
    String codigoLinha;
    ModeloTabelaCliente modeloTabelaCliente;
    DAOModalidade modalDao;
    private double  total = 0.0;

    public ControllerMatricula() {
        matModel = new Matricula();
        matDao = new DAOMatricula();
        modalModel = new Modalidade();
        modalDao = new DAOModalidade();
        //cliDao.getTodosCliente();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    

    public boolean manutencaoMatricula(String acao, int idMatricula, int idCliente, Date data, int idFuncinario, Double valor){
        matModel.setPessoa(idCliente);
        matModel.setMatData(data);
        matModel.setUtilizador(idFuncinario);
        matModel.setValorTotal(valor);
        matModel.setIdMatricula(idMatricula);
        try {
            switch (acao) {
                case "matricular":
                    if (matDao.incluirMatriculaInicial(matModel)) {
                        //JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        //JOptionPane.showMessageDialog(null, "Registo matricula salvo com sucesso");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterarMatricula":
                    if (matDao.editarMatricula(matModel)) {
                        //JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;               
//                case "excluir":
//                    String nomeCliente = "Apagar o cliente " + jtCli_nome.getText() + " ?";
//                    int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeCliente, "Confirmacão Exclusão ", JOptionPane.YES_OPTION);
//                    if (opcaoEscolhida == JOptionPane.YES_OPTION) {
//                        if (cliDao.excluir(cliModel)) {
//                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");
//                            cliDao.getTodosCliente();
//                            preencherJTabelaCliente();
//                            jTabCli.setSelectedIndex(0);
//                            return true;
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");
//                        }
//                    }
                    //break;
            }
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Manutenção de matricula: "+ ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: Manutenção de matricula: "+ ex);
        }
        return false;
    }
//
//    public void pesquisaModalidade() {
//        modalDao.executeSQLModalidadeNome(jcModalidade.getSelectedItem().toString());
//        DefaultTableModel model = (DefaultTableModel) jtModalidadeCliente.getModel();
//        if (jcModalidade.getSelectedIndex() != 0) {
//            try {
//                modalDao.resultSet.next();
//                model.addRow(new Object[]{modalDao.resultSet.getString(3),modalDao.resultSet.getString(2)});
//                total = total + Double.valueOf(modalDao.resultSet.getString(2));
//                VCliente.jtCli_totalApagar.setText(String.valueOf(total));
//            } catch (SQLException ex) {
//                Logger.getLogger(ControllerMatricula.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Selecione pelo menos uma modalidade");
//        }
//    }
//
//    public void selectModalidade() {
//        try {
//            modalModel = cliDao.pesquisar(jcModalidade);
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
//        }
//    }
//
//    public void selectClienteToComo() {
//        try {
//            cliModel = cliDao.pesquisarClienteComo(jcCliente);
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
//        }
//    }
//
//    public void selectClienteToComo2() {
//        try {
//            cliModel = cliDao.pesquisarClienteComo(jcbPag_nome);
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
//        }
//    }
//
//    public void manutencaoPesquisa() throws IOException {
//        codigoLinha = (String) modeloTabelaCliente.getValueAt(jTabCliente.getSelectedRow(), 0);
//
//        try {
//            cliDao.executeSQL(codigoLinha);
//            cliDao.resultSet.next();
//            jtCli_cod.setText(cliDao.resultSet.getString(1));
//            jtCli_nome.setText(cliDao.resultSet.getString(2));
//            jdCli_dtNasc.setDate(cliDao.resultSet.getDate(3));
//            jcCli_sexo.setSelectedIndex(cliDao.resultSet.getInt(4));
//            jtCli_bi.setText(cliDao.resultSet.getString(5));
//            jtCli_email.setText(cliDao.resultSet.getString(7));
//            jtCli_morada.setText(cliDao.resultSet.getString(8));
//            jtCli_cp.setText(cliDao.resultSet.getString(9));
//            jtCli_telm.setText(cliDao.resultSet.getString(10));
//            jtCli_prof.setText(cliDao.resultSet.getString(12));
//            jtCli_locTrab.setText(cliDao.resultSet.getString(13));
//            jtCli_telTrab.setText(cliDao.resultSet.getString(14));
//            jtCli_edu.setText(cliDao.resultSet.getString(15));
//            jtaCli_obs.setText(cliDao.resultSet.getString(16));
//            jcCli_status.setSelectedIndex(cliDao.resultSet.getInt(18));
//            jdCli_dtReg.setDate(cliDao.resultSet.getDate(21));
//
//            BufferedImage img = ImageIO.read(new ByteArrayInputStream(cliDao.resultSet.getBytes(19)));
//
//            int type = img.getType();
//            if (type == 0) {
//                type = 5;
//            } else {
//                type = type;
//            }  //se o tipo for 0, corrige para 5  
//
//            //Converte o tamanho da imagem e mostra no jLabel  
//            BufferedImage aux = new BufferedImage(130, 150, type);//cria um buffer auxiliar com o tamanho desejado    
//            Graphics2D g = aux.createGraphics();//pega a classe graphics do aux para edicao    
//            AffineTransform at = AffineTransform.getScaleInstance((double) 130 / img.getWidth(), (double) 150 / img.getHeight());//cria a transformacao    
//            g.drawRenderedImage(img, at);//pinta e transforma a imagem real no auxiliar    
//            jlFoto.setIcon(new ImageIcon(aux));
//
//        } catch (SQLException erro) {
//        }
//    }
//
//    public void preencherJTabelaCliente() {
//        cliDao.getTodosCliente();
//        try {
//            modeloTabelaCliente = new ModeloTabelaCliente(cliDao.resultSet);
//            jTabCliente.setModel(modeloTabelaCliente);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela " + ex);
//        }
//    }
//
    public ResultSet getUltimoRegistroMatricula() {
        matDao.getTodosMatricula();
        return matDao.getUtimoRegistroMatricula();
    }
//
//    public void pesquisaCliente() {
//        // JOptionPane.showMessageDialog(null, jcPesquisar.getSelectedItem().toString());
//        String campo = jcPesquisar.getSelectedItem().toString();
//        String pesquisa = String.valueOf(jtPesquisar.getText());
//        if (((pesquisa.length() != 0) && campo.equals("Codigo")) || campo.equals("Nome")) {
//            try {
//                cliDao.pesquisaPersonalizadoClientes(pesquisa, campo);
//                modeloTabelaCliente = new ModeloTabelaCliente(cliDao.resultSet);
//                jTabCliente.setModel(modeloTabelaCliente);
//            } catch (SQLException ex) {
//                Logger.getLogger(ControllerMatricula.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
