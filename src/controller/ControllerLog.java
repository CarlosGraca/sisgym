package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Acessosistema;
import persistence.DAOLog;
import table.ModeloTabelaLog;
import static view.VLog.jtLog;

public class ControllerLog {

    Acessosistema logModel;
    DAOLog logDao;

    String codigoLinha;
    ModeloTabelaLog modeloTabelaLog;

    public ControllerLog() {
        logDao = new DAOLog();
        logModel = new Acessosistema();
//        pagDao.getTodosCliente();
    }

    public boolean manutencaoLog(String acao, int login, String hora, String tipo, Date data) {
        try {

            logModel.setHoraEntrada(hora);
            logModel.setLogin(login);
            logModel.setAcao(tipo);
            logModel.setData(data);
            switch (acao) {
                case "inserir":
                    if (logDao.incluir(logModel)) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                /*case "excluir":
                 String nomeAPagamento = "Cancelar o pagamento " + jcbPag_desc.getSelectedItem() + " ?";
                 int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeAPagamento, "Confirmacão Cancelamento ", JOptionPane.YES_OPTION);
                 if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                 if (logDao.excluir(logModel)){
                 JOptionPane.showMessageDialog(null, "Registo cancelado com sucesso");
                 preencherJTabelaPagamento();
                 jTabPane_pagamento.setSelectedIndex(0);
                 return true;
                 } else {
                 JOptionPane.showMessageDialog(null, "Erro no cancelamento do pagamento");    
                 }
                 }
                 break;*/
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void preencherJTabelaLog() {
        Calendar dtVencimento = Calendar.getInstance();
        java.util.Date vencimento = dtVencimento.getTime();
        logDao.getTodosLog(new java.sql.Date(vencimento.getTime()));
        try {

            modeloTabelaLog = new ModeloTabelaLog(logDao.resultSet);
            jtLog.setModel(modeloTabelaLog);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela: " + ex);
        }
    }

    public String getDataEntradaSistema() {

        logDao.pegarData();
        try {
            logDao.resultSet.next();
            return logDao.resultSet.getString(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    public String diaValidadeSistema() {

        logDao.pegarDias();
        try {
            logDao.resultSet.next();
            return logDao.resultSet.getString(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

}
