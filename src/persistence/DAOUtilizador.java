/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.NivelAcesso;
import model.Utilizador;
import view.Login;

/**
 *
 * @author Carlos
 */
public class DAOUtilizador {

    Conexao con = Login.con;
    Statement st = null;
    PreparedStatement ps = null;
    public ResultSet resultSet = null;
    int id = 0;

    public boolean incluir(Utilizador obj) throws SQLException {
        String SQL = "INSERT INTO `utilizador`(`ut_login`, `ut_senha`, `ut_nome`, `ut_dtReg`, `ut_dtUltimaVisita`, `ut_tipoUtilizador`, `ut_status`) VALUES (?,?,?,?,?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getUtLogin());
        ps.setString(2, obj.getUtSenha());
        ps.setString(3, obj.getUtNome());
        ps.setDate(4, new java.sql.Date(obj.getUtdtReg().getTime()));
        ps.setDate(5, new java.sql.Date(obj.getUtdtUltimaVisita().getTime()));
        ps.setInt(6, obj.getUttipoUtilzador());
        ps.setInt(7, obj.getUtStatus());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean incluirMenu(NivelAcesso obj) throws SQLException {
        String SQL = "INSERT INTO `nivel_acesso`(`ni_Cod_Utilizador`, `ni_menu`) VALUES (?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getNiCodUtilizador());
        ps.setString(2, obj.getNiMenu());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean editar(Utilizador obj) throws Exception {
        String SQL = "UPDATE `utilizador` SET `ut_login`=?,`ut_senha`=?,"
                + "`ut_nome`=?,`ut_dtUltimaVisita`=?,`ut_tipoUtilizador`=?,`ut_status`=? where `ut_IdUtilizador`=?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getUtLogin());
        ps.setString(2, obj.getUtSenha());
        ps.setString(3, obj.getUtNome());
        ps.setDate(4, new java.sql.Date(obj.getUtdtUltimaVisita().getTime()));
        ps.setInt(5, obj.getUttipoUtilzador());
        ps.setInt(6, obj.getUtStatus());
        ps.setInt(7, obj.getUtIdUtilizador());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean excluir(Utilizador obj) throws SQLException {

        String SQL = "Delete from utilizador where ut_idUtilizador = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getUtIdUtilizador());

        int registros = ps.executeUpdate();
        return registros > 0;

    }

    public boolean excluirMenu(NivelAcesso obj) throws SQLException {

        String SQL = "Delete from nivel_acesso where id = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getId());

        int registros = ps.executeUpdate();
        return registros > 0;

    }

    public int verificaUtilizador(String login, String senha) throws SQLException {
        String sql = "Select * from utilizador where ut_login ='" + login + "' and ut_senha ='" + senha + "' and ut_status = 1";

        ps = con.getConexao().prepareStatement(sql);

        resultSet = ps.executeQuery();
        try {
            if (resultSet.next()) {
                id = resultSet.getInt("ut_IdUtilizador");
                return id;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int verificaMenu(String menu, int codFunc) throws SQLException {
        String sql = "select id, ni_Cod_Utilizador, ni_menu from nivel_acesso where (ni_Cod_Utilizador ='" + codFunc + "' and ni_menu ='" + menu + "')";

        ps = con.getConexao().prepareStatement(sql);

        resultSet = ps.executeQuery();
        try {
            if (resultSet.next()) {
                id = resultSet.getInt("id");
                return id;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;

    }

    public void getTodosUtilizadores() {
        String sql = "select ut_IdUtilizador,ut_nome,  ut_login, ut_dtUltimaVisita, designacao, if(ut_status=0, \"Inativo\", \"Ativo\") As Estado From utilizador, tipoutilizador where idTipoUtilizador = ut_tipoUtilizador";
        execute_sql(sql);
    }

    public void execute_sql(String sql) {
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
    }

    public boolean getTipoUtilizadorAdmin(int idUtilizador) {
        try {
            String sql = "select * from utilizador, tipoUtilizador\n"
                    + "where ut_tipoUtilizador = idTipoUtilizador\n"
                    + "and idTipoUtilizador = 1\n"
                    + "and ut_IdUtilizador = " + idUtilizador;
            
            ps = con.getConexao().prepareStatement(sql);

            resultSet = ps.executeQuery();
            return resultSet.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error preparement statement" + ex);
        }
        return false;
    }

    public void executeSQL(String codigo) {
        String SQL = "SELECT * FROM utilizador inner join pessoa on ut_nome = idPessoa where ut_idUtilizador = " + codigo;
        execute_sql(SQL);
    }

    public void getTodosMenu(int codUtil) {
        String SQL = "select id, ni_Cod_Utilizador, ni_menu from nivel_acesso where ni_Cod_Utilizador =" + codUtil;
        execute_sql(SQL);
    }

    public void getTodosMenu2() {
        String SQL = "select id, ni_Cod_Utilizador, ni_menu from nivel_acesso ";
        execute_sql(SQL);
    }

    //Data de ultima visita
    public boolean ultimaVisita(Utilizador obj) throws SQLException {
        String SQL = "UPDATE utilizador SET ut_dtUltimaVisita = ? WHERE  ut_IdUtilizador = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setDate(1, new java.sql.Date(obj.getUtdtUltimaVisita().getTime()));
        ps.setInt(2, obj.getUtIdUtilizador());

        int registros = ps.executeUpdate();
        return registros > 0;
    }
}
