
package table;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;


public class ModeloTabelaPresenca extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetLog;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Cliente","Data","Hora"
    };
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaPresenca(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }
    
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetLog = new ArrayList<String[]>();
        resultset.beforeFirst();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("nomeCliente"),
                resultset.getString("data"),
                resultset.getString("horaEntrada")
            };
            resultSetLog.add(linha);
        }
        fireTableStructureChanged();
    }
    public void deletarLinha(int linha) {
        resultSetLog.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }
    
//  public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
//       Component component = super.prepareRenderer(renderer, row, column);
//       if(!isRowSelected(row)){
//           component.setBackground(getBackground());
//           int linha = convertRowIndexToModel(row);
//       }
//        return component;
//      
//  }

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
