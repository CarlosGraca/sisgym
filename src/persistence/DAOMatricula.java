package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Matricula;
import view.Login;

public class DAOMatricula {

    PreparedStatement ps = null;
    Statement st = null;
    Conexao con = Login.con;
    public ResultSet resultSet = null;

    public DAOMatricula() {
    }

    public boolean incluirMatriculaInicial(Matricula obj) throws SQLException {

        String SQL = "insert into matricula (idCliente, mat_data, valorTotal, idFuncionario) values(?,?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);

        ps.setInt(1, obj.getPessoa());
        ps.setDate(2, new java.sql.Date(obj.getMatData().getTime()));
        ps.setDouble(3, obj.getValorTotal());
        ps.setInt(4, obj.getUtilizador());        

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean editarMatricula(Matricula obj) throws Exception {
        String SQL = "UPDATE `matricula` SET `valorTotal`=?  WHERE `idMatricula` = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setDouble(1, obj.getValorTotal());
        ps.setInt(2, obj.getIdMatricula());

        int registros = ps.executeUpdate();
        return registros > 0;
    }


    public boolean excluir(Matricula obj) throws SQLException {

        String SQL = "Delete from matricula where idMatricula = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getIdMatricula());

        int registros = ps.executeUpdate();
        return registros > 0;

    }

    public void getTodosMatricula() {
        try {
            String SQL = "SELECT * from matricula";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar matricula" + ex.getMessage());
        }
    }

    public ResultSet getUtimoRegistroMatricula() {
        try {
            resultSet.last();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao selecionar ultimo matricula inserido"+ ex.getMessage());
        }
        return resultSet;
    }
//
//    public void executeSQL(String codigo) {
//        try {
//            String sql = "select * from pessoa where tipoPessoa=0 and idPessoa = " + codigo;
//            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//            resultSet = st.executeQuery(sql);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
//        }
//    }
//
//    public void pesquisaPersonalizadoClientes(String campo, String pesquisa) {
//        switch (campo) {
//            case "Nome":
//                String sql = "SELECT * FROM `pessoa` WHERE tipoPessoa=0 and `nome` LIKE '%" + pesquisa + "%' ORDER BY nome";
//                try {
//                    st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                            ResultSet.CONCUR_READ_ONLY);
//                    resultSet = st.executeQuery(sql);
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "Erro  " + ex.getMessage());
//                }
//                break;
//            case "Codigo":
//                String sql1 = "select * from pessoa where  tipoPessoa=0 and idPessoa =" + pesquisa + "ORDER BY idPessoa";
//                try {
//                    st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                            ResultSet.CONCUR_READ_ONLY);
//                    resultSet = st.executeQuery(sql1);
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "Erro  " + ex.getMessage());
//                }
//                break;
//        }
//
//    }
}
