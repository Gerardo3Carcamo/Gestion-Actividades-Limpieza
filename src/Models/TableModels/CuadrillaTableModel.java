/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.TableModels;

import Models.TareaModel;
import Models.UsuarioModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 000093883
 */
public class CuadrillaTableModel extends AbstractTableModel {
    
    private final List<UsuarioModel> usuarios;
    private final String[] columnNames = new String[]{"UserID", "Nombre", "Email", "Telefono"};
    
    public CuadrillaTableModel(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UsuarioModel p = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getUserID();
            case 1:
                return p.getNombre();
            case 2:
                return p.getEmail();
            case 3:
                return p.getTelefono();
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
