/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.FileInputStream;
import java.util.Date;

/**
 *
 * @author 000093883
 */
public class TareaModel {
    
    private int TareaID;
    private String Descripcion;
    private Date Fecha;
    private String Estado;
    private int ColoniaID;
    private FileInputStream Imagen;

    public FileInputStream getImagen() {
        return Imagen;
    }

    public void setImagen(FileInputStream Imagen) {
        this.Imagen = Imagen;
    }
    

    public int getTareaID() {
        return TareaID;
    }

    public void setTareaID(int TareaID) {
        this.TareaID = TareaID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getColoniaID() {
        return ColoniaID;
    }

    public void setColoniaID(int ColoniaID) {
        this.ColoniaID = ColoniaID;
    }
    
    
}
