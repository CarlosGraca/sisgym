package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.MConexao;
import view.Login;

public class DAOConexao {

    PreparedStatement ps = null;
    Statement st = null;
    public ResultSet resultSet = null;
    Conexao con = Login.con;
    public DAOConexao() {
    }

    public boolean incluir(MConexao obj) throws SQLException {

        String SQL = "INSERT INTO `conexao`(`driver`, `driverManager`, `baseDados`, `mensagem`) values(?,?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getDriver());
        ps.setString(2, obj.getDriverManager());
        ps.setString(3, obj.getBaseDados());
        ps.setString(4, obj.getMensagem());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean editar(MConexao obj) throws Exception {
        String SQL = "UPDATE `conexao` SET `driver`=?,`driverManager`=?,`baseDados`=?,`mensagem`=?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getDriver());
        ps.setString(2, obj.getDriverManager());
        ps.setString(3, obj.getBaseDados());
        ps.setString(4, obj.getMensagem());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public void executeSQL() {
        try {
            String sql = "SELECT * FROM `conexao`";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar dados de conexao" + ex.getMessage());
        }
    }
    
    

}
