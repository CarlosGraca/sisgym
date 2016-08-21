package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Equipamento;
import view.Login;

public class DAOEquipamento {

    public ResultSet resultSet = null;
    PreparedStatement ps = null;
    Statement st;
    Conexao con = Login.con;

    public DAOEquipamento() {
    }

    public boolean incluir(Equipamento obj) throws SQLException {
        String SQL = "insert into equipamento (nome, marca, codEquipamento) values(?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getMarca());
        ps.setString(3, obj.getCodEquipamento());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public Equipamento pesquisar(int idEquipamento) throws SQLException {
        Equipamento obj = null;
        String SQL = "Select * from equipamento where idEquipamento = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, idEquipamento);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            obj = new Equipamento();
            obj.setIdEquipamento(rs.getInt("idEquipamento"));
            obj.setNome(rs.getString("nome"));
            obj.setMarca(rs.getString("marca"));
            obj.setCodEquipamento(rs.getString("codEquipamento"));
        }
        return obj;
    }

    public boolean editar(Equipamento obj) throws Exception {
        String SQL = "Update equipamento set nome = ?, marca = ?, codEquipamento = ? where idEquipamento = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getMarca());
        ps.setString(3, obj.getCodEquipamento());
        ps.setInt(4, obj.getIdEquipamento());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean excluir(Equipamento obj) throws SQLException {

        String SQL = "Delete from equipamento where idEquipamento = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getIdEquipamento());

        int registros = ps.executeUpdate();
        return registros > 0;

    }

    public void getTodosEquipamentos() {
        try {
            String SQL = "SELECT * FROM equipamento";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getPrimeiroRegistro() {
        try {
            resultSet.first();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public ResultSet getUtimoRegistro() {
        try {
            resultSet.last();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public void pesquisarEquipamento(String SQL) {
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
    }

}
