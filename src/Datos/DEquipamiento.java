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
public class DEquipamiento {
    private int id;
    private String codigo;
    private String nombre;
    private int id_local;
    private ClientePgSql bd;

    public DEquipamiento(){
        this.bd = new ClientePgSql();
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getId_local() {
        return this.id_local;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setId_local(int id_l) {
        this.id_local = id_l;
    }
    
    public String Listar(){
        Connection conexion = this.bd.connect();
        String sql = "SELECT * FROM equipamiento ORDER BY id ASC;";
        String result = this.bd.runStatement(sql);
        conexion = null;
        return result;
    }
    
    public void Registrar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "INSERT INTO equipamiento VALUES(default,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, this.getCodigo());
        ps.setString(2, this.getNombre());
        ps.setInt(3, this.getId_local());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
    
    public void Modificar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "UPDATE equipamiento SET codigo = ?, nombre = ?, id_local = ? WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, this.getCodigo());
        ps.setString(2, this.getNombre());
        ps.setInt(3,this.getId_local());
        ps.setInt(4,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
    
    public void Eliminar() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "DELETE FROM equipamiento WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
    }
    
    public String Ver() throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "SELECT * FROM equipamiento WHERE id = "+ Integer.toString(this.getId()) +";";
        String result = this.bd.runStatement(sql);
        conexion = null;
        return result;
    }
}
