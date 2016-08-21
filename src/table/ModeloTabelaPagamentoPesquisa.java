package table;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class ModeloTabelaPagamentoPesquisa extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetPagamento;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Pagamento", "Cliente", "Matricula", "Valor Total", "Data Pagamento", "Data Validade", "Tipo Pagamento", "Estado"
    };

    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaPagamentoPesquisa(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }

    public void setResult(ResultSet resultset) throws SQLException {
        resultSetPagamento = new ArrayList<String[]>();
        resultset.beforeFirst();
        while (resultset.next()) {
            String[] linha = {
                resultset.getString("idPagamento"),
                resultset.getString("nome"),
                resultset.getString("idControlPagamento"),
                resultset.getString("valorTotal"),
                resultset.getString("DataPagamento"),
                resultset.getString("DataValidade"),
                resultset.getString("TipoPagamento"),
                resultset.getString("Estado")
            };
            resultSetPagamento.add(linha);
        }
        fireTableStructureChanged();
    }

    public void deletarLinha(int linha) {
        resultSetPagamento.remove(linha);
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
        return resultSetPagamento.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = resultSetPagamento.get(rowIndex);
        return linha[columnIndex];
    }

}
