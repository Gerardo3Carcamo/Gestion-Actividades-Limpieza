/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.TableModels;

import Models.ColoniaModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 000093883
 */
public class ColoniaTableModel extends AbstractTableModel {
    
    private final List<ColoniaModel> colonia;
    private final String[] columnNames = new String[]{"Nombre", "CodigoPostal"};
    
    public ColoniaTableModel(List<ColoniaModel> colonia) {
        this.colonia = colonia;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return colonia.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ColoniaModel c = colonia.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getNombre();
            case 1:
                return c.getCodigoPostal();
            default:
                return null;
        }
    }

    // Opcional: Si quieres que las celdas no sean editables
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
