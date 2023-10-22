/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.DatabaseConnection;
import Models.TareaModel;
import Models.UsuarioModel;
import Services.SQLService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 000093883
 */
public class TareaController {

    DatabaseConnection dbConnection = DatabaseConnection.getInstance();
    Connection connection = dbConnection.getConnection();
    SQLService<TareaModel> sqlService = new SQLService<>(TareaModel.class);

    public List<TareaModel> getTareas() {
        String query = "Select * from tareas";
        List<TareaModel> list = new ArrayList<>();
        try {
            list = sqlService.DynamicGetListMethod(query, connection);
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public HashMap<String, Integer> getTareasMap() {
        HashMap<String, Integer> map = new HashMap<>();
        String query = "Select * from tareas";
        try {
            sqlService.DynamicGetListMethod(query, connection).forEach(x -> {
                map.put(x.getDescripcion(), x.getTareaID());
            });
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException | SQLException ex) {
        }
        return map;
    }

    public List<TareaModel> getTareasAsignadas(int empleadoID) {
        String query = "select t.Descripcion, a.FechaAsignacion as Fecha "
                + "from asignaciontareas as a "
                + "inner join Tareas as t "
                + "on a.TareaID = t.TareaID "
                + "where a.EmpleadoID = " + String.valueOf(empleadoID);
        List<TareaModel> list = new ArrayList<>();
        try {
            list = sqlService.DynamicGetListMethod(query, connection);
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean insertTareas(Object[] data) {
        String query = "Insert into tareas (Descripcion, Fecha, Estado, ColoniaID) values (?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            sqlService.Differentiate(pst, data);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean insertAsignacionTareas(int id, Object[] data) {
        String empleados = "Select EmpleadoID as UserID from jefesEmpleados where JefeID = " + String.valueOf(id);
        List<UsuarioModel> users = new ArrayList<>();
        try {
            SQLService<UsuarioModel> service = new SQLService<>(UsuarioModel.class);
            users = service.DynamicGetListMethod(empleados, connection);
        } catch (Exception ex) {

        }
        String query = "Insert into AsignacionTareas (TareaID, EmpleadoID, FechaAsignacion) values (?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            users.forEach(x -> {
                Object[] aux = new Object[]{
                    (int)data[0],
                    (int)x.getUserID(),
                    (Date)new Date()
                };
                try {
                    sqlService.Differentiate(pst, aux);
                    pst.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(TareaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
