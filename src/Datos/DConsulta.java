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
 * @author sariah
 */
public class DConsulta {
    
    private int id;
    private int id_citaConsulta;
    private int id_servicio;
    private String codigo;
    private String horaEntrada;
    private String horaSalida;
    private String fecha;
    private float precio;
    private String notas;
    private String diagnosticoFinal;
    
    private static ClientePgSql bd;
    
    private DReservaCita dreservaCita;
    //private Dservicio

    public DConsulta() {
        bd = new ClientePgSql();
    }

    public DConsulta(int id, int id_citaConsulta, int id_servicio, String codigo, String horaEntrada, String horaSalida, String fecha, float precio, String notas, String diagnosticoFinal) {
        this.id = id;
        this.id_citaConsulta = id_citaConsulta;
        this.id_servicio = id_servicio;
        this.codigo = codigo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fecha = fecha;
        this.precio = precio;
        this.notas = notas;
        this.diagnosticoFinal = diagnosticoFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getDiagnosticoFinal() {
        return diagnosticoFinal;
    }

    public void setDiagnosticoFinal(String diagnosticoFinal) {
        this.diagnosticoFinal = diagnosticoFinal;
    }

    public String Listar(){
   
        Connection conexion = this.bd.connect();
        String sql = "SELECT c.id,c.codigo,cita.motivoConsulta, s.nombre,c.horaentrada,c.horasalida,c.fecha,c.precio,c.notas,c.diagnosticofinal \n" +
                     "FROM consulta c, citaconsulta cita, servicio s where c.id_citaconsulta = cita.id and c.id_servicio = s.id\n" +
                     "ORDER BY id ASC;";
        String result = this.bd.runStatement(sql);
        conexion = null;
        return result;  
    }
    
    public String Dregistrar(int id_cita,int id_servicio) throws SQLException{
        
        String resultado="";
        Connection conexion = this.bd.connect();
        String sql = "INSERT INTO consulta values(default,"+id_cita+","+id_servicio+",?,?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, this.getCodigo());
        ps.setString(2,this.getHoraEntrada());
        ps.setString(3, this.getHoraSalida());
        ps.setString(4, this.getFecha());
        ps.setFloat(5, this.getPrecio());
        ps.setString(6, this.getNotas());
        ps.setString(7, this.getDiagnosticoFinal());
        
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado="A registrado registrado una consulta exitosamente";
        return resultado;
    }
    
    public String Dmodificar(int id,int id_cita,int id_servicio)throws SQLException{
        System.out.println("esta en dmodificar");
        
        String resultado="";
        
        Connection conexion = this.bd.connect();
        String sql = "UPDATE consulta SET id_citaconsulta="+id_cita+",id_servicio="+id_servicio+", codigo  = ?, "
                + "horaentrada = ?,horasalida = ?,fecha = ?, precio = ?,notas = ?,diagnosticofinal = ? WHERE id = "+id+"  ;";
        PreparedStatement ps = conexion.prepareStatement(sql);
       
        ps.setString(1, this.getCodigo());
        ps.setString(2,this.getHoraEntrada());
        ps.setString(3,this.getHoraSalida());
        ps.setString(4, this.getFecha());
        ps.setFloat(5, this.getPrecio());
        ps.setString(6, this.getNotas());
        ps.setString(7, this.getDiagnosticoFinal());
        
        
        ps.executeUpdate();
        ps.close();
        conexion = null;
        resultado = "A modificado una consulta exitosamente";
        return resultado;
    }
    
    public String Deliminar()throws SQLException{
        String resultado="";
        
        Connection conexion = this.bd.connect();
        String sql = "DELETE FROM consulta WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado = "A eliminado una consulta exitosamente";
        return resultado;
    }
    
    
    public String Dver(int id) throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "SELECT c.id,c.codigo,cita.motivoConsulta, s.nombre,c.horaentrada,c.horasalida,c.fecha,c.precio,c.notas,c.diagnosticofinal" 
                    + " FROM Consulta c, citaconsulta cita, servicio s "
                    +"where c.id_citaconsulta = cita.id and c.id_servicio = s.id and c.id="+id+";";
        System.out.println("sql: "+sql);
        String result = this.bd.runStatement(sql);
        conexion = null;
        
        //result.replaceAll(" ","");
        
        String[] detalle = result.split(",");
        System.out.println("result: "+result);
        result = "La consulta es:\n"
                + "id: "+detalle[0].trim() +"\n"
                + "Codigo: "+detalle[1].trim()+"\n"
                + "Motivo consulta: "+detalle[2].trim()+"\n"
                + "Nombre Servicio: "+detalle[3].trim()+"\n"
                + "Hora entrada: "+detalle[4].trim()+"\n"
                + "Hora salida: "+detalle[5].trim()+"\n"
                + "Fecha: "+detalle[6].trim()+"\n"
                + "Precio: "+detalle[7].trim()+"\n"
                + "Notas: "+detalle[8].trim()+"\n"
                + "Diagnostico final: "+detalle[9].trim()+"\n"
                + "";
        
        
        //result.replace(" ","");
        System.err.println(detalle);
        return result;
    }
    
}
