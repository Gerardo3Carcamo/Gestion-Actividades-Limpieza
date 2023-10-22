/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.DatabaseConnection;
import Models.ColoniaModel;
import Services.SQLService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 000093883
 */
public class ColoniaController {
    
    DatabaseConnection dbConnection = DatabaseConnection.getInstance();
    Connection connection = dbConnection.getConnection();
    SQLService<ColoniaModel> sqlService = new SQLService<>(ColoniaModel.class);
    
    public List<ColoniaModel> getColonias(){
        String query = "Select * from Colonias";
        List<ColoniaModel> list = new ArrayList<>();
        try{
            list = sqlService.DynamicGetListMethod(query, connection);
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public HashMap<String, Integer> getColoniasMap(){
        HashMap<String, Integer> map = new HashMap<>();
        String query = "Select * from colonias";
        try{
            sqlService.DynamicGetListMethod(query, connection).forEach(x ->{
                map.put(x.getNombre(), x.getColoniaID());
            });
        }catch(IllegalAccessException | InstantiationException | NoSuchFieldException | SQLException ex){
        }
        return map;
    }
    
    public boolean insertColonia(Object[] data){
        String query = "Insert into Colonias (Nombre, CodigoPostal) values (?,?)";
        try{
            PreparedStatement pst = connection.prepareStatement(query);
            sqlService.Differentiate(pst, data);
            pst.executeUpdate();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }
    
}
