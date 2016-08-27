package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pagamento;
import persistence.DAOFuncionario;
import persistence.DAOPagamento;
import table.ModeloTabelaPagamento;
import table.ModeloTabelaPagamentoPesquisa;
import static view.VPagamentos.jtPag_valor;
import static view.VPagamentos.jTable_pagamento;
import static view.VPagamentos.jcbClientePagamento;
import static view.VPagamentos.jcbPag_desc;
import static view.VPagamentos.jcbPag_tipoPag;
import static view.VPagamentos.jtPag_cod;
import static view.VPagamentos.jtPag_data;
import static view.VPagamentos.jtPag_dataValidade;
import static view.VPagamentos.jtPag_obs;

public class ControllerPagamento {

    Pagamento pagModel;
    DAOPagamento pagDao;
    DAOFuncionario funcDao;
    
    String codigoLinha;
    ModeloTabelaPagamento modeloTabelaPagamento;
    ModeloTabelaPagamentoPesquisa modeloTabelaPagamentoPesquisa;

    public ControllerPagamento() {
        pagDao = new DAOPagamento();
        pagModel = new Pagamento();
        funcDao = new DAOFuncionario();
//        pagDao.getTodosCliente();
    }

    public boolean manutencaoPagamento(String acao, String codigo, int id_Cliente, int idMatricula, int id_Funcionario, 
            String id_Tipo, Date dt_Pagamento, Date dt_ValidadePagamento, String obs, String descricao, 
            String cod_Pagamento, boolean Status, int mes) {
        try {
            if (!codigo.equals("")) {
                pagModel.setIdPagamento(Integer.parseInt(codigo));
            }
            pagModel.setIdCliente(id_Cliente);
            pagModel.setIdFuncionario(id_Funcionario);
            pagModel.setTipo(id_Tipo);
            pagModel.setData(dt_Pagamento);
            pagModel.setDataValidade(dt_ValidadePagamento);
            pagModel.setCodPagamento((cod_Pagamento));
            pagModel.setEstado(Status);
            pagModel.setObs(obs);
            pagModel.setDescricao(descricao);
            pagModel.setIdControlPagamento(idMatricula);
            pagModel.setIdMes(mes);

            switch (acao) {
                case "inserir":
                    if (pagDao.incluir(pagModel)) {
                        
                        // pagDao.getTodosPagamento();
                        preencherJTabelaPagamento();
                       // Jtab_pagamento.setSelectedIndex(0);
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
                case "editar":
                    String nomeEdite = "Editar o pagamento " + jcbPag_desc.getSelectedItem() + " do cliente " + jcbClientePagamento.getSelectedItem() + " ?";
                    int opcaoEscolhid = JOptionPane.showConfirmDialog(null, nomeEdite, "Confirmacão Alteração ", JOptionPane.YES_OPTION);
                    if (opcaoEscolhid == JOptionPane.YES_OPTION) {
                        if (pagDao.Editar(pagModel)) {
                            JOptionPane.showMessageDialog(null, "Registo alterado com sucesso");
                            preencherJTabelaPagamento();
                           // Jtab_pagamento.setSelectedIndex(0);
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro no alteração do pagamento");
                        }
                    }
                    break;
                case "update":
                    String nomeAPagamento = "Cancelar o pagamento " + " do cliente " + jcbClientePagamento.getSelectedItem() + " ?";
                    int opcaoEscolhida = JOptionPane.showConfirmDialog(null, nomeAPagamento, "Confirmacão Cancelamento ", JOptionPane.YES_OPTION);
                    if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                        if (pagDao.Upadate(pagModel)) {
                            JOptionPane.showMessageDialog(null, "Registo cancelado com sucesso");
                            preencherJTabelaPagamento();
                           // Jtab_pagamento.setSelectedIndex(0);
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro no cancelamento do pagamento");
                        }
                    }
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerPagamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControllerPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //
    //    public void selectModalidade() {
    //        try {
    //            modalModel = cliDao.pesquisar(jcModalidade);
    //
    //        } catch (SQLException erro) {
    //            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
    //        }
    //    }
//Passar dados pagamento para detalhes
    public void manutencaoPesquisa() {
        codigoLinha = (String) modeloTabelaPagamento.getValueAt(jTable_pagamento.getSelectedRow(), 0);
        try {
            pagDao.getTodosPagamentoFiltroIdCompleto(codigoLinha);
            pagDao.resultSet.next();

           // jcbClientePagamento.getSelectedItem().setText(pagDao.resultSet.getString(18));
            jtPag_cod.setText(pagDao.resultSet.getString(1));
            jtPag_valor.setText(pagDao.resultSet.getString(16));
            jcbPag_tipoPag.setSelectedItem(pagDao.resultSet.getString(4));
            jtPag_data.setDate(pagDao.resultSet.getDate(5));
            jtPag_dataValidade.setDate(pagDao.resultSet.getDate(8));
            jtPag_obs.setText(pagDao.resultSet.getString(9));
            jcbPag_desc.setSelectedItem(pagDao.resultSet.getString(10));
           // VPagamento.idCliente = pagDao.resultSet.getString(3);
            //VPagamento.idMatricula = pagDao.resultSet.getString(12);

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro carregar dados do pagamento para" + erro);
        }
    }

    public void upadateEstado() {
        try {
            java.util.Date dt = new java.util.Date();
            pagDao.UpadateEstado(new java.sql.Date(dt.getTime()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estado " + ex.getMessage());
        }
    }
    
     public int getValorPagamento(int idMatricula, int idCliente) {
         return pagDao.getValorPagamento(idMatricula, idCliente);
    }
    public void selectClienteComobox() {
        //pagDao.getTodosCliente();;
        try {
            String SQL = "SELECT a.idPessoa, b.idMatricula, a.nome FROM pessoa a, matricula b where a.tipoPessoa = 0 and a.status  = 1 and a.idPessoa = b.idCliente order by a.nome";
             funcDao.pesquisarFunComo(jcbClientePagamento,SQL, 1);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro.getMessage());
        }
    }
    public void preencherJTabelaPagamento() {
        java.util.Date dt = new java.util.Date();
        pagDao.getTodosPagamento(new java.sql.Date(dt.getTime()));
       
       /* try {
            modeloTabelaPagamento = new ModeloTabelaPagamento(pagDao.resultSet);
            jTable_pagamento.setModel(modeloTabelaPagamento);
            jTable_pagamento.removeColumn(jTable_pagamento.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela " + ex);
        }*/
    }

    public ResultSet getUltimoRegistro() {
        pagDao.getTodosPagamento();
        return pagDao.getUtimoPagamento();
    }

    //Pesquisa de Cliente (Pagamento)
    public void pesquisaClientePagamento(String pesq) {
        pagDao.pesquisaClientePagamento(pesq);

        try {
            modeloTabelaPagamentoPesquisa = new ModeloTabelaPagamentoPesquisa(pagDao.resultSet);
           // VPagamentos.jtPagamentoFilter.setModel(modeloTabelaPagamentoPesquisa);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela " + ex);
        }
    }

    public void manutencaoPesquisaPagamentoNome(String codigoLinha) throws IOException {
        try {
            pagDao.pesquisaClientePagamentoId(codigoLinha);
            pagDao.resultSet.next();

            //jcClientePagamento.setText(pagDao.resultSet.getString(2));
         //   VPagamento.idMatricula = pagDao.resultSet.getString(3);
          //  VPagamento.idCliente = pagDao.resultSet.getString(4);
            jtPag_valor.setText(pagDao.resultSet.getString(5));
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar idCliente " + erro.getMessage());
        }
    }
    
    public void pesquisaPagamento(String nome, String idMes, String inicio, String fim, String acao) {
        try {
            switch (acao) {               
                case "Pagamento":
                    String sql = "SELECT a.`idPagamento`,p.`nome`,a.`descricao`,b.`descricao` mes,`data`,`dataValidade`,"
                            + "         if(a.estado=0, \"Terminado\", \"Em Curso\")  estado \n" +
                                        "FROM `pagamento` a, `pessoa` p,`mes` b \n" +
                                        "WHERE `idCliente`= p.idPessoa \n" +
                                        "and idMes = id \n" +
                                        "and a.idMes like '"+idMes+"%' \n"+
                                        "and upper(p.nome) like upper('%"+nome+"%')\n" +
                                        "and (data between  '"+inicio+"' and '"+fim+"')";
                    System.out.println("Sql Pesquisa :: "+sql);
                    pagDao.execute_sql(sql);
                    modeloTabelaPagamento = new ModeloTabelaPagamento(pagDao.resultSet);
                    jTable_pagamento.setModel(modeloTabelaPagamento);
                    jTable_pagamento.removeColumn(jTable_pagamento.getColumnModel().getColumn(0));
                    break;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela pagamento " + ex);
        }
    }
}
