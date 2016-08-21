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
public class ModeloTabelaHorario extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetModalidade;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Código", "Modalidade", "Dia Semana", "Hora Ínicio", "Hora Fim"
    };

    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaHorario(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }

    public void setResult(ResultSet resultset) throws SQLException {
        resultSetModalidade = new ArrayList<String[]>();
        resultset.beforeFirst();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("idHorario"),
                resultset.getString("nome"),
                resultset.getString("semana"),
                resultset.getString("horaInicio"),
                resultset.getString("horaFim"),};
            resultSetModalidade.add(linha);
        }
        fireTableStructureChanged();
    }

    public void deletarLinha(int linha) {
        resultSetModalidade.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }

    @Override
    public int getRowCount() {
        return resultSetModalidade.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = resultSetModalidade.get(rowIndex);
        return linha[columnIndex];
    }

}
