/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author 000093883
 * @param <T>
 */
public class SQLService<T>{
    
    private final Class<T> clazz;
    private Connection connection;
    
    public SQLService(Class<T> clazz) {
        
        this.clazz = clazz;
    }
    
    public List<T> DynamicGetListMethod(String query, Connection connection) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        List<T> lista = new ArrayList<>();
        this.connection = connection;
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData metadata = resultSet.getMetaData();
        int columnCount = metadata.getColumnCount();
        while (resultSet.next()) {
            T obj = clazz.newInstance();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metadata.getColumnLabel(i);
                Object columnValue = resultSet.getObject(i);
                Field field;
                try {
                    field = clazz.getDeclaredField(columnName);
                } catch (NoSuchFieldException e) {
                    field = clazz.getSuperclass().getDeclaredField(columnName);
                }
                field.setAccessible(true);
                field.set(obj, columnValue);
            }
            lista.add(obj);
        }
        resultSet.close();
        statement.close();
        return lista;
    }
    
    public void Differentiate(PreparedStatement pst, Object[] objects) throws SQLException {
        int i = 1;
        for (Object o : objects) {
            if (o instanceof Boolean) {
                pst.setBoolean(i, (Boolean) o);
            } else if (o instanceof Byte) {
                pst.setByte(i, (Byte) o);
            } else if (o instanceof Double) {
                pst.setDouble(i, (Double) o);
            } else if (o instanceof Float) {
                pst.setFloat(i, (Float) o);
            } else if (o instanceof Integer) {
                pst.setInt(i, (Integer) o);
            } else if (o instanceof Short) {
                pst.setShort(i, (Short) o);
            } else if (o instanceof String) {
                pst.setString(i, (String) o);
            } else if (o instanceof Date) {
                java.util.Date utilDate = (Date) o;
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                pst.setDate(i, sqlDate);
            }else if(o instanceof FileInputStream){
                pst.setBinaryStream(i, (InputStream) o);
            }else{
                throw new IllegalArgumentException("Tipo no soportado: " + o.getClass().getName() != null ? o.getClass().getName() : "Error de tipo");
            }
            i++;
        }
    }
    
}
