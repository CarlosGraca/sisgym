/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Horario;
import persistence.DAOHorario;
import persistence.DAOModalidade;
import table.ModeloTabelaHorario;
import static view.VModalidade.jTHorario;
import static view.VModalidade.jsHorario_fim;
import static view.VModalidade.jsHorario_inicio;

public class ControllerHorario {

    Horario horarioModel;
    DAOHorario horarioDao;
    DAOModalidade modalDao;
    ControllerModalidade contModal;
    ModeloTabelaHorario modeloTabelaHorario;
    

    public ControllerHorario() {
        horarioModel = new Horario();
        horarioDao = new DAOHorario();
        modalDao = new DAOModalidade();
        contModal = new ControllerModalidade();
        //horarioDao.executeSQL();
    }

    public boolean manutencaoHorario(String acao, int idHorario, int idModalidade, int diaSemana, Timestamp horaInicio, Timestamp horaFim) throws Exception {
        horarioModel.setModalidade(idModalidade);
        horarioModel.setHoraInicio(horaInicio);
        horarioModel.setHoraFim(horaFim);
        horarioModel.setDiasemana(diaSemana);
        horarioModel.setIdHorario(idHorario);

        try {
            switch (acao) {
                case "inserir":
                    if (horarioDao.incluir(horarioModel)) {
                        JOptionPane.showMessageDialog(null, "Registo Horario salvo com sucesso");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "editar":
                    if (horarioDao.editar(horarioModel)) {
                        JOptionPane.showMessageDialog(null, "Horario Alterado com sucesso");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel alterar o registro!");
                    }
                    break;
                case "excluir":
                    if (horarioDao.excluir(horarioModel)) {
                        JOptionPane.showMessageDialog(null, "Registo removido com sucesso");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Preencher tabela horario
    public void preencherJTabelaHorario(String modalidade) {

        horarioDao.getTodosHorarioModalidade(modalidade);
        try {
            modeloTabelaHorario = new ModeloTabelaHorario(horarioDao.resultSet);
            jTHorario.setModel(modeloTabelaHorario);
            jTHorario.removeColumn(jTHorario.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel " + ex);
        }
    }

    //Prencher a data inicio e fim.
    public void prencherDadosHorario(String codigoLinha) {
        try {
            horarioDao.getHorario(codigoLinha);
            
            horarioDao.resultSet.next();
            jsHorario_inicio.setDate(horarioDao.resultSet.getTime(4));
            jsHorario_fim.setDate(horarioDao.resultSet.getTime(5));
        } catch (SQLException ex) {
            Logger.getLogger(ControllerHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Preencher Tabela Horario por Semana
    public void preencherJTabelaHorarioSemana(String semana) {
        horarioDao.getTodosHorarioSemana(semana);
        try {
            modeloTabelaHorario = new ModeloTabelaHorario(horarioDao.resultSet);
            jTHorario.setModel(modeloTabelaHorario);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel " + ex);
        }
    }
}
