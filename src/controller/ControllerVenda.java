package controller;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ItemVendaProduto;
import model.MVenda;
import model.Produto;
import persistence.DAOProduto;
import persistence.DAOVenda;
import table.ModeloTabelaItensVenda;
import table.ModeloTabelaPesquisaCliente;
import table.ModeloTabelaPesquisaProduto;
import table.ModeloTabelaVenda;
import view.VVenda;
import static view.VVenda.jTableItensVenda;
import static view.VVenda.jTablePesquisa;
import static view.VVenda.jTextFieldAPagar;
import static view.VVenda.jtVen_Quant;
import static view.VVenda.jtVen_nomeCliente;
import static view.VVenda.jtVen_nomeProduto;
import static view.VVenda.jtVen_valor;
import static view.VVenda.jtVenda;

public class ControllerVenda {

    DAOProduto prodDao;
    DAOVenda venDao;
    Produto prodModel;
    ItemVendaProduto itemModel;
    MVenda vendModel;
    ModeloTabelaPesquisaProduto modeloTabelaProduto;
    ModeloTabelaPesquisaCliente modeloTabelaPesquisaCliente;
    ModeloTabelaItensVenda modeloTabelaItensVenda;
    ModeloTabelaVenda modeloTabelaVenda;

    public ControllerVenda() {
        prodModel = new Produto();
        prodDao = new DAOProduto();
        venDao = new DAOVenda();
        itemModel = new ItemVendaProduto();
        vendModel = new MVenda();
        //prodDao.executeSQL();

    }

    public boolean manutencaoVendaIncial(int id, Date data) {
        try {
            vendModel.setValorVenda(0);
            vendModel.setCodFunc(id);
            vendModel.setData(data);
            if (venDao.incluirVenda(vendModel)) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error inserir venda inicial" + ex);
        }
        return false;
    }

    public ResultSet getUltimoRegistro() {
        venDao.executeSQLTodosVenda();
        return venDao.getUtimoRegistro();
    }

    public boolean manutencaoVendaFinal(String acao, Date data, int cliente, float valorVenda, int func, int venda) {
        vendModel.setNomeCliente(cliente);
        vendModel.setValorVenda(valorVenda);
        vendModel.setCodFunc(func);
        vendModel.setIdVenda(venda);
        vendModel.setData(data);
        switch (acao) {
            case "inserirVenda": {
                try {
                    if (venDao.editarVenda(vendModel)) {
                        JOptionPane.showMessageDialog(null, "Registo finalizado com sucesso");
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel finalizar o registro!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error ao finalizar venda: " + ex.getMessage());
                }
            }
            break;
        }
        return false;
    }

    public boolean manutencaoVenda(String acao, String quant, int idVenda, int idProduto, float valorIem) {
        itemModel.setQuantidadeProduto(Integer.parseInt(quant));
        itemModel.setIdvenda(idVenda);
        itemModel.setIdproduto(idProduto);
        itemModel.setValorItem(valorIem);
        try {
            switch (acao) {
                case "inserir":
                    if (venDao.incluirIemVenda(itemModel)) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel inserir o registro!");
                    }
                    break;
//                
            }
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro manutenção de Venda");
        }
        return false;
    }

    public void manutencaoPesquisaNome(String codigoLinha) throws IOException {
        try {
            venDao.executeSQLNome(codigoLinha);
            venDao.resultSet.next();
            VVenda.idProduto = Integer.parseInt(venDao.resultSet.getString(1));
            jtVen_nomeProduto.setText(venDao.resultSet.getString(2));
            jtVen_valor.setText(venDao.resultSet.getString(3));

        } catch (SQLException erro) {
        }
    }

    public boolean verificaQuantidadeProduto(String nome) {
        try {
            if (venDao.verificaQuantidadeProduto(nome) != 0) {
                int quantidadeProduto = venDao.verificaQuantidadeProduto(nome);
                if (quantidadeProduto < Integer.parseInt(jtVen_Quant.getText())) {
                    JOptionPane.showMessageDialog(null, "Error: Quantidade produto desejada não esta diponivel! Apenas temos: " + quantidadeProduto);
                    return false;
                }
                VVenda.quantidadeProduto = quantidadeProduto - Integer.parseInt(jtVen_Quant.getText());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: estoque esgotou!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error na veirificacao de quantidade produto: " + ex.getMessage());
        }
        return false;
    }

    public void cancelaVenda() throws Exception {
        try {
            if (venDao.executeSQLTodosVendaIgual0()) {
                venDao.resultSet.first();
                while (venDao.resultSet.next()) {
                    int qdtProduto = venDao.resultSet.getInt("quantidade");
                    int qdtVenda = venDao.resultSet.getInt("quantidade_produto");
                    int soma = qdtProduto + qdtVenda;
                    prodModel.setIdProduto(venDao.resultSet.getInt("idProduto"));
                    prodModel.setQuantidade(soma);
                    itemModel.setIdvenda(venDao.resultSet.getInt("Id_venda"));
                    if (venDao.editarQuatidadeProduto(prodModel)) {
                        venDao.excluirItemVenda(itemModel);
                    }
                }
                venDao.excluirVenda();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: no cancelamento produto: " + ex.getMessage());
        }
    }

    public boolean upadateQuantidadeProduto(int quantidade, String nome) {
        try {
            prodModel.setQuantidade(quantidade);
            prodModel.setNome(nome);
            if (venDao.editarBaixaProduto(prodModel)) {
                //  JOptionPane.showMessageDialog(null, "Registo baixa efetuado com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel dar baixa no produto!");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel dar baixa no produto! " + ex.getMessage());
        }
        return false;
    }

    public void manutencaoPesquisaNomeCliente(String codigoLinha) throws IOException {
        try {
            venDao.executeSQLNomeCliente(codigoLinha);
            venDao.resultSet.next();
            jtVen_nomeCliente.setText(venDao.resultSet.getString(2));

        } catch (SQLException erro) {
        }
    }

    public void somaProduto(int codigo) throws IOException {
        try {
            venDao.executeSQLItensVendaSoma(codigo);
            venDao.resultSet.next();
            jTextFieldAPagar.setText(venDao.resultSet.getString(1));

        } catch (SQLException erro) {
        }
    }

    public void preencherJTabelaPesquisaProduto(String nome) {
        venDao.executeSQLNome(nome);
        try {
            modeloTabelaProduto = new ModeloTabelaPesquisaProduto(venDao.resultSet);
            jTablePesquisa.setModel(modeloTabelaProduto);
            //jTablePesquisa.removeColumn(jTablePesquisa.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela produto" + ex);
        }
    }

    public void preencherJTabelaVenda() {
        venDao.executeSQLVenda();
        try {
            modeloTabelaVenda = new ModeloTabelaVenda(venDao.resultSet);
            jtVenda.setModel(modeloTabelaVenda);
            jtVenda.removeColumn(jTablePesquisa.getColumnModel().getColumn(0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela produto" + ex);
        }
    }

    public void preencherJTabelaVenda(Date data) {
        venDao.executeSQLVenda(data);
        try {
            modeloTabelaVenda = new ModeloTabelaVenda(venDao.resultSet);
            jtVenda.setModel(modeloTabelaVenda);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela produto" + ex);
        }
    }

    public void preencherJTabelaPesquisaCliente(String nome) {
        venDao.executeSQLNomeCliente(nome);
        try {
            modeloTabelaPesquisaCliente = new ModeloTabelaPesquisaCliente(venDao.resultSet);
            jTablePesquisa.setModel(modeloTabelaPesquisaCliente);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela nome cliente" + ex);
        }
    }

    public void preencherJTabelaItemVenda(int codigo) {
        venDao.executeSQLItensVenda(codigo);
        try {
            modeloTabelaItensVenda = new ModeloTabelaItensVenda(venDao.resultSet);
            jTableItensVenda.setModel(modeloTabelaItensVenda);
            somaProduto(codigo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher jtabela nome venda" + ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
