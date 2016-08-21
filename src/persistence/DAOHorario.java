package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Horario;
import view.Login;

public class DAOHorario {

    PreparedStatement ps = null;
    Statement st = null;
    Conexao con = Login.con;
    public ResultSet resultSet = null;

    public boolean incluir(Horario obj) throws SQLException {

        String SQL = "INSERT INTO horario (idModalidade, diaSemana, horaInicio, horaFim) values(?,?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getModalidade());
        ps.setInt(2, obj.getDiasemana());
        ps.setTimestamp(3, new java.sql.Timestamp(obj.getHoraInicio().getTime()));
        ps.setTimestamp(4, new java.sql.Timestamp(obj.getHoraFim().getTime()));

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public Horario pesquisar(int idHorario) throws SQLException {
        Horario obj = null;
        String SQL = "SELECT * FROM horario where idHorario = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, idHorario);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            obj = new Horario();
            obj.setModalidade(rs.getInt("idModalidade"));
            obj.setIdHorario(rs.getInt("idHorario"));
            obj.setDiasemana(rs.getInt("diaSemana"));
            obj.setHoraFim(rs.getTimestamp("horaFim"));
            obj.setHoraInicio(rs.getTimestamp("horaInicio"));
        }
        return obj;
    }

    public boolean editar(Horario obj) throws Exception {

        String SQL = "Update horario set horaInicio = ?"
                + ", horaFim = ?  where idHorario = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setTimestamp(1, new java.sql.Timestamp(obj.getHoraInicio().getTime()));
        ps.setTimestamp(2, new java.sql.Timestamp(obj.getHoraFim().getTime()));
        ps.setInt(3, obj.getIdHorario());
        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean excluir(Horario obj) throws SQLException {
        String SQL = "DELETE FROM horario WHERE idHorario = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getIdHorario());

        int registros = ps.executeUpdate();
        return registros > 0;

    }

    //Horario tabela
    public void getTodosHorarioModalidade(String modalidade) {
        try {
            String SQL = "select horario.idHorario, modalidade.nome, diasemana.nome as semana, horario.horaInicio, horario.horaFim \n"
                    + "FROM modalidade inner join horario on modalidade.idModalidade = horario.idModalidade \n"
                    + "inner join diasemana on diasemana.idSemana = horario.diaSemana WHERE modalidade.idModalidade=" + modalidade;
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Pegar um horario
    public void getHorario(String idHorario) {
        try {
            String SQL = "SELECT * FROM horario WHERE idHorario = " + idHorario;
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Horario Semana
    //Horario tabela
    public void getTodosHorarioSemana(String semana) {
        try {
            String SQL = "select horario.idHorario, modalidade.nome, diasemana.nome as semana, horario.horaInicio, horario.horaFim \n"
                    + "FROM modalidade inner join horario on modalidade.idModalidade = horario.idModalidade \n"
                    + "inner join diasemana on diasemana.idSemana = horario.diaSemana WHERE diasemana.nome='" + semana + "'";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
