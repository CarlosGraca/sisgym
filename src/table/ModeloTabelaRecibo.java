/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistence.Conexao;
import view.Login;

/**
 *
 * @author Carlos
 */
public class ModeloTabelaRecibo {
    Conexao con = Login.con;
    public void linha_tabela(int numCol, int columBoolean, DefaultTableModel modelo, JTable table) {
        try {
            String query = "select p.nome, r.data , r.documento,r.numDoc, r.descricao, r.situacao, r.estado from recibos r, pessoa p"
                    + " where p.idPessoa = r.idCliente";
            ResultSet rs;
            rs = con.ejecutarSQLSelect(query);
            Object[] fila = new Object[numCol];
            while (rs.next()) {
                for (int i = 1; i <= numCol; i++) {
                    if (i == columBoolean) {
                        int estado  = rs.getInt("estado");
                        if (estado == 1)
                             fila[columBoolean - 1] = Boolean.TRUE;
                        else
                             fila[columBoolean - 1] = Boolean.FALSE;
                       
                    } else {
                        fila[i - 1] = rs.getObject(i - 1);
                    }
                }
                modelo.addRow(fila);
            }
            table.updateUI();
            rs.close();
        } catch (SQLException e) {
            System.out.println("");

        }
    }

    private ResultSet executeQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
