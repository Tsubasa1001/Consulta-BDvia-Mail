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
public class DReservaCita {
    
    private int id;
    private int id_paciente;
    private int id_trabajador;
    private String codigo;
    private String hora;
    private String fecha;
    private String motivoConsulta;
    private String estadoTratamiento;
    
    private static ClientePgSql bd;
    
    private DPaciente dpaciente;
    private DatosTrabajador dtrabajador;

    public DReservaCita() {
        bd = new ClientePgSql();
    }

    public DReservaCita(int id, int id_paciente, int id_trabajador, String codigo, String hora, String fecha, String motivoConsulta, String estadoTratamiento) {
        this.id = id;
        this.id_paciente = id_paciente;
        this.id_trabajador = id_trabajador;
        this.codigo = codigo;
        this.hora = hora;
        this.fecha = fecha;
        this.motivoConsulta = motivoConsulta;
        this.estadoTratamiento = estadoTratamiento;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getEstadoTratamiento() {
        return estadoTratamiento;
    }

    public void setEstadoTratamiento(String estadoTratamiento) {
        this.estadoTratamiento = estadoTratamiento;
    }
    
    public String Listar(){
   
        Connection conexion = this.bd.connect();
        String sql = "SELECT c.id,p.nombre, t.nombre,c.codigo,c.hora,c.fecha,c.motivoconsulta,c.estadotratamiento \n" +
                     "FROM citaConsulta c, paciente p, trabajador t where c.id_paciente = p.id and c.id_trabajador = t.id\n" +
                     "ORDER BY id ASC;";
        String result = this.bd.runStatement(sql);
        conexion = null;
        return result;  
    }
    
    public String Dregistrar(int id_p,int id_t) throws SQLException{
        
        String resultado="";
        Connection conexion = this.bd.connect();
        String sql = "INSERT INTO citaConsulta values(default,"+id_p+","+id_t+",?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, this.getCodigo());
        ps.setString(2,this.getHora());
        ps.setString(3, this.getFecha());
        ps.setString(4, this.getMotivoConsulta());
        ps.setString(5, this.getEstadoTratamiento());
        
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado="A registrado reservado una cita exitosamente";
        return resultado;
    }
    
    public String Dmodificar(int id,int id_p,int id_t)throws SQLException{
        System.out.println("esta en dmodificar");
        
        String resultado="";
        
        Connection conexion = this.bd.connect();
        String sql = "UPDATE citaconsulta SET id_paciente="+id_p+",id_trabajador="+id_t+", codigo  = ?, "
                + "hora = ?,fecha = ?, motivoconsulta = ?,estadotratamiento = ? WHERE id = "+id+"  ;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setString(1, this.getCodigo());
        ps.setString(2,this.getHora());
        ps.setString(3, this.getFecha());
        ps.setString(4, this.getMotivoConsulta());
        ps.setString(5, this.getEstadoTratamiento());
        
        
        ps.executeUpdate();
        ps.close();
        conexion = null;
        resultado = "A modificado una Cita exitosamente";
        return resultado;
    }
    
    public String Deliminar()throws SQLException{
        String resultado="";
        
        Connection conexion = this.bd.connect();
        String sql = "DELETE FROM citaconsulta WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado = "A eliminado una reserva cita exitosamente";
        return resultado;
    }
    
    
    public String Dver(int id) throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "SELECT c.id,p.nombre, t.nombre,c.codigo,c.hora,c.fecha,c.motivoconsulta,c.estadotratamiento" 
                    + " FROM citaConsulta c, paciente p, trabajador t "
                    +"where c.id_paciente = p.id and c.id_trabajador = t.id and c.id="+id+";";
        //System.out.println("sql: "+sql);
        String result = this.bd.runStatement(sql);
        conexion = null;
       
        String[] detalle = result.split(",");
        result = "La cita reserva es:\n"
                + "id: "+detalle[0] +"\n"
                + "Paciente: "+detalle[1]+"\n"
                + "Trabajador: "+detalle[2]+"\n"
                + "Codigo: "+detalle[3]+"\n"
                + "Hora: "+detalle[4]+"\n"
                + "Fecha: "+detalle[5]+"\n"
                + "Motivo Consulta: "+detalle[6]+"\n"
                + "Estado tratamiento: "+detalle[7]+"\n"
                + "";
        
        return result;
    }
    
}
