package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Pessoa;
import view.Login;
import model.Item;

public class DAOFuncionario {

    PreparedStatement ps = null;
    Statement st = null;
    Conexao con = Login.con;
    public ResultSet resultSet = null;

    public boolean incluir(Pessoa obj) throws SQLException {

        String SQL = "insert into pessoa (nome,bi,telemovel,cp,morada,email,sexo,status,codBarra,foto,dtNasc,dtreg,tipoPessoa) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
        ps.setBytes(10, obj.getFoto());
        ps.setDate(11, new java.sql.Date(obj.getDtNasc().getTime()));
        ps.setDate(12, new java.sql.Date(obj.getDtreg().getTime()));
        ps.setInt(13, obj.getTipoPessoa());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public Pessoa pesquisarFunComo(JComboBox cmbBoxFun,  String SQL, int flag) throws SQLException {
        Pessoa obj = null;
        
        ps = con.getConexao().prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

        cmbBoxFun.removeAllItems();  // remove todos os itens do combom
        cmbBoxFun.addItem("Selecione..."); // adiciona o  Escolha no ComboBox 
        DefaultComboBoxModel comboBoxMode = (DefaultComboBoxModel) cmbBoxFun.getModel(); // cria um objeto que do tipo DefaultComboBoxModel 
        try {
            while (rs.next()) {
                String nome = rs.getString("nome");
                int id = rs.getInt("idPessoa");
                if (flag == 1){
                    int idMatricula = rs.getInt("idMatricula");
                //Object[] itemData = new Object[] {id, nome};
                //cmbBoxFun.addItem(itemData);    // recebe os resultado da consulta 
                cmbBoxFun.addItem(new Item(id, nome, idMatricula));
                }else
                {
                   cmbBoxFun.addItem(new Item(id, nome));
                }
                
            }
        } catch (SQLException ex) {
        }

        return obj;
    }

    public boolean editar(Pessoa obj) throws Exception {
        String SQL = "Update pessoa set nome = ?, bi = ?,telemovel=?,cp=?,morada=?,email=?,sexo=?,status=?"
                + ",codBarra=?,dtNasc=?, foto =? where idPessoa = ? and tipoPessoa=1";
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
        ps.setDate(10, new java.sql.Date(obj.getDtNasc().getTime()));
        ps.setBytes(11, obj.getFoto());
        ps.setInt(12, obj.getIdPessoa());
       

        int registros = ps.executeUpdate();
        return registros > 0;
    }
    public boolean editarSemFoto(Pessoa obj) throws Exception {
        String SQL = "Update pessoa set nome = ?, bi = ?,telemovel=?,cp=?,morada=?,email=?,sexo=?,status=?"
                + ",codBarra=?,dtNasc=? where idPessoa = ? and tipoPessoa=1";
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
        ps.setDate(10, new java.sql.Date(obj.getDtNasc().getTime()));
        ps.setInt(11, obj.getIdPessoa());
        

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean excluir(Pessoa obj) throws SQLException {

        String SQL = "Delete from pessoa where idPessoa = ? and tipoPessoa=1";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setInt(1, obj.getIdPessoa());

        int registros = ps.executeUpdate();
        return registros > 0;

    }

    public void getTodosFuncionario() {
        try {
            String SQL = "SELECT idPessoa,nome,bi,telemovel,cp,morada,email,if(sexo=1, \"Masculino\", \"Feminino\") AS Sexo, if(status=0, \"Inativo\", \"Ativo\") As Estado,profissao,obs,localTrab,encaEdu,telfTrab,foto FROM pessoa where  tipoPessoa=1";
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum dado do funcionario foi encontrado" + ex.getMessage());
        }
    }
//
////    public ResultSet getUtimoRegistro() {
////        try {
////            resultSet.last();
////        } catch (SQLException ex) {
////            Logger.getLogger(DAOEquipamento.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        return resultSet;
////    }
////
    public void executeSQL(String codigo) {
        try {
            String sql = "select * from pessoa where tipoPessoa=1 and idPessoa = " + codigo;
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }
//    public void pesquisaPersonalizadoClientes(String campo, String pesquisa) {
//        String sql = "";
//        switch (campo) {
//            case "Nome":
//                sql = "SELECT * FROM `pessoa` WHERE `nome` LIKE '%"+pesquisa+"%' ORDER BY nome";
//                break;
//            case "Codigo":
//                sql ="select * from pessoa where idPessoa ="+pesquisa+"ORDER BY idPessoa";
//                break;
//        }
//        try {
//            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
//            resultSet = st.executeQuery(sql);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
//        }
//    }
    
    public void pesquisarFuncionario(String SQL) {
        try {
            
            st = con.getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = st.executeQuery(SQL);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
    }
    
}
