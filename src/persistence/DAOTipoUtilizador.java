package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import model.Tipoutilizador;
import view.Login;

public class DAOTipoUtilizador {
      Conexao con = Login.con;
      public boolean incluir(Tipoutilizador obj) throws SQLException{ 
        String SQL ="insert into tipoutilizador (designacao, permissao) values(?,?)";
        
        PreparedStatement  ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getDesignacao());
        ps.setString(2, obj.getPermissao());
      
        int registros = ps.executeUpdate();
          return registros > 0;
    }
    
  public Tipoutilizador pesquisar(JComboBox cmbBoxTipoUtilizador) throws SQLException{
        Tipoutilizador obj = null;
        String SQL = "select * from tipoutilizador order by idTipoutilizador";
        PreparedStatement ps = con.getConexao().prepareStatement(SQL);
       
        
        ResultSet rs = ps.executeQuery();     
        
        cmbBoxTipoUtilizador.removeAllItems();  // remove todos os itens do combom
        cmbBoxTipoUtilizador.addItem("Escolha..."); // adiciona o  Escolha no ComboBox 
        DefaultComboBoxModel comboBoxMode = (DefaultComboBoxModel) cmbBoxTipoUtilizador.getModel(); // cria um objeto que do tipo DefaultComboBoxModel 
        try{
            while(rs.next()){
                String nome = rs.getString("designacao");
                cmbBoxTipoUtilizador.addItem(nome);    // recebe os resultado da consulta 
            }
        }catch(SQLException ex){
        }
             
        return obj;
    }
  
    /*
    public boolean editar(Tipoutilizador obj) throws Exception{
        Conexao con = new Conexao();
        String SQL = "Update empresa set nome = ?, nif = ?,Telefone = ?, telemovel = ?"
                + ",localizacao = ?, cp = ?, email = ?, logo = ?";
        PreparedStatement ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setInt(2, obj.getNif());
        
        
        int registros = ps.executeUpdate();
          return registros > 0;
    }
    
    public boolean excluir(String sigla) throws SQLException{
        Conexao con = new Conexao();
        String SQL = "Delete from faculdades where sigla = ?";
        
        PreparedStatement ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, sigla);
        
        int registros = ps.executeUpdate();
        if(registros > 0)               
            return true;
        else
            return false;
    }*/
}
