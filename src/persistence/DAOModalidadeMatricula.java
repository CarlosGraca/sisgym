package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Matriculamodalidade;
import view.Login;

public class DAOModalidadeMatricula {

    PreparedStatement ps = null;
    Statement st = null;
    Conexao con = Login.con;
    public ResultSet resultSet = null;

    public DAOModalidadeMatricula() {
    }

    public boolean incluirModalidadeMatricula(Matriculamodalidade obj) throws SQLException {

        String SQL = "INSERT INTO `matriculamodalidade`(`idMatricula`, `idModalidade`, `valorModalidade`) VALUES (?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getMatricula());
        ps.setInt(2, obj.getModalidade());
        ps.setDouble(3, obj.getValorModalidade());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

//    public Modalidade pesquisar(String idModalidade) throws SQLException {
//        Modalidade obj = null;
//        String SQL = "Select * from modalidade where idModalidade = " + idModalidade;
//        ps = con.getConexao().prepareStatement(SQL);
//
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//            obj = new Modalidade();
//            obj.setIdModalidade(rs.getInt("idModalidade"));
//            obj.setNome(rs.getString("nome"));
//            obj.setValor(rs.getDouble("valor"));
//        }
//        return obj;
//    }
//
//    public boolean editar(Modalidade obj) throws Exception {
//        String SQL = "Update modalidade set nome = ?, valor = ? where idModalidade = ?";
//        ps = con.getConexao().prepareStatement(SQL);
//        ps.setString(1, obj.getNome());
//        ps.setDouble(2, obj.getValor());
//        ps.setInt(3, obj.getIdModalidade());
//
//        int registros = ps.executeUpdate();
//        return registros > 0;
//    }
//
     public boolean excluirModalidadeMatricula(Matriculamodalidade obj) throws SQLException {
        
        String SQL = "DELETE FROM `matriculamodalidade` WHERE `idModalidade` = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getModalidade());

        int registros = ps.executeUpdate();
        return registros > 0;
        
    }
//
//    public void getTodosModalidade() {
//        try {
//            String SQL = "SELECT  * FROM `modalidade`";
//            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//            resultSet = st.executeQuery(SQL);
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
// 
//
//    public void getTodosModalidadeFiltro(int codigoLinha) {
//        try {
//            String SQL = "SELECT * FROM modalidade where " + codigoLinha;
//            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//            resultSet = st.executeQuery(SQL);
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public ResultSet getUtimoRegistro() {
//        try {
//            resultSet.last();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return resultSet;
//    }
//
//    public void executeSQL(String codigo) {
//        try {
//            String sql = "select * from modalidade where idModalidade = " + codigo;
//            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//            resultSet = st.executeQuery(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//     public void executeSQLModalidadeNome(String nome) {
//        try {
//            String sql = "select * from modalidade where nome like '%"+nome+"%' ORDER BY `idModalidade`";
//            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//            resultSet = st.executeQuery(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void getTodosModalidadeHorario() {
//        try {
//            String SQL = "SELECT  modalidade.`idModalidade`,`diaSemana`, `nome`,horaInicio, horaFim FROM horario, `modalidade` WHERE modalidade.`idModalidade`=horario.`idModalidade`";
//            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//            resultSet = st.executeQuery(SQL);
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
