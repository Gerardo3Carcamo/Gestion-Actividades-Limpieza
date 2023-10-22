/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.TableModels;

import Models.TareaModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 000093883
 */
public class TareasPendientesTableModel extends AbstractTableModel {
    
    private final List<TareaModel> tareas;
    private final String[] columnNames = new String[]{"Descripcion", "Fecha"};
    
    public TareasPendientesTableModel(List<TareaModel> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return tareas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TareaModel p = tareas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getDescripcion();
            case 1:
                return p.getFecha();
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
