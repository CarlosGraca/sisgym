/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Recibos;
import view.Login;

/**
 *
 * @author Carlos
 */
public class DAORecibo {
    PreparedStatement ps = null;
    Statement st = null;
    public ResultSet resultSet = null;
    Conexao con = Login.con;

    public boolean incluir(Recibos obj) throws SQLException {
        String SQL = "INSERT INTO `recibos`(`documento`, `numDoc`, `descricao`, `situacao`, `estado`, `idCliente`, `idUser`) VALUES (?,?,?,?,?,?,?)";

        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getDocumento());
        ps.setString(2, obj.getNumDoc());
        ps.setString(3, obj.getDescricao());
        ps.setString(4, obj.getSituacao());
        ps.setBoolean(5, obj.getEstado());
        ps.setInt(6, obj.getIdCliente());
        ps.setInt(7, obj.getIdUser());

        int registros = ps.executeUpdate();
        return registros > 0;
    }

    public boolean editar(Recibos obj) throws Exception {
        String SQL = "UPDATE `recibos` SET `situacao`=?,`estado`=? WHERE `numDoc` = ?";
        ps = con.getConexao().prepareStatement(SQL);
        ps.setString(1, obj.getSituacao());
        ps.setBoolean(2, obj.getEstado());
        ps.setString(3, obj.getNumDoc());

        int registros = ps.executeUpdate();
        return registros > 0;
    }
}
