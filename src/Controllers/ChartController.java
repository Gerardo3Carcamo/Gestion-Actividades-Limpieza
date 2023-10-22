/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Database.DatabaseConnection;
import Models.ChartModel;
import Models.TareaModel;
import Services.SQLService;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 000093883
 */
public class ChartController {
    
    DatabaseConnection dbConnection = DatabaseConnection.getInstance();
    Connection connection = dbConnection.getConnection();
    SQLService<ChartModel> sqlService = new SQLService<>(ChartModel.class);
    
    public List<ChartModel> getTareasPorMes(){
        List<ChartModel> list = new ArrayList<>();
        String query = "SELECT  " +
                        "    u.Nombre AS Nombre, " +
                        "    MONTH(t.Fecha) as Mes, " +
                        "    COUNT(at.TareaID) as Conteo " +
                        "FROM  " +
                        "    jefes j " +
                        "JOIN  " +
                        "    usuarios u ON j.JefeID = u.UserID " +
                        "JOIN  " +
                        "    jefesempleados je ON j.JefeID = je.JefeID " +
                        "JOIN  " +
                        "    empleados e ON je.EmpleadoID = e.EmpleadoID " +
                        "JOIN  " +
                        "    asignaciontareas at ON e.EmpleadoID = at.EmpleadoID " +
                        "JOIN " +
                        "    tareas t ON at.TareaID = t.TareaID " +
                        "GROUP BY  " +
                        "    u.Nombre, MONTH(t.Fecha);";
        try{
            list = sqlService.DynamicGetListMethod(query, connection);
            return list;
        }catch(Exception ex){
            return list;
        }
    }
    
    public List<ChartModel> getTareasCompletadasPorMes(){
        List<ChartModel> list = new ArrayList<>();
        String query = "SELECT " +
                        "    u.Nombre AS Nombre,  " +
                        "    MONTH(t.Fecha) as Mes, " +
                        "    COUNT(at.TareaID) as Conteo " +
                        "FROM jefes j " +
                        "JOIN usuarios u ON j.JefeID = u.UserID " +
                        "JOIN jefesempleados je ON j.JefeID = je.JefeID " +
                        "JOIN empleados e ON je.EmpleadoID = e.EmpleadoID " +
                        "JOIN asignaciontareas at ON e.EmpleadoID = at.EmpleadoID " +
                        "JOIN tareas t ON at.TareaID = t.TareaID " +
                        "WHERE t.Imagen IS NOT NULL " +
                        "GROUP BY u.Nombre, MONTH(t.Fecha)";
        try{
            list = sqlService.DynamicGetListMethod(query, connection);
            return list;
        }catch(Exception ex){
            return list;
        }
    }
    
}
