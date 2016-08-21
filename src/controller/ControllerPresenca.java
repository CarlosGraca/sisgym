package controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Acessogym;
import persistence.DAOPresenca;
import table.ModeloTabelaLog;
import table.ModeloTabelaPresenca;
import static view.VPresenca.jtPresenca;

public class ControllerPresenca {

    Acessogym gymModel;
    DAOPresenca gymDao;

    String codigoLinha;
    ModeloTabelaPresenca modeloTabelaPresenca;

    String hora;

    public ControllerPresenca() {
        gymDao = new DAOPresenca();
        gymModel = new Acessogym();
    }

    public void preencherJTabelaPresenca() {
        Calendar dtVencimento = Calendar.getInstance();
        Date vencimento = dtVencimento.getTime();
        gymDao.getTodosAcessogym(new java.sql.Date(vencimento.getTime()));
        try {
            modeloTabelaPresenca = new ModeloTabelaPresenca(gymDao.resultSet);
            jtPresenca.setModel(modeloTabelaPresenca);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela " + ex);
        }
    }

    public boolean verificaPrenseca(String codBarra) {
        Calendar dtVencimento = Calendar.getInstance();
        Date vencimento = dtVencimento.getTime();
        geraHora();
        if (gymDao.verificaTipoPessoa(codBarra)) {
            try {
                gymModel.setIdCliente(gymDao.resultSet.getInt("idPessoa"));
                gymModel.setData(new java.sql.Date(vencimento.getTime()));
                gymModel.setHoraEntrada(hora);
                gymDao.incluir(gymModel);
                preencherJTabelaPresenca();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: ao ler dados do funcionario que vai entrar o ginásio: " + ex);
            }
        } else if (gymDao.verificaPresenca(new java.sql.Date(vencimento.getTime()), codBarra)) {
            try {
                JOptionPane.showMessageDialog(null, "Voce tem acesso ao sistema!!");
                gymDao.resultSet.first();
                do {

                    gymModel.setIdCliente(gymDao.resultSet.getInt("idCliente"));
                    gymModel.setData(new java.sql.Date(vencimento.getTime()));
                    gymModel.setHoraEntrada(hora);
                    gymDao.incluir(gymModel);
                    preencherJTabelaPresenca();
                } while (gymDao.resultSet.next());
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro: ao ler dados do cliente que vai entrar o ginásio: " + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Voce nao tem acesso ao sistema!!");
        }
        return false;
    }

    public String geraHora() {
        int s, m, h;
        Calendar calendario = Calendar.getInstance();
        s = calendario.get(Calendar.SECOND);
        m = calendario.get(Calendar.MINUTE);
        h = calendario.get(Calendar.HOUR_OF_DAY);
        hora = h + ":" + m + ":" + s;
        return hora;
    }
}
