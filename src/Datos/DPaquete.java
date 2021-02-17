/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Consultas_Mail.ClientePgSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author G. Franco
 */
public class DPaquete {
    private int id;
    private String nombre;
    private int cantidad;
    private float precio;
    private ClientePgSql bd;

    public DPaquete(){
        this.bd = new ClientePgSql();
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }
    
    public float getPrecio() {
        return this.precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public String Listar(){
        Connection conexion = this.bd.connect();
        String sql = "SELECT * FROM paquete ORDER BY id ASC;";
        String result = this.bd.runStatement(sql);
        conexion = null;
        return result;
    }
    
    public void Registrar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "INSERT INTO paquete VALUES(default,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, this.getNombre());
        ps.setInt(2, this.getCantidad());
        ps.setFloat(3, this.getPrecio());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
    
    public void Modificar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "UPDATE paquete SET nombre = ?, cantidad = ?, precio = ? WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, this.getNombre());
        ps.setInt(2, this.getCantidad());
        ps.setFloat(3, this.getPrecio());
        ps.setInt(4,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
    
    public void Eliminar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "DELETE FROM paquete WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
}

