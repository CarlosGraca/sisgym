package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.ParamIva;
import view.Login;

public class DAOIva {

    PreparedStatement ps = null;
    Statement st = null;
    Conexao con = Login.con;
    public ResultSet resultSet = null;

    public DAOIva() {
    }

//    public boolean incluir(ServidorEmail obj) throws SQLException {
//
//        String SQL = "INSERT INTO servidor_email(ser_smtp, ser_porta, ser_email, ser_senha, ser_assinatura) values(?,?,?,?,?)";
//
//        ps = con.getConexao().prepareStatement(SQL);
//        ps.setString(1, obj.getSerSmtp());
//        ps.setInt(2, obj.getSerPorta());
//        ps.setString(3, obj.getSerEmail());
//        ps.setString(4, obj.getSerSenha());
//        ps.setString(5, obj.getSerAssinatura());
//
//        int registros = ps.executeUpdate();
//        return registros > 0;
//    }

    public boolean editar(ParamIva obj) throws Exception {
        String SQL = "UPDATE `param_iva` SET `valor_iva`=?, iva=?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setDouble(1, obj.getValorIva());
        ps.setDouble(2, obj.getIva());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public void executeSQL() {
        try {
            String sql = "select * from param_iva";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }
    
    

}
