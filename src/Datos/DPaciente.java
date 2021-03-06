/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
//import Consultas_Mail.ClientePgSql;
import Consultas_Mail.ClientePgSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author sariah
 */
public class DPaciente {
        private int id;
        private String codigo;
	private String ci;
	private String nombre;
	private String nacionalidad;
	private String ocupacion;
	private String direccion;
	private String email;
	private String celular;
	private int edad; 
        private char genero;
        private String fecha_creacion;
        
        private static ClientePgSql bd;
        

    public DPaciente() {
        bd = new ClientePgSql();
    }

    public DPaciente(int id, String codigo, String ci, String nombre, String nacionalidad, String ocupacion, String direccion, String email, String celular, int edad, char genero,String fecha_creacion) {
        this.id = id;
        this.codigo = codigo;
        this.ci = ci;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
        this.edad = edad;
        this.genero = genero;
        this.fecha_creacion = fecha_creacion;
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

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
      
    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
        
    public String Listar(){
        Connection conexion = this.bd.connect();
        String sql = "SELECT p.id, p.ci, p.codigo,p.nombre,p.celular,p.edad,p.genero FROM paciente p ORDER BY id ASC;";
        String result = //"\n___________________________________________________________________________________________________________________________ \n"
                      //+"ID____________________CI_______________CODIGO___________________NOMBRE___________CELULAR___________EDAD______________GENERO \n"+
                        this.bd.runStatement(sql);
        conexion = null;
        return result;
    }
    
    
    public String Dregistrar(int id) throws SQLException{
        
        String resultado="";
        Connection conexion = this.bd.connect();
        String sql = "INSERT INTO paciente values("+id+",?,?,?,?,?,?,?,?,?,?,?);";
        System.err.println("sql "+sql);
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setString(1, this.getCodigo());
        ps.setString(2, this.getCi());
        ps.setString(3, this.getNombre());
        ps.setString(4,this.getNacionalidad());
        ps.setString(5,this.getOcupacion());
        ps.setString(6, this.getDireccion());
        ps.setString(7, this.getEmail());
        ps.setString(8, this.getCelular());
        ps.setInt(9, this.getEdad());
        ps.setString(10, Character.toString(this.getGenero()));
        ps.setString(11,this.getFecha_creacion());
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado="A registrado Paciente exitosamente";
        return resultado;
    }
    
    public String Dmodificar()throws SQLException{
        System.out.println("esta en dmodificar");
        
        String resultado="";
        
        Connection conexion = this.bd.connect();
        String sql = "UPDATE paciente SET codigo  = ?, ci = ?, nombre = ?, nacionalidad = ?, ocupacion = ?, "
                + "direccion = ?, email = ? , celular = ? , edad = ? , genero = ?, fecha_creacion = ? WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setString(1, this.getCodigo());
        ps.setString(2, this.getCi());
        ps.setString(3, this.getNombre());
        ps.setString(4,this.getNacionalidad());
        ps.setString(5,this.getOcupacion());
        ps.setString(6,this.getDireccion());
        ps.setString(7,this.getEmail());
        ps.setString(8,this.getCelular());
        ps.setInt(9, this.getEdad());
        ps.setString(10,Character.toString(this.getGenero()));
        ps.setString(11,this.getFecha_creacion());
        ps.setInt(12, this.getId());
        
        ps.executeUpdate();
        ps.close();
        conexion = null;
        resultado = "A modificado Paciente exitosamente";
        return resultado;
    }
    
    
    public String Deliminar()throws SQLException{
        String resultado="";
        
        Connection conexion = this.bd.connect();
        String sql = "DELETE FROM paciente WHERE id = ?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.executeUpdate();
        ps.close();
        conexion = null;
        
        resultado = "A eliminado Paciente exitosamente";
        return resultado;
    }
    
    public String Dver(int id) throws SQLException{
        Connection conexion = this.bd.connect();
        String sql = "SELECT * FROM paciente WHERE id="+id+";";
        String result = this.bd.runStatement(sql);
        conexion = null;
       
        String[] detalle = result.split(",");
        result = "El usuario id"+id+" es: \n\n"
                + "id: "+detalle[0].trim() +"\n"
                + "codigo: "+detalle[1].trim()+"\n"
                + "ci: "+detalle[2].trim()+"\n"
                + "nombre: "+detalle[3].trim()+"\n"
                + "nacionalidad: "+detalle[4].trim()+"\n"
                + "ocupacion: "+detalle[5].trim()+"\n"
                + "direccion: "+detalle[6].trim()+"\n"
                + "email: "+detalle[7].trim()+"\n"
                + "celular: "+detalle[8].trim()+"\n"
                + "edad: "+detalle[9].trim()+"\n"
                + "genero: "+detalle[10].trim()+"\n"
                + "Fecha creacion "+detalle[11].trim()+"\n";
        
        return result;
    }
    
 
}
