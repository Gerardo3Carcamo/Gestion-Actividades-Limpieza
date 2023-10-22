/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.DatabaseConnection;
import Models.UsuarioModel;
import Services.SQLService;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 000093883
 */
public class UsuarioController {

    DatabaseConnection dbConnection = DatabaseConnection.getInstance();
    Connection connection = dbConnection.getConnection();
    SQLService<UsuarioModel> sqlService = new SQLService<>(UsuarioModel.class);

    public UsuarioModel getUser(Object[] data) {
        String query = "Select * from Usuarios where Email = '" + data[0] + "' and Pass = '" + data[1] + "'";
        UsuarioModel user = null;
        try {
            user = sqlService.DynamicGetListMethod(query, connection).get(0);
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IndexOutOfBoundsException ex) {

        }
        return user;
    }

    public boolean insertUser(Object[] data) {
        String query = "Insert into usuarios (Nombre, Email, Telefono, Pass, RoleID) values (?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            sqlService.Differentiate(pst, data);
            pst.executeUpdate();
            String id = "Select max(UserID) from usuarios";
            pst = connection.prepareStatement(id);
            ResultSet result = pst.executeQuery();
            int userID = 0;
            if (result.next()) {
                userID = result.getInt(1);
            }
            if ((int)data[4] == 1 || (int)data[4] == 2) {
                String jefes = "insert into jefes values(?)";
                pst = connection.prepareStatement(jefes);
                sqlService.Differentiate(pst, new Object[]{userID});
                pst.executeUpdate();
            } else {
                String empleados = "insert into empleados (empleadoID) values(?)";
                pst = connection.prepareStatement(empleados);
                sqlService.Differentiate(pst, new Object[]{userID});
                pst.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public List<UsuarioModel> getUsers() {
        String query = "Select * from Usuarios";
        List<UsuarioModel> list = new ArrayList<>();
        try {
            list = sqlService.DynamicGetListMethod(query, connection);
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean updateUser(int id, Object[] data) {
        String query = "Update Usuarios set Nombre = ?, Email = ?, Telefono = ?, Pass = ?, RoleID = ? where UserID = " + String.valueOf(id);
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            sqlService.Differentiate(pst, data);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String query = "Delete from Usuarios where UserID = " + String.valueOf(id);
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public HashMap<String, Integer> getAdminUsersMap() {
        HashMap<String, Integer> map = new HashMap<>();
        String query = "Select * from usuarios where RoleID = 1 or RoleID = 2";
        try {
            sqlService.DynamicGetListMethod(query, connection).forEach(x -> {
                map.put(x.getNombre(), x.getUserID());
            });
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException | SQLException ex) {
        }
        return map;
    }

    public HashMap<String, Integer> getUsersMap() {
        HashMap<String, Integer> map = new HashMap<>();
        String query = "Select * from usuarios where RoleID = 3";
        try {
            sqlService.DynamicGetListMethod(query, connection).forEach(x -> {
                map.put(x.getNombre(), x.getUserID());
            });
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException | SQLException ex) {
        }
        return map;
    }
    
    public boolean assignEmployees(Object[] data){
        String query = "Insert into jefesempleados values(?,?)";
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            sqlService.Differentiate(pst, data);
            pst.executeUpdate();
            
        }catch(SQLException ex){
            
        }
        String queryUpdate = "Update empleados set JefeID = ?";
        try{
            PreparedStatement pst = connection.prepareStatement(queryUpdate);
            sqlService.Differentiate(pst, data);
            pst.executeUpdate();
            return true;
        }catch(SQLException ex){
           return false; 
        }
        
    }
    
    public List<UsuarioModel> getCuadrilla(UsuarioModel user){
        String query = "SELECT u.* FROM gestion.jefesempleados as j " +
                        "inner join empleados as e " +
                        "on j.EmpleadoID = e.EmpleadoID " +
                        "inner join usuarios as u " +
                        "on e.EmpleadoID = u.UserID "
                + "where j.JefeID = " + user.getUserID();
        List<UsuarioModel> list = new ArrayList<>();
        try {
            list = sqlService.DynamicGetListMethod(query, connection);
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
