package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pagamento;
import model.Pessoa;
import view.Login;

public class DAOPagamento {

    Conexao con = Login.con;
    PreparedStatement ps = null;
    Statement st = null;
    public ResultSet resultSet = null;

    public DAOPagamento() {
    }

    public boolean incluir(Pagamento obj) throws SQLException {
        String SQL = "INSERT INTO pagamento (idFuncionario, idCliente, tipo, data,dataValidade,obs,descricao, codPagamento, estado,idControlPagamento, idMes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.getConexao().prepareStatement(SQL);

        ps.setInt(1, obj.getIdFuncionario());
        ps.setInt(2, obj.getIdCliente());

        ps.setString(3, obj.getTipo());
        ps.setTimestamp(4, new java.sql.Timestamp(obj.getData().getTime()));
        ps.setTimestamp(5, new java.sql.Timestamp(obj.getDataValidade().getTime()));
        ps.setString(6, obj.getObs());
        ps.setString(7, obj.getDescricao());
        ps.setString(8, obj.getCodPagamento());
        ps.setBoolean(9, obj.getEstado());
        ps.setInt(10, obj.getIdControlPagamento());
        ps.setInt(11, obj.getIdMes());
        

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public Pagamento pesquisar(String codBarra) throws SQLException {
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
        return obj;
    }

    public boolean Editar(Pagamento obj) throws Exception {
        String SQL = "UPDATE `pagamento` SET obs = ?, `idFuncionario` = ?, idCliente=?, `estado` = ?, tipo = ?, descricao = ? WHERE `idPagamento` = ? ";
        ps = con.getConexao().prepareStatement(SQL);

        ps.setString(1, obj.getObs());
        ps.setInt(2, obj.getIdFuncionario());
        ps.setInt(3, obj.getIdCliente());
        ps.setBoolean(4, obj.getEstado());
        ps.setString(5, obj.getTipo());
        ps.setString(6, obj.getDescricao());
        ps.setInt(7, obj.getIdPagamento());
        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean Upadate(Pagamento obj) throws SQLException {
        String SQL = "UPDATE `pagamento` SET obs = ?, `dataValidade` = ?, `estado` = ? WHERE `idPagamento` = ? ";
        ps = con.getConexao().prepareStatement(SQL);

        ps.setString(1, obj.getObs());
        ps.setDate(2, new java.sql.Date(obj.getDataValidade().getTime()));
        ps.setBoolean(3, obj.getEstado());
        ps.setInt(4, obj.getIdPagamento());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean UpadateEstado(Date dtValidade) throws SQLException {
        String SQL = "UPDATE `pagamento` SET  `estado` = 0 WHERE `dataValidade` <= '" + dtValidade + "' ";
        ps = con.getConexao().prepareStatement(SQL);

        int registros = ps.executeUpdate();
        return registros > 0;
    }
    
    public void getTodosPagamento(Date dtValidade) {
        //try {
            String SQL = "SELECT a.`idPagamento`,`nome`,a.`descricao`,b.`descricao` mes,`data`,`dataValidade` FROM `pagamento` a, `pessoa`,`mes` b WHERE `idCliente`= `pessoa`.idPessoa "
                    + "and idMes = id and dataValidade >  '"+dtValidade+"'";
            //JOptionPane.showMessageDialog(null, dtValidade);
            //JOptionPane.showMessageDialog(null, SQL);
            System.out.println("sql :: "+SQL);
            execute_sql(SQL);
            /*st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public int getValorPagamento(int idMatricula, int idCliente) {
        int valor = 0;
        String sql = "select valorTotal from matricula where idMatricula = '"+idMatricula+"' and idCliente = '"+idCliente+"'";
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
            if (resultSet.next()) {
                valor = resultSet.getInt("valorTotal");
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum dado foi encontrado " + ex.getMessage());
        }
        
        return valor;        
    }
   public void execute_sql(String sql) {
        try {
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum dado foi encontrado" + ex.getMessage());
        }

    }
    public void getTodosPagamento() {
        try {
            String SQL = "SELECT * FROM `pagamento`";

            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar todos pagamento " + ex.getMessage());
        }
    }

    public ResultSet getUtimoPagamento() {
        try {
            if(resultSet.isBeforeFirst())
                resultSet.last();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar ultimo pagamento " + ex.getMessage());
        }
        return resultSet;
    }

    public void getTodosPagamentoFiltroId(String codigoLinha) {
        try {
            String SQL = "SELECT * FROM `pagamento` where idPagamento =" + codigoLinha;

            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getTodosPagamentoFiltroIdCompleto(String codigoLinha) {
        try {
            String SQL = "SELECT * FROM `pagamento` inner join matricula on "
                    + "matricula.idCliente = pagamento.idCliente inner join pessoa "
                    + "on pessoa.idPessoa = pagamento.idCliente where idPagamento =" + codigoLinha;

            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Pesquisa de Cliente (Pagamento)
    public void pesquisaClientePagamento(String pesq) {
        try {
            String SQL = "select `idPagamento`, pessoa.nome AS nome, idControlPagamento, pagamento.idCliente, matricula.valorTotal,pagamento.data AS 'DataPagamento', pagamento.dataValidade AS 'DataValidade', pagamento.descricao AS 'TipoPagamento', \n"
                    + "if(pagamento.estado = 1, 'Activo','Inactivo' ) AS 'Estado'\n"
                    + "from pagamento inner join matricula on pagamento.idControlPagamento = matricula.idMatricula inner join pessoa on pagamento.idCliente = pessoa.idPessoa\n"
                    + "where  pessoa.nome LIKE '%" + pesq + "%'";

            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "#Error: P01 - Filtragem de dados na tabela :" + ex.getMessage());
        }

    }

    public void pesquisaClientePagamentoId(String pesq) {
        try {
            String SQL = "select `idPagamento`, pessoa.nome, idControlPagamento, pagamento.idCliente, matricula.valorTotal,pagamento.data AS 'DataPagamento', pagamento.dataValidade AS 'DataValidade', pagamento.descricao AS 'TipoPagamento', \n"
                    + "if(pagamento.estado = 1, 'Activo','Inactivo' ) AS 'Estado'\n"
                    + "from pagamento inner join matricula on pagamento.idControlPagamento = matricula.idMatricula inner join pessoa on pagamento.idCliente = pessoa.idPessoa\n"
                    + "where  idPagamento=" + pesq;

            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "#Error: P01 - Filtragem de dados na tabela :" + ex.getMessage());
        }

    }
}
