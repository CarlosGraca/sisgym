package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Acessosistema;
import view.Login;

public class DAOLog {

    Conexao con = Login.con;
    PreparedStatement ps = null;
    Statement st = null;
    public ResultSet resultSet = null;


    public boolean incluir(Acessosistema obj) throws SQLException {
        String SQL = "INSERT INTO acessosistema(login,hora, acao, data) VALUES (?,?,?,?)";
        ps = con.getConexao().prepareStatement(SQL);

        ps.setInt(1, obj.getLogin());
        ps.setString(2, obj.getHoraEntrada());
        ps.setString(3, obj.getAcao());
        ps.setDate(4, new java.sql.Date(obj.getData().getTime()));

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public void getTodosLog(Date dataHoje) {
        try {
            String SQL = "SELECT data, hora, acao, ut_nome FROM acessosistema, utilizador WHERE login = ut_IdUtilizador  ORDER BY data DESC, hora ASC";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public Pagamento pesquisar(String codBarra) throws SQLException {
     Pagamento obj = null;
     Pessoa obj1;
     String SQL = "SELECT codBarra, dataValidade, nome FROM `pagamento`, `pessoa` WHERE codBarra like ? AND `pagamento`.`idCliente`= Pessoa.`idPessoa`";
     ps = con.getConexao().prepareStatement(SQL);
     ps.setString(1, codBarra);

     ResultSet rs = ps.executeQuery();

     if (rs.next()) {
     obj = new Pagamento();
     obj1 = new Pessoa();
     obj1.setCodBarra(rs.getString("codBarra"));
     obj1.setNome(rs.getString("nome"));
     obj.setDataValidade(rs.getDate("dataValidade"));
     }
     return  obj;
     }
     public boolean editar(Pagamento obj) throws Exception {
     String SQL = "Update pagamento set idPagamento = ?, diaSemana = ?, horaInicio = ?"
     + ", horaFim = ?  where idHorario = ?";
     ps.setInt(1, obj.getIdFuncionario());
     ps.setInt(2, obj.getIdCliente());
     ps.setString(3, obj.getTipo());
     ps.setTimestamp(4, new java.sql.Timestamp(obj.getData().getTime()));
     ps.setTimestamp(5, new java.sql.Timestamp(obj.getDataValidade().getTime()));
     ps.setString(6, obj.getObs());
     ps.setString(7, obj.getDescricao());
     ps.setString(8, obj.getCodPagamento());
     ps.setBoolean(9, obj.getEstado());
     int registros = ps.executeUpdate();
     return registros > 0;
     }

     public boolean excluir(Pagamento obj) throws SQLException {
     String SQL = "UPDATE `pagamento` SET `obs` = 'Pagamento cancelado', `dataValidade` = ?, `estado`= 0 WHERE `idPagamento` = ? ";
     ps = con.getConexao().prepareStatement(SQL);
     ps.setInt(1, obj.getIdPagamento());
     ps.setDate(2, new java.sql.Date(obj.getDataValidade().getTime()));

     int registros = ps.executeUpdate();
     return registros > 0;
     }
    
     public void getTodosPagamento(Date dtValidade) {
     try {
     String SQL = "SELECT `idPagamento`,`nome`,`descricao`,`data`,`dataValidade` FROM `pagamento`, `pessoa` WHERE `idCliente`= `pessoa`.idPessoa"
     + " and dataValidade > '"+dtValidade+"'" ;

     st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

     resultSet = st.executeQuery(SQL);
     } catch (SQLException ex) {
     Logger.getLogger(DAOLog.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
   
     public ResultSet getUtimoPagamento() {
     try {
     resultSet.last();
     } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null,"Erro ao selecionar ultimo pagamento "+ ex.getMessage());
     }
     return resultSet;
     }
     public void getTodosPagamentoFiltroId(String codigoLinha) {
     try {
     String SQL = "SELECT * FROM `pagamento` where idPagamento ="+codigoLinha;

     st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

     resultSet = st.executeQuery(SQL);
     } catch (SQLException ex) {
     Logger.getLogger(DAOLog.class.getName()).log(Level.SEVERE, null, ex);
     }
     }*/
    public void pegarData() {
        String SQL = "SELECT data FROM acessosistema LIMIT 1";
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void pegarDias() {
        String SQL = "select diaVenc from licenca ";
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}
