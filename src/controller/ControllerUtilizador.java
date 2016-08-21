/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import persistence.DAOUtilizador;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Item;
import model.NivelAcesso;
import model.Pessoa;
import model.Utilizador;
import persistence.DAOFuncionario;
import table.ModeloTabelaNivelAcesso;
import table.ModeloTabelaUtilizador;
import view.Principal;
import static view.VUtilizador.jTabUt;
import static view.VUtilizador.jTablePermissoes;
import static view.VUtilizador.jcbUt_nome;
import static view.VUtilizador.jtUt_cod;
import static view.VUtilizador.jcbUt_status;
import static view.VUtilizador.jcbUt_tipo;
import static view.VUtilizador.jdcUt_dt_registro;
import static view.VUtilizador.jtUtilizador;
import static view.VUtilizador.jtUt_login;


/**
 *
 * @author Carlos
 */
public class ControllerUtilizador {

    int conta = 0;
    Utilizador utModel;
    NivelAcesso utMenu;
    DAOUtilizador utDAO;
    ModeloTabelaUtilizador modeloTabelaUtilizador;
    ModeloTabelaNivelAcesso modeloTabelaMenu;
    String codigoLinha;
    DAOFuncionario funcDao;
    Pessoa funcModel;
    int index;
    DAOUtilizador utilDao;

    public ControllerUtilizador() {
        utModel = new Utilizador();
        utMenu = new NivelAcesso();
        utDAO = new DAOUtilizador();
        funcDao = new DAOFuncionario();
        funcModel = new Pessoa();
        utilDao = new DAOUtilizador();
    }

    public boolean verificaUtilizador(String login, String senha) {
        utDAO.getTodosUtilizadores();
        if (login.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Os campos  não pode ser vazio!!!", "Atenção", JOptionPane.CANCEL_OPTION);
        } else {
            if (conta <= 1) {
                try {
                    int idUtilizador = utilDao.verificaUtilizador(login, senha);
                    if (idUtilizador != 0) {
                        Principal.id = idUtilizador;
                        return true;
                    } else {
                        conta++;
                        if (conta == 1) {
                            JOptionPane.showMessageDialog(null, "Senha incorreta, voce só tem mais uma chance", "Erro", JOptionPane.CANCEL_OPTION);
                        } else {
                            JOptionPane.showMessageDialog(null, "De novo senha incorreta. Usuario Inabilitado para usar o sistema\nO sistema ser finalizado!!!", "Erro", JOptionPane.CANCEL_OPTION);
                            return true;
                        }
                    }

                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Acesso negado " + erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return false;
    }

    public boolean manutencaoUtilizador(String acao, String codigo, String login, String senha, int status, Date data_registro, Date data_utVisista, int nome, int tipoUtilizador) {
        if (!codigo.equals("")) {
            utModel.setUtIdUtilizador(Integer.parseInt(codigo));
        }        
        utModel.setUtNome(String.valueOf(nome));
        utModel.setUtLogin(login);
        utModel.setUtSenha(senha);
        utModel.setUtdtReg(data_registro);
        utModel.setUtdtUltimaVisita(data_utVisista);
        utModel.setUtStatus(status);
        utModel.setUttipoUtilzador(tipoUtilizador);

        try {
            switch (acao) {
                case "inserir":
                    if (utDAO.incluir(utModel)) {
                        JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        utDAO.getTodosUtilizadores();
                        preencherJTableUtilizadores();
                        jTabUt.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "alterar":
                    if (utDAO.editar(utModel)) {
                        JOptionPane.showMessageDialog(null, "Registo editado com sucesso");
                        utDAO.getTodosUtilizadores();
                        preencherJTableUtilizadores();
                        jTabUt.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel editar o registro!");
                    }
                    break;
                case "excluir":
                    String nomeUt = "Apagar utilizador " + jcbUt_nome.getSelectedItem().toString() + " ?";
                    int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeUt, "Confirmacão Exclusão ", JOptionPane.YES_OPTION);
                    if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                        utModel.setUtIdUtilizador(Integer.parseInt(jtUt_cod.getText()));
                        if (utDAO.excluir(utModel)) {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");
                            utDAO.getTodosUtilizadores();
                            preencherJTableUtilizadores();
                            jTabUt.setSelectedIndex(0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Registo eleminado com sucesso");

                        }
                    }
                    break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ControllerUtilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean manutencaoMenu(String acao, int codigo, int func, String menu) {
        utMenu.setId(codigo);
        utMenu.setNiCodUtilizador(func);
        utMenu.setNiMenu(menu);

        try {
            switch (acao) {
                case "inserir":
                    if (utDAO.incluirMenu(utMenu)) {
                        JOptionPane.showMessageDialog(null, "Registo salvo com sucesso");
                        //utDAO.getTodosUtilizadores();
                        preencherJTableMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "excluir":
                    if (utDAO.excluirMenu(utMenu)) {
                        JOptionPane.showMessageDialog(null, "Registo excluido com sucesso");
                        //utDAO.getTodosUtilizadores();
                        preencherJTableMenu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel excluir o registro!");
                    }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    public void preencherJTableUtilizadores() {
        utDAO.getTodosUtilizadores();
        try {
            modeloTabelaUtilizador = new ModeloTabelaUtilizador(utDAO.resultSet);
            jtUtilizador.setModel(modeloTabelaUtilizador);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel " + ex);
        }
    }

    public void preencherJTableMenu() {
        utDAO.getTodosMenu2();
        try {
            modeloTabelaMenu = new ModeloTabelaNivelAcesso(utDAO.resultSet);
            jTablePermissoes.setModel(modeloTabelaMenu);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel menu " + ex);
        }
    }

    public void preencherJTableMenu2(int index) {
        utDAO.getTodosMenu(index);
        try {
            modeloTabelaMenu = new ModeloTabelaNivelAcesso(utDAO.resultSet);
            jTablePermissoes.setModel(modeloTabelaMenu);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabel menu " + ex);
        }
    }
    
    public boolean checkUserAcessAdmin(int idUser){
        return utDAO.getTipoUtilizadorAdmin(idUser);
    }

    public boolean verificaAcesso(String menu, int codUtil) {
        try {
            utDAO.getTodosMenu2();
            if (utDAO.verificaMenu(menu, codUtil) != 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerUtilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void manutencaoPesquisa() {
        codigoLinha = (String) modeloTabelaUtilizador.getValueAt(jtUtilizador.getSelectedRow(), 0);
       try {
            utDAO.executeSQL(codigoLinha);
            utDAO.resultSet.next();
            jtUt_cod.setText(utDAO.resultSet.getString(1));
            jtUt_login.setText(utDAO.resultSet.getString(2));
            //jpUt_senha.setText(utDAO.resultSet.getString(3));
            //Item selected_item = (Item) jcbUt_nome.setSelectedItem(utDAO.resultSet.getString(10));
            
            String nome = utDAO.resultSet.getString(10);
            int id = utDAO.resultSet.getInt(4);
            Item item = new Item(id, nome);
            jcbUt_nome.setSelectedItem(item);
            
            jdcUt_dt_registro.setDate(utDAO.resultSet.getDate(5));
            jcbUt_tipo.setSelectedIndex(utDAO.resultSet.getInt(7));            
            if(utDAO.resultSet.getInt(8) == 1)
                jcbUt_status.setSelected(true);           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(jTabUt, ex.getMessage());
        }
    }

    public void selectFuncComobox() {
        funcDao.getTodosFuncionario();
        try {
            String SQL = "SELECT * FROM pessoa where tipoPessoa = 1 order by nome";
            funcModel = funcDao.pesquisarFunComo(jcbUt_nome,SQL, 0);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
        }
    }

    //ultima visita
    public void ultimaVisita(int idUtilizador, Date data) throws SQLException {
        utModel.setUtIdUtilizador(idUtilizador);
        utModel.setUtdtUltimaVisita(data);
        if (!utDAO.ultimaVisita(utModel)) {
            JOptionPane.showMessageDialog(null, "#Erro falha ao sair do sistema!");
        }
    }
}
