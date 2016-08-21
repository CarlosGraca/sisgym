
package table;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public final class ModeloTabelaNivelAcesso extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetUtilizador;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Código","Utlizador", "Menu"
    };
    @Override
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaNivelAcesso(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }
    
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetUtilizador = new ArrayList<>();
        resultset.beforeFirst();
        
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("id"),
                resultset.getString("ni_Cod_Utilizador"),
                resultset.getString("ni_menu"),
                
            };
            resultSetUtilizador.add(linha);
        }
        fireTableStructureChanged();
    }
    public void deletarLinha(int linha) {
        resultSetUtilizador.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
            

    @Override
    public int getRowCount() {
        return resultSetUtilizador.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = resultSetUtilizador.get(rowIndex);
        return linha[columnIndex];
    }
    
}
