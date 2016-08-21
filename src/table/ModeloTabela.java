/*
 * Direitos reservados para Neri Aldoir Neitzke
 * www.informaticon.com.br 
 */ 

package table;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

/**
 * @author Neri Aldoir Neitke
 * Autor de 4.600 videoaulas - Palestrante Internacional
 */
public class ModeloTabela extends AbstractTableModel {
    private int colunas, linhas;
    private ResultSet resultset;
    private ResultSetMetaData rsMetaData;
    
    public ModeloTabela(ResultSet resultset) throws SQLException {
        rsMetaData = resultset.getMetaData();
        this.resultset = resultset;
        //select * from bairro
        resultset.last();//fui para o ultimo registro
        linhas = resultset.getRow();//pega o numero da linha em que se econtra
        
        //acionar alteracao de estrutura no JTable
        fireTableStructureChanged();
    }
    public String getColumnName(int column) {
       try {
           return rsMetaData.getColumnName(column+1);
       }
       catch(SQLException erro) {
           return "";           
       }
    }
    
    @Override
    public int getRowCount() {
        return linhas;
    }

    @Override
    //codigo, nome, fone, email
    public int getColumnCount() {
       colunas = 0;
       try {
           colunas = rsMetaData.getColumnCount();
       }
       catch(SQLException erro) {
           System.out.println("Erro ao ler  Quantas Colunas : "+erro);
       }
       return colunas;
    }
    //povoar JTable
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            resultset.absolute(rowIndex+1);
            return resultset.getObject(columnIndex+1);
        }
        catch(SQLException erro) {
            System.out.println("Erro "+erro);
            return "";
        }        
    }


}



