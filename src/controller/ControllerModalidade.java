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
import model.Diasemana;
import model.Modalidade;
import persistence.DAOModalidade;
import table.ModeloTabelaModalidade;
import static view.VModalidade.jTabMod;
import static view.VModalidade.jtMod_cod;
import static view.VModalidade.jtMod_nome;
import static view.VModalidade.jtMod_valor;
import static view.VModalidade.jtModalidade;

public class ControllerModalidade {

    Modalidade modalModel;
    DAOModalidade modalDao;
    String codigoLinha;
    ModeloTabelaModalidade modeloTabelaModalidade;
    Diasemana modalDiasemana;

    public ControllerModalidade() {
        modalModel = new Modalidade();
        modalDao = new DAOModalidade();
        modalDiasemana = new Diasemana();
    }

    public boolean manutencaoModalidade(String acao, String codigo, String nome, String valor) {
        if (!codigo.equals("")) {
            modalModel.setIdModalidade(Integer.parseInt(codigo));
        }
        modalModel.setValor(Double.parseDouble(valor));
        modalModel.setNome(nome);
        try {
            switch (acao) {
                case "inserir":
                    if (modalDao.incluir(modalModel)) {
                        JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        modalDao.getTodosModalidade();
                        preencherJTabelaModalidade();
                        jTabMod.setSelectedIndex(0);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterar":
                    if (modalDao.editar(modalModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        modalDao.getTodosModalidade();
                        preencherJTabelaModalidade();
                        jTabMod.setSelectedIndex(0);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
                case "excluir":
                    String nomeMod = "Apagar modalidade " + jtMod_nome.getText() + " ?";
                    int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeMod, "Confirmacão Exclusão ", JOptionPane.YES_OPTION);
                    if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                        if (modalDao.excluir(modalModel)) {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");
                            modalDao.getTodosModalidade();
                            preencherJTabelaModalidade();
                            jTabMod.setSelectedIndex(0);
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");

                        }
                    }
                    break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

//    private JTextField[] camposModalidade() {
//        JTextField[] textField = {jtMod_cod, jtMod_valor, jtMod_nome};
//        return textField;
//    }
    public void manutencaoPesquisa() {
        modalDao.getModalidades();
        codigoLinha = (String) modeloTabelaModalidade.getValueAt(jtModalidade.getSelectedRow(), 0);
        try {
            modalDao.executeSQL(codigoLinha);
            modalDao.resultSet.next();
            jtMod_cod.setText(modalDao.resultSet.getString(1));
            jtMod_valor.setText(modalDao.resultSet.getString(2));
            jtMod_nome.setText(modalDao.resultSet.getString(3));

        } catch (SQLException erro) {
        }
    }

    public void preencherJTabelaModalidade() {
        modalDao.getModalidades();
        try {
            modeloTabelaModalidade = new ModeloTabelaModalidade(modalDao.resultSet);
            jtModalidade.setModel(modeloTabelaModalidade);
            jtModalidade.removeColumn(jtModalidade.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela Modalidade " + ex);
        }
    }

    public ResultSet getUltimoRegistro() {
        modalDao.getTodosModalidade();
        return modalDao.getUtimoRegistro();
    }

    public int getDiaSemanaCodigo(String semana) {
        modalDao.codigoDiaSemana(semana);
        try {
            modalDao.resultSet.next();
            return Integer.parseInt(modalDao.resultSet.getString(1));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return 0;

    }

    //Pesquisa Modalidade
    public void pesquisaModalidade(String pesq, String acao) {
        try {
            switch (acao) {
                case "Codigo":
                    modalDao.pesquisarModalidade("SELECT idModalidade, nome, valor FROM modalidade WHERE idModalidade LIKE '%" + pesq + "%'");
                    break;
                case "Nome":
                    modalDao.pesquisarModalidade("SELECT idModalidade, nome, valor FROM modalidade WHERE upper(nome) LIKE upper('%" + pesq + "%')");
                    break;
            }

            modeloTabelaModalidade = new ModeloTabelaModalidade(modalDao.resultSet);
            jtModalidade.setModel(modeloTabelaModalidade);
            jtModalidade.removeColumn(jtModalidade.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerModalidade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
