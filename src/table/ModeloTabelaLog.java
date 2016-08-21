package table;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaLog extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetLog;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Funcionário", "Data", "Hora", "Atividade"
    };

    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaLog(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }

    public void setResult(ResultSet resultset) throws SQLException {
        resultSetLog = new ArrayList<String[]>();
        resultset.beforeFirst();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("ut_nome"),
                resultset.getString("data"),
                resultset.getString("hora"),
                resultset.getString("acao")
            };
            resultSetLog.add(linha);
        }
        fireTableStructureChanged();
    }

    public void deletarLinha(int linha) {
        resultSetLog.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }

    @Override
    public int getRowCount() {
        return resultSetLog.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = resultSetLog.get(rowIndex);
        return linha[columnIndex];
    }

}
