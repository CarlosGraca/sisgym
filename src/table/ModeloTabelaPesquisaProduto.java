/*
 * Direitos reservados para Neri Aldoir Neitzke
 * www.informaticon.com.br 
 */
package table;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @author Neri Aldoir Neitke Autor de 4.600 videoaulas - Palestrante
 * Internacional
 */
public class ModeloTabelaPesquisaProduto extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetCliente;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Codigo", "Nome"
    };
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaPesquisaProduto(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }
    
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetCliente = new ArrayList<String[]>();
        resultset.beforeFirst();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("idProduto"),
                resultset.getString("nome"),               
            };
            resultSetCliente.add(linha);
        }
        fireTableStructureChanged();
    }
    public void deletarLinha(int linha) {
        resultSetCliente.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
            

    @Override
    public int getRowCount() {
        return resultSetCliente.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = resultSetCliente.get(rowIndex);
        return linha[columnIndex];
    }
    
}
