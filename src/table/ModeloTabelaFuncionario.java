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
public class ModeloTabelaFuncionario extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetFuncionario;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Codigo", "Nome","Telemovel","Morada","Sexo","Estado"
    };
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaFuncionario(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }
    
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetFuncionario = new ArrayList<String[]>();
        resultset.beforeFirst();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("idPessoa"),
                resultset.getString("nome"),
                resultset.getString("telemovel"),
                resultset.getString("morada"),
                resultset.getString("Sexo"),
                resultset.getString("Estado"),
            };
            resultSetFuncionario.add(linha);
        }
        fireTableStructureChanged();
    }
    public void deletarLinha(int linha) {
        resultSetFuncionario.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
            

    @Override
    public int getRowCount() {
        return resultSetFuncionario.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = resultSetFuncionario.get(rowIndex);
        return linha[columnIndex];
    }
    
}
