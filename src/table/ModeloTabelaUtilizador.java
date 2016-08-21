
package table;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public final class ModeloTabelaUtilizador extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetUtilizador;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Código", "Nome", "Login",  "Última Visita", "Tipo Utilizador","Estado"
    };
    @Override
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaUtilizador(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }
    
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetUtilizador = new ArrayList<>();
        resultset.beforeFirst();
        
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("ut_idUtilizador"),
                resultset.getString("ut_nome"),
                resultset.getString("ut_login"),    
                resultset.getString("ut_dtUltimaVisita"),
                 resultset.getString("designacao"),
                resultset.getString("Estado"),
                
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
