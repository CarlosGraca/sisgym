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


public class ModeloTabelaVenda extends AbstractTableModel {

    private int numLinhas;
    private ArrayList<String[]> resultSetCliente;
    private ResultSetMetaData rsMetaData;
    private static final String[] nomesColunas = {
        "Codigo","Produto","Data Venda","Valor da Venda","Quantidade","Cliente"
    };
    public String getColumnName(int quantasColunas) {
        return nomesColunas[quantasColunas];
    }

    public ModeloTabelaVenda(ResultSet resultset) throws SQLException {
        setResult(resultset);
    }
    
    public void setResult(ResultSet resultset) throws SQLException {
        resultSetCliente = new ArrayList<String[]>();
        resultset.beforeFirst();
        while (resultset.next()) {
            String[] linha = { 
                resultset.getString("ven_id"),
                resultset.getString("nome_produto"),               
                resultset.getString("ven_data"),
                resultset.getString("ven_valor"),
                resultset.getString("quantidade_produto"),
                resultset.getString("nome_pessoa"),
               
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
