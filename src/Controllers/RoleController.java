/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.DatabaseConnection;
import Models.RoleModel;
import Services.SQLService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author 000093883
 */
public class RoleController {
    
    DatabaseConnection dbConnection = DatabaseConnection.getInstance();
    Connection connection = dbConnection.getConnection();
    SQLService<RoleModel> sqlService = new SQLService<>(RoleModel.class);
    
    public HashMap<String, Integer> getRoles(){
        HashMap<String, Integer> map = new HashMap<>();
        String query = "Select * from Roles";
        try{
            sqlService.DynamicGetListMethod(query, connection).forEach(x ->{
                map.put(x.getNombreRol(), x.getRoleID());
            });
        }catch(IllegalAccessException | InstantiationException | NoSuchFieldException | SQLException ex){
        }
        return map;
    }
    
}
