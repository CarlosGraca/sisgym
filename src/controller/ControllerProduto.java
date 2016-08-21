/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Produto;
import persistence.DAOProduto;
import table.ModeloTabelaProduto;
import static view.VProduto.jTabProd;
import static view.VProduto.jdProd_data;
import static view.VProduto.jtProd_CodBarra;
import static view.VProduto.jtProd_Quant;
import static view.VProduto.jtProd_cod;
import static view.VProduto.jtProd_nome;
import static view.VProduto.jtProd_valor;
import static view.VProduto.jtProdutos;

public class ControllerProduto {

    DAOProduto prodDao;
    Produto prodModel;
    ModeloTabelaProduto modeloTabelaProduto;
    String codigoLinha;

    public ControllerProduto() {
        prodModel = new Produto();
        prodDao = new DAOProduto();
        //prodDao.executeSQL();
    }

    public boolean manutencaoProduto(String acao, String codigo, String nome, String preco, Date data, String quantidade, String codBarra, int CodFunc) {
        if (!codigo.equals("")) {
            prodModel.setIdProduto(Integer.parseInt(codigo));
        }
        prodModel.setPreco(Float.parseFloat(preco));
        prodModel.setNome(nome);
        prodModel.setData(data);
        prodModel.setQuantidade(Integer.parseInt(quantidade));
        prodModel.setCodBarra(codBarra);
        prodModel.setCodFunc(CodFunc);
        try {
            switch (acao) {
                case "inserir":
                    if (prodDao.incluir(prodModel)) {
                        JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        prodDao.executeSQL();
                        jTabProd.setSelectedIndex(0);
                        preencherJTabelaProduto();
                        // manutencaoPesquisa();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterar":
                    if (prodDao.editar(prodModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        prodDao.executeSQL();
                        jTabProd.setSelectedIndex(0);
                        preencherJTabelaProduto();
//                        manutencaoPesquisa();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
                case "excluir":
                    String nomeFunc = "Apagar o produto " + jtProd_nome.getText() + " ?";
                    int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeFunc, "Confirmacão Exclusão ", JOptionPane.YES_OPTION);
                    if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                        if (prodDao.excluir(prodModel)) {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");
                            prodDao.executeSQL();
                            jTabProd.setSelectedIndex(0);
                            preencherJTabelaProduto();
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o registro!");

                        }
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void manutencaoPesquisa() throws IOException {
        try {
            codigoLinha = (String) modeloTabelaProduto.getValueAt(jtProdutos.getSelectedRow(), 0);

            prodDao.executeSQLCodigoLinha(codigoLinha);
            prodDao.resultSet.next();
            jtProd_cod.setText(prodDao.resultSet.getString(1));
            jtProd_nome.setText(prodDao.resultSet.getString(2));
            jtProd_valor.setText(prodDao.resultSet.getString(3));
            jtProd_Quant.setText(prodDao.resultSet.getString(4));
            jtProd_CodBarra.setText(prodDao.resultSet.getString(6));
            jdProd_data.setDate(prodDao.resultSet.getDate(5));

        } catch (SQLException erro) {
        }
    }

    public void preencherJTabelaProduto() {
        prodDao.executeSQL();
        try {
            modeloTabelaProduto = new ModeloTabelaProduto(prodDao.resultSet);
            jtProdutos.setModel(modeloTabelaProduto);
            jtProdutos.removeColumn(jtProdutos.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela produto" + ex);
        }
    }

    //Pesquisa de Equipamento
    public void pesquisaProduto(String acao, String pesq) {
        try {
            switch (acao) {
                case "Codigo":
                    prodDao.pesquisarProduto("SELECT * FROM produto WHERE idProduto LIKE '%" + pesq + "%'");
                    break;
                case "Nome":
                    prodDao.pesquisarProduto("SELECT * FROM produto WHERE nome LIKE '%" + pesq + "%'");
                    break;
            }
            modeloTabelaProduto = new ModeloTabelaProduto(prodDao.resultSet);
            jtProdutos.setModel(modeloTabelaProduto);
            jtProdutos.removeColumn(jtProdutos.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel " + ex);
        }
    }

}
