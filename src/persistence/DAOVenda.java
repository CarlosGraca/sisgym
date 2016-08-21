package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.ItemVendaProduto;
import model.MVenda;
import model.Produto;
import view.Login;

public class DAOVenda {

    PreparedStatement ps = null;
    Statement st = null;
    Conexao con = Login.con;
    public ResultSet resultSet = null;
    int id = 0;
    int qtd = 0;


    public boolean incluirIemVenda(ItemVendaProduto obj) throws SQLException {
        String SQL = "INSERT INTO `item_venda_produto`(`quantidade_produto`, `Id_venda`, `Id_produto`, valorItem) VALUES (?,?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getQuantidadeProduto());
        ps.setFloat(2, obj.getId());
        ps.setInt(3, obj.getIdproduto());
        ps.setFloat(4, obj.getValorItem());
        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean incluirVenda(MVenda obj) throws SQLException {
        String SQL = "INSERT INTO `venda`( ven_data, `ven_valor`, codFunc) VALUES (?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setDate(1, new java.sql.Date(obj.getData().getTime()));
        ps.setFloat(2, obj.getValorVenda());
        ps.setInt(3, obj.getCodFunc());
        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean editarBaixaProduto(Produto obj) throws Exception {
        String SQL = "UPDATE `produto` SET `quantidade`=? WHERE `nome` LIKE ? ";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getQuantidade());
        ps.setString(2, obj.getNome());
        int registros = ps.executeUpdate();
        return registros > 0;
    }
    
    public boolean editarQuatidadeProduto(Produto obj) throws Exception {
        String SQL = "UPDATE `produto` SET `quantidade`=? where idProduto = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getQuantidade());
        ps.setInt(2, obj.getIdProduto());
        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean editarVenda(MVenda obj) throws Exception {
        String SQL = "UPDATE `venda` SET `pes_nome`=?,`ven_valor`=?,`codFunc`=? WHERE `ven_id`=?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getNomeCliente());
        ps.setFloat(2, obj.getValorVenda());
        ps.setInt(3, obj.getCodFunc());
        ps.setInt(4, obj.getIdVenda());
        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public void executeSQL() {
        try {
            String sql = "SELECT * FROM `produto`";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    public void executeSQLTodosVenda() {
        try {
            String sql = "SELECT * FROM `venda`";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }
    public boolean executeSQLTodosVendaIgual0() {
        try {
            String sql = "select * from venda inner join item_venda_produto on "
                    + "venda.ven_id = item_venda_produto.Id_venda inner join "
                    + "produto on item_venda_produto.Id_produto = produto.idProduto where ven_valor=0";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
        return false;
    }

    public ResultSet getUtimoRegistro() {
        try {
            resultSet.last();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar ultimo venda inserido" + ex.getMessage());
        }
        return resultSet;
    }

    public void executeSQLCodigoLinha(String codigoLinha) {
        try {
            String sql = "select * from produto where `cod_Barra` LIKE '%" + codigoLinha + "%'";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    public void executeSQLCodigo(String codigo) {
        try {
            String sql = "select * from produto where `idProduto` = '" + codigo + "'";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }
    public void executeSQLVenda() {
        try {
            String sql = "select ven_id, ven_data, (item_venda_produto.quantidade_produto*item_venda_produto.valorItem) as ven_valor, pessoa.nome as nome_pessoa , quantidade_produto, produto.nome as nome_produto from venda inner join item_venda_produto on venda.ven_id = item_venda_produto.Id_venda inner join pessoa on venda.pes_nome = pessoa.idPessoa inner join produto on item_venda_produto.Id_produto = produto.idProduto ";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }
    
    public void executeSQLVenda(Date data) {
        try {
            String sql = "select ven_id, ven_data, ven_valor, pessoa.nome as nome_pessoa , quantidade_produto, produto.nome as nome_produto from venda inner join item_venda_produto on venda.ven_id = item_venda_produto.Id_venda inner join pessoa on venda.pes_nome = pessoa.idPessoa inner join produto on item_venda_produto.Id_produto = produto.idProduto where ven_data = '"+data+"'";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    public void executeSQLNome(String nome) {
        try {
            String sql = "select * from produto where `nome` LIKE '%" + nome + "%'";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    public void executeSQLNomeCliente(String nome) {
        try {
            String sql = "select * from pessoa where `nome` LIKE '%" + nome + "%'";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    public void executeSQLItensVenda(int codigo) {
        try {
            String sql = "select nome, sum(preco*quantidade_produto) as preco, sum(quantidade_produto) as quantidade_produto from produto inner join item_venda_produto on produto.idProduto  = item_venda_produto.Id_produto inner join venda on venda.ven_id = item_venda_produto.Id_venda where venda.ven_id= " + codigo + " group by nome";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    public void executeSQLItensVendaSoma(int codigo) {
        try {
            String sql = "select sum(preco*quantidade_produto) as totalVenda from item_venda_produto inner join produto on item_venda_produto.Id_produto = produto.idProduto where Id_venda= " + codigo;
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    public boolean excluir(Produto obj) throws SQLException {
        String SQL = "Delete from produto where idProduto = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getIdProduto());

        int registros = ps.executeUpdate();
        return registros > 0;
    }
    public boolean excluirVenda() throws SQLException {
        String SQL = "Delete from venda where ven_valor = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1,0);

        int registros = ps.executeUpdate();
        return registros > 0;
    }
    
    public boolean excluirItemVenda(ItemVendaProduto obj) throws SQLException {
        String SQL = "Delete from item_venda_produto where Id_venda = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getId());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public int achaCodProduto(String nome) throws SQLException {
        String sql = "select * from produto where `nome` LIKE '%" + nome + "%'";

        ps = con.getConexao().prepareStatement(sql);

        resultSet = ps.executeQuery();
        try {
            if (resultSet.first()) {
                id = resultSet.getInt("idProduto");
                return id;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int verificaQuantidadeProduto(String nome) throws SQLException {
        String sql = "select quantidade from produto where `nome` LIKE '%" + nome + "%'";

        ps = con.getConexao().prepareStatement(sql);

        resultSet = ps.executeQuery();
        try {
            if (resultSet.first()) {
                qtd = resultSet.getInt("quantidade");
                return qtd;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;

    }
}
