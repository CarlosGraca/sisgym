/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Equipamento;
import persistence.DAOEquipamento;
import table.ModeloTabelaEquipamento;
import static view.VEquipamento.jTabEqui;
import static view.VEquipamento.jtEqui_cod;
import static view.VEquipamento.jtEqui_nome;
import static view.VEquipamento.jtEquipamentos;

public class ControllerEquipamento {

    Equipamento equipModel;
    DAOEquipamento equipDao;
    String ordenacao = "nome";
    ModeloTabelaEquipamento modeloTabelaEquipamento;

    public ControllerEquipamento() {
        equipModel = new Equipamento();
        equipDao = new DAOEquipamento();
        equipDao.getTodosEquipamentos();
//        equipDao.getListaEquipamentos(ordenacao);
    }

    public boolean manutencaoEquipamento(String acao, String codigo, String nome, String marca, String codEquipamento) {
        if (!codigo.equals("")) {
            equipModel.setIdEquipamento(Integer.parseInt(codigo));
        }
        equipModel.setCodEquipamento(codEquipamento);
        equipModel.setNome(nome);
        equipModel.setMarca(marca);
        try {
            switch (acao) {
                case "inserir":
                    if (equipDao.incluir(equipModel)) {
                        JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        equipDao.getTodosEquipamentos();
                        preencherJtableEquipamento();
                        jTabEqui.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterar":
                    if (equipDao.editar(equipModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        equipDao.getTodosEquipamentos();
                        preencherJtableEquipamento();
                        jTabEqui.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
                case "excluir":
                    String nomeEqui = "Apagar equipamento " + jtEqui_nome.getText() + " ?";
                    int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeEqui, "Confirmacão Exclusão ", JOptionPane.YES_OPTION);
                    if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                        equipModel.setIdEquipamento(Integer.parseInt(jtEqui_cod.getText()));
                        if (equipDao.excluir(equipModel)) {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");
                            equipDao.getTodosEquipamentos();
                            preencherJtableEquipamento();
                            jTabEqui.setSelectedIndex(0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");

                        }
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public ResultSet getPrimeiroRegistro() {
        return equipDao.getPrimeiroRegistro();
    }

    public ResultSet getUltimoRegistro() {
        return equipDao.getUtimoRegistro();
    }

    public void preencherJtableEquipamento() {
        
        equipDao.getTodosEquipamentos();
        try {
            modeloTabelaEquipamento = new ModeloTabelaEquipamento(equipDao.resultSet);
            jtEquipamentos.setModel(modeloTabelaEquipamento);
            jtEquipamentos.removeColumn(jtEquipamentos.getColumnModel().getColumn(0));
            jtEquipamentos.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel " + ex);
        }
        
//        try {
//            DefaultTableModel defaulTableModel;
//            JTable jtTabelEquip = new JTable();
//            jtTabelEquip.setModel(new DefaultTableModel(new Object[][]{
//                null, null},
//                    new String[]{"Codigo", "Nome", "Marca", "CodEquipamento"}
//            ));
//            jtTabelEquip.getColumnModel().getColumn(0).setPreferredWidth(10);
//            jtTabelEquip.getColumnModel().getColumn(1).setPreferredWidth(50);
//            jtTabelEquip.getColumnModel().getColumn(2).setPreferredWidth(20);
//            jtTabelEquip.getColumnModel().getColumn(3).setPreferredWidth(20);
//
//            defaulTableModel = (DefaultTableModel) jtTabelEquip.getModel();
//            defaulTableModel.setNumRows(0);
//            equipDao.resultSet.beforeFirst();
//            while (equipDao.resultSet.next()) {
//                defaulTableModel.addRow(new Object[]{
//                    equipDao.resultSet.getString("idEquipamento"),
//                    equipDao.resultSet.getString("nome"),
//                    equipDao.resultSet.getString("marca"),
//                    equipDao.resultSet.getString("codEquipamento")});
//            }
//            equipDao.resultSet.first();
//            return defaulTableModel;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao preencher no JTable" + ex.getMessage());
//        }
//        return null;
    }
    
     
    //Pesquisa de Equipamento
    public void pesquisaEquipamento(String acao, String pesq) {
        try{
        switch (acao) {
            case "Codigo":
                equipDao.pesquisarEquipamento("SELECT * FROM equipamento WHERE idEquipamento LIKE '%" + pesq + "%'");
                break;
            case "Nome":
                equipDao.pesquisarEquipamento("SELECT * FROM equipamento WHERE nome LIKE '%" + pesq + "%'");
                break;
            case "Marca":
                equipDao.pesquisarEquipamento("SELECT * FROM equipamento WHERE marca LIKE '%" + pesq + "%'");
                break;
        }
        
        modeloTabelaEquipamento = new ModeloTabelaEquipamento(equipDao.resultSet);
        jtEquipamentos.setModel(modeloTabelaEquipamento);
        jtEquipamentos.removeColumn(jtEquipamentos.getColumnModel().getColumn(0));
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel " + ex);
        }
    }
    
}
