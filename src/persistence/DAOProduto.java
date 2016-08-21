package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Empresa;
import model.Produto;
import view.Login;

public class DAOProduto {

    PreparedStatement ps = null;
    Statement st = null;
    Conexao con = Login.con;
    public ResultSet resultSet = null;
    
    public DAOProduto() {
    }

    public boolean incluir(Produto obj) throws SQLException {
        String SQL = "INSERT INTO `produto`(`nome`, `preco`, `quantidade`, `data`, `cod_Barra`, Cod_Func) VALUES (?,?,?,?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setFloat(2, obj.getPreco());
        ps.setInt(3, obj.getQuantidade());
        ps.setDate(4, new java.sql.Date(obj.getData().getTime()));
        ps.setString(5, obj.getCodBarra());
        ps.setInt(6, obj.getCodFunc());
        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public Empresa pesquisar() throws SQLException {
        Empresa obj = null;
        String SQL = "Select * from Empresa ";
        ps = con.getConexao().prepareStatement(SQL);
        // ps.setString(1, sigla);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            obj = new Empresa();
            obj.setNome(rs.getString("nome"));
            obj.setNif(rs.getInt("nif"));
            obj.setTelefone(rs.getString("telefone"));
            obj.setTelemovel(rs.getString("telemovel"));
            obj.setCp(rs.getInt("cp"));
            obj.setEmail(rs.getString("email"));
            obj.setLocalizacao(rs.getString("localizacao"));
            obj.setLogo(rs.getBytes("logo"));
        }
        return obj;
    }

    public boolean editar(Produto obj) throws Exception {
        String SQL = "UPDATE `produto` SET `nome`=?,`preco`=?,`quantidade`=?,`data`=?,`cod_Barra`=?,`Cod_Func`=? WHERE `idProduto`=?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setFloat(2, obj.getPreco());
        ps.setInt(3, obj.getQuantidade());
        ps.setDate(4, new java.sql.Date(obj.getData().getTime()));
        ps.setString(5, obj.getCodBarra());
        ps.setInt(6, obj.getCodFunc());
        ps.setInt(7, obj.getIdProduto());
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
    public void executeSQLCodigoLinha(String codigoLinha) {
        try {
            String sql = "SELECT * FROM `produto` where idProduto='"+codigoLinha+"'";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }
    public boolean excluir(Produto obj) throws SQLException{
     String SQL = "Delete from produto where idProduto = ?";
        
     ps = con.getConexao().prepareStatement(SQL);
     ps.setInt(1, obj.getIdProduto());
        
     int registros = ps.executeUpdate();
        return registros > 0;
     }
    
     public void pesquisarProduto(String SQL) {
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
    }
}
