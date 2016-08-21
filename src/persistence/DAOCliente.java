package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Matriculamodalidade;
import model.Modalidade;
import model.MPessoa;
import view.Login;
import static view.VEnviandoEmail.jComboBoxEmail;

public class DAOCliente {
    Conexao con = Login.con;
    //Conexao con;
    PreparedStatement ps = null;
    Statement st = null;    
    public ResultSet resultSet = null;
    public DAOCliente(){
        //con = new Conexao();
    }
   
    public boolean incluir(MPessoa obj) throws SQLException {
        String SQL = "insert into pessoa (nome,bi,telemovel,cp,morada,email,sexo,status,codBarra,profissao,obs,localTrab,"
                + "encaEdu,telfTrab,foto,dtNasc,dtreg,tipoPessoa,idFuncionario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);

        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getBi());
        ps.setString(3, obj.getTelemovel());
        ps.setString(4, obj.getCp());
        ps.setString(5, obj.getMorada());
        ps.setString(6, obj.getEmail());
        ps.setInt(7, obj.getSexo());
        ps.setInt(8, obj.getStatus());
        ps.setString(9, obj.getCodBarra());
        ps.setString(10, obj.getProfissao());
        ps.setString(11, obj.getObs());
        ps.setString(12, obj.getLocalTrab());
        ps.setString(13, obj.getEncaEdu());
        ps.setString(14, obj.getTelfTrab());
        ps.setBytes(15, obj.getFoto());
        ps.setDate(16, new java.sql.Date(obj.getDtNasc().getTime()));
        ps.setDate(17, new java.sql.Date(obj.getDtreg().getTime()));
        ps.setInt(18, obj.getTipoPessoa());
        ps.setInt(19, obj.getIdFuncionario());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public Modalidade pesquisar(JComboBox cmbBoxModalidade, String sql) throws SQLException {
        Modalidade obj = null;
        String SQL = sql;
        ps = con.getConexao().prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

        cmbBoxModalidade.removeAllItems();  // remove todos os itens do combom
        cmbBoxModalidade.addItem("Escolha..."); // adiciona o  Escolha no ComboBox 
        DefaultComboBoxModel comboBoxMode = (DefaultComboBoxModel) cmbBoxModalidade.getModel(); // cria um objeto que do tipo DefaultComboBoxModel 
        try {
            while (rs.next()) {
                String nome = rs.getString("nome");
                cmbBoxModalidade.addItem(nome);    // recebe os resultado da consulta 
            }
        } catch (SQLException ex) {
        }

        return obj;
    }

    public MPessoa pesquisarClienteComo(JComboBox cmbBoxCliente) throws SQLException {
        MPessoa obj = null;
        String SQL = "SELECT * FROM pessoa order by idPessoa";
        ps = con.getConexao().prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

        cmbBoxCliente.removeAllItems();  // remove todos os itens do combom
        cmbBoxCliente.addItem("Escolha..."); // adiciona o  Escolha no ComboBox 
        DefaultComboBoxModel comboBoxMode = (DefaultComboBoxModel) cmbBoxCliente.getModel(); // cria um objeto que do tipo DefaultComboBoxModel 
        try {
            while (rs.next()) {
                String nome = rs.getString("nome");
                cmbBoxCliente.addItem(nome);    // recebe os resultado da consulta 
            }
        } catch (SQLException ex) {
        }

        return obj;
    }

    public MPessoa pesquisarEmailComo(JComboBox cmbBoxEmail) throws SQLException {
        MPessoa obj = null;
        String SQL = "select email from pessoa where `email` != '' AND `email` LIKE '%@%'";
        ps = con.getConexao().prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

        jComboBoxEmail.removeAllItems();  // remove todos os itens do combom
        jComboBoxEmail.addItem("Escolha..."); // adiciona o  Escolha no ComboBox 
        DefaultComboBoxModel comboBoxMode = (DefaultComboBoxModel) jComboBoxEmail.getModel(); // cria um objeto que do tipo DefaultComboBoxModel 
        try {
            while (rs.next()) {
                String email = rs.getString("email");
                jComboBoxEmail.addItem(email);    // recebe os resultado da consulta 
            }
        } catch (SQLException ex) {
        }

        return obj;
    }

//    public Pessoa pesquisar(String idModalidade) throws SQLException {
//        Pessoa obj = null;
//        String SQL = "Select * from modalidade where idModalidade = " + idModalidade;
//        ps = con.getConexao().prepareStatement(SQL);
//
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//            obj = new Pessoa();
//            obj.setIdModalidade(rs.getInt("idModalidade"));
//            obj.setNome(rs.getString("nome"));
//            obj.setValor(rs.getDouble("valor"));
//        }
//        return obj;
//    }
//
    public boolean editar(MPessoa obj) throws Exception {
        String SQL = "Update pessoa set nome = ?, bi = ?,telemovel=?,cp=?,morada=?,email=?,sexo=?,status=?"
                + ",codBarra=?,profissao=?,obs=?,localTrab=?,encaEdu=?,telfTrab=?, foto =? where idPessoa = ? and tipoPessoa=0";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getBi());
        ps.setString(3, obj.getTelemovel());
        ps.setString(4, obj.getCp());
        ps.setString(5, obj.getMorada());
        ps.setString(6, obj.getEmail());
        ps.setInt(7, obj.getSexo());
        ps.setInt(8, obj.getStatus());
        ps.setString(9, obj.getCodBarra());
        ps.setString(10, obj.getProfissao());
        ps.setString(11, obj.getObs());
        ps.setString(12, obj.getLocalTrab());
        ps.setString(13, obj.getEncaEdu());
        ps.setString(14, obj.getTelfTrab());
        ps.setBytes(15, obj.getFoto());
        ps.setInt(16, obj.getIdPessoa());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean editarEstado(MPessoa obj) throws Exception {
        String SQL = "Update pessoa set status = 1 where idPessoa = ? ";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getIdPessoa());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean editarSemFoto(MPessoa obj) throws Exception {
        String SQL = "Update pessoa set nome = ?, bi = ?,telemovel=?,cp=?,morada=?,email=?,sexo=?,status=?"
                + ",profissao=?,obs=?,localTrab=?,encaEdu=?,telfTrab=? where idPessoa = ? and tipoPessoa=0";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getBi());
        ps.setString(3, obj.getTelemovel());
        ps.setString(4, obj.getCp());
        ps.setString(5, obj.getMorada());
        ps.setString(6, obj.getEmail());
        ps.setInt(7, obj.getSexo());
        ps.setInt(8, obj.getStatus());
        ps.setString(9, obj.getProfissao());
        ps.setString(10, obj.getObs());
        ps.setString(11, obj.getLocalTrab());
        ps.setString(12, obj.getEncaEdu());
        ps.setString(13, obj.getTelfTrab());
        ps.setInt(14, obj.getIdPessoa());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean excluir(MPessoa obj) throws SQLException {
        String SQL = "Delete from pessoa where idPessoa = ? and tipoPessoa=0";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getIdPessoa());
        int registros = ps.executeUpdate();
        return registros > 0;
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

    public void getTodosCliente() {
        String sql = "SELECT idPessoa,nome,bi,telemovel, cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo, if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto FROM pessoa where  tipoPessoa=0";
        execute_sql(sql);
    }

    public ResultSet getUtimoRegistro() {
        try {
            if(resultSet.isBeforeFirst()) {
            resultSet.last();
            }else{
                //JOptionPane.showMessageDialog(null, "Nenhum dado foi encontrado");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar ultimo cliente inserido" + ex.getMessage());
        }
        return resultSet;
    }

    public void executeSQL(String codigo) {
        String sql = "select * from pessoa where tipoPessoa=0 and idPessoa = " + codigo;
        execute_sql(sql);
    }

    public void executeSQLTodasPessoas(String nome) {
        String sql = "select * from pessoa where  nome like '%" + nome + "%'";
        execute_sql(sql);
    }

    public boolean excluirMatricula() throws SQLException {
        String SQL = "Delete from matricula where valorTotal = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, 0);

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean excluirMatriculaModalidade(Matriculamodalidade obj) throws SQLException {
        String SQL = "Delete from matriculamodalidade where idMatricula = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getMatricula());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public void executeSQLTodosMatriculaIgualZero() {

        String sql = "select matriculamodalidade.idMatricula as modMatricula from matricula inner join matriculamodalidade on "
                + "matricula.idMatricula = matriculamodalidade.idMatricula "
                + "inner join modalidade on modalidade.idModalidade = matriculamodalidade.idModalidade where valorTotal = 0";

        execute_sql(sql);
    }

    public void pesquisaPersonalizadoClientes(String campo, String pesquisa) {
        switch (campo) {
            case "Nome":
                String sql = "SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo, if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto FROM `pessoa` WHERE tipoPessoa=0 and `nome` LIKE '%" + pesquisa + "%' ORDER BY nome";
                execute_sql(sql);
                break;
            case "Codigo":
                String sql1 = "SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo, if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto FROM pessoa where  tipoPessoa=0 and idPessoa =" + pesquisa + "ORDER BY idPessoa";
                execute_sql(sql1);
                break;
        }
    }

}
