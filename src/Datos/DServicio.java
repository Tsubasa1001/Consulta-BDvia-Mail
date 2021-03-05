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
public class DServicio {
    private int id;
    private String nombre;
    private float precio;
    private int id_equipamiento;
    private int id_paquete;
    private ClientePgSql bd;

    public DServicio(){
        this.bd = new ClientePgSql();
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public float getPrecio() {
        return this.precio;
    }
    
    public int getId_equipamiento() {
        return this.id_equipamiento;
    }
    
    public int getId_paquete() {
        return this.id_paquete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public void setId_equipamiento(int id_e) {
        this.id_equipamiento = id_e;
    }
    
    public void setId_paquete(int id_p) {
        this.id_paquete = id_p;
    }
    
    public String Listar(){
        Connection conexion = this.bd.connect();
        String sql = "SELECT * FROM servicio ORDER BY id ASC;";
        String result = this.bd.runStatement(sql);
        conexion = null;
        return result;
    }
    
    public void Registrar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "INSERT INTO servicio VALUES(default,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, this.getNombre());
        ps.setFloat(2, this.getPrecio());
        ps.setInt(3, this.getId_equipamiento());
        ps.setInt(4, this.getId_paquete());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
    
    public void Modificar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "UPDATE servicio SET nombre = ?, precio = ?, id_equipamiento = ?, id_paquete = ? WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, this.getNombre());
        ps.setFloat(2, this.getPrecio());
        ps.setInt(3,this.getId_equipamiento());
        ps.setInt(4,this.getId_paquete());
        ps.setInt(5,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
    
    public void Eliminar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "DELETE FROM servicio WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
    
    public String Ver() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "SELECT * FROM servicio WHERE id = "+ Integer.toString(this.getId()) +";";
        String result = this.bd.runStatement(sql);
        conexion = null;
        return result;
    }
}
