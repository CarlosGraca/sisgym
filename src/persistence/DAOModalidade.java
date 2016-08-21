package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Modalidade;
import view.Login;

public class DAOModalidade {

    PreparedStatement ps = null;
    Statement st = null;
    Conexao con = Login.con;
    public ResultSet resultSet = null;

    public DAOModalidade() {
    }

    public boolean incluir(Modalidade obj) throws SQLException {

        String SQL = "insert into modalidade (valor,nome) values(?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setDouble(1, obj.getValor());
        ps.setString(2, obj.getNome());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public Modalidade pesquisar(String idModalidade) throws SQLException {
        Modalidade obj = null;
        String SQL = "Select * from modalidade where idModalidade = " + idModalidade;
        ps = con.getConexao().prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            obj = new Modalidade();
            obj.setIdModalidade(rs.getInt("idModalidade"));
            obj.setNome(rs.getString("nome"));
            obj.setValor(rs.getDouble("valor"));
        }
        return obj;
    }

    public boolean editar(Modalidade obj) throws Exception {
        String SQL = "Update modalidade set nome = ?, valor = ? where idModalidade = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setDouble(2, obj.getValor());
        ps.setInt(3, obj.getIdModalidade());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean excluir(Modalidade obj) throws SQLException {

        String SQL = "Delete from modalidade where idModalidade = ?";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getIdModalidade());

        int registros = ps.executeUpdate();
        return registros > 0;

    }

    public void getTodosModalidade() {
        try {
            String SQL = "SELECT  * FROM `modalidade`";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void getTodosModalidadeFiltro(int codigoLinha) {
        try {
            String SQL = "SELECT * FROM modalidade where " + codigoLinha;
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public ResultSet getUtimoRegistro() {
        try {
            resultSet.last();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return resultSet;
    }

    public void executeSQL(String codigo) {
        try {
            String sql = "select * from modalidade where idModalidade = " + codigo;
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void executeSQLModalidadeNome(String nome) {
        try {
            String sql = "select * from modalidade where nome like '%" + nome + "%' ORDER BY `idModalidade`";
            //String sql = "select * from modalidade WHERE idModalidade NOT IN (select idModalidade from matriculaModalidade where idCiente =)";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void getTodosModalidadeHorario() {
        try {
            String SQL = "SELECT  modalidade.`idModalidade`,`diaSemana`, `nome`,horaInicio, horaFim FROM horario, `modalidade` WHERE modalidade.`idModalidade`=horario.`idModalidade`";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    //Dados do cliente com sua modalidade
    public void ClienteModalidade(String codigo) {
        try {
            String sql = "select * from modalidade inner join matriculamodalidade on matriculamodalidade.idModalidade = modalidade.idModalidade inner join matricula\n"
                    + " on matriculamodalidade.idMatricula = matricula.idMatricula inner join pessoa on pessoa.idPessoa = matricula.idCliente WHERE pessoa.idPessoa = " + codigo;
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    //Preencher tabela modalidade
    public void getModalidades() {
        String SQL = "SELECT idModalidade, nome, valor FROM modalidade";
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    //Pegar o Dia da Semana
    public void codigoDiaSemana(String semana) {
        String SQL = "SELECT * FROM diasemana WHERE diasemana.nome='" + semana + "' ";
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    //Pesquisa dados Modalidade
    public void pesquisarModalidade(String SQL) {
        try {

            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
    }
}
