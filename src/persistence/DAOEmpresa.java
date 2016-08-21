package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Empresa;
import view.Login;

public class DAOEmpresa {
      Conexao con = Login.con;
      public  DAOEmpresa(){
      }
      public boolean incluir(Empresa obj) throws SQLException{         
        String SQL ="insert into empresa (nome,nif,telefone,telemovel,localizacao,cp,email,logo) values(?,?,?,?,?,?,?,?)";
        
        PreparedStatement  ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setInt(2, obj.getNif());
        ps.setString(3, obj.getTelefone());
        ps.setString(4, obj.getTelemovel());
        ps.setString(5, obj.getLocalizacao());
        ps.setInt(6, obj.getCp());
        ps.setString(7, obj.getEmail());
        ps.setBytes(8, obj.getLogo());
        int registros = ps.executeUpdate();
          return registros > 0;
    }
    
  public Empresa pesquisar() throws SQLException{
        Empresa obj = null;
        String SQL = "Select * from Empresa ";
        PreparedStatement ps = con.getConexao().prepareStatement(SQL);
       // ps.setString(1, sigla);
        
        ResultSet rs = ps.executeQuery();        
        if(rs.next()){
            obj = new Empresa();
            obj.setNome(rs.getString("nome"));
            obj.setNif(rs.getInt("nif"));            
            obj.setTelefone(rs.getString("telefone"));
            obj.setTelemovel(rs.getString("telemovel"));
            obj.setCp(rs.getInt("cp"));            
            obj.setEmail(rs.getString("email"));
            obj.setLocalizacao(rs.getString("localizacao"));
            obj.setLogo(rs.getBytes("logo"));
        }
        return obj;
    }
    
    public boolean editar(Empresa obj) throws Exception{
        String SQL = "Update empresa set nome = ?, nif = ?,Telefone = ?, telemovel = ?"
                + ",localizacao = ?, cp = ?, email = ?, logo = ?";
        PreparedStatement ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getNome());
        ps.setInt(2, obj.getNif());
        ps.setString(3, obj.getTelefone());
        ps.setString(4, obj.getTelemovel());
        ps.setString(5, obj.getLocalizacao());
        ps.setInt(6, obj.getCp());
        ps.setString(7, obj.getEmail());
        ps.setBytes(8, obj.getLogo());
        
        int registros = ps.executeUpdate();
          return registros > 0;
    }
    
    /*public boolean excluir(String sigla) throws SQLException{
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
