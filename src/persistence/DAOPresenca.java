package persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Acessogym;
import view.Login;
public class DAOPresenca {

    Conexao con = Login.con;
    PreparedStatement ps = null;
    Statement st = null;
    public ResultSet resultSet = null;

    public DAOPresenca() {
    }

    public boolean incluir(Acessogym obj) throws SQLException {
        String SQL = "INSERT INTO `acessogym`(`horaEntrada`,  `idCliente`, `data`) VALUES (?,?,?)";
        ps = con.getConexao().prepareStatement(SQL);

        ps.setString(1, obj.getHoraEntrada());
        ps.setInt(2, obj.getIdCliente());
        ps.setDate(3, new java.sql.Date(obj.getData().getTime()));

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public void getTodosAcessogym(Date dataHoje) {
        try {
            String SQL = "select pessoa.nome as nomeCliente, acessogym.data as data, acessogym.horaEntrada as horaEntrada from acessogym, pessoa where idCliente = pessoa.idPessoa AND acessogym.data =  '"+dataHoje+"'";

            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: ao selecionar todas as prensenca : "+ ex.getMessage());
        }
    }

    public boolean verificaPresenca(Date dataHoje, String codBarra){
        try {
            String SQL = "select pessoa.idPessoa as idCliente from pagamento inner join pessoa on pagamento.idCliente = pessoa.idPessoa "
                    + "where dataValidade >= '" + dataHoje + "' AND codBarra = '" + codBarra + "'";
            
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            resultSet = st.executeQuery(SQL);
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: ao verificar presenca: "+ ex.getMessage());
        }    
        return false;
    }
    
    public boolean verificaTipoPessoa(String codBarra){
        try {
            String SQL = "select * from pessoa where codBarra = '"+codBarra+"' and tipoPessoa=1";
            
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            resultSet = st.executeQuery(SQL);
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: ao verificar tipo pessoa: "+ ex.getMessage());
        }    
        return false;
    }
}