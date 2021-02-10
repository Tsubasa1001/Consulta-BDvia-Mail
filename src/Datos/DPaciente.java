/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
//import Consultas_Mail.ClientePgSql;
import Consultas_Mail.ClientePgSql;
import Consultas_Mail.Conexion;
import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author sariah
 */
public class DPaciente {
        String codigo;
	String ci;
	String nombre;
	String nacionalidad;
	String ocupacion;
	String direccion;
	String email;
	String celular;
	int edad; 
        
        private static ClientePgSql conexion;
        

    public DPaciente() {
        conexion = new ClientePgSql();
    }

    public DPaciente(String codigo, String ci, String nombre, String nacionalidad, String ocupacion, String direccion, String email, String celular, int edad) {
        this.codigo = codigo;
        this.ci = ci;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
        this.edad = edad;
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
        
        
    public int Dregistrar(String codigo, String ci, String nombre, String nacionalidad, String ocupacion, String direccion, String email, String celular, int edad){
        int Dstatement = -1;
        if(conexion.connect() != null){
            String sql = "INSERT INTO paciente(codigo,ci,nombre,nacionalidad,ocupacion,direccion,email,celular,edad)"
                    +"VALUES ('"+codigo+"','"+ci+"','"+nombre+"','"+nacionalidad+"','"+ocupacion+"','"+direccion+"','"+email+"','"+celular+"','"+edad+"');";
            conexion.runStatement(sql);
           
            System.out.println("A pasado por Dregistrar DPaciente exitosamente");
        }
        return Dstatement;
    }
    
    public int Dmodificar(String codigo, String ci, String nombre, String nacionalidad, String ocupacion, String direccion, String email, String celular, int edad){
        int Dstatement = -1;
        if(conexion.connect() != null){
            String sql = "UPDATE paciente SET ci='"+ci+"',nombre='"+nombre+"',nacionalidad='"+nacionalidad+"',ocupacion='"+ocupacion+"',direccion='"+direccion+"',email='"+email+"',celular='"+celular+"',edad='"+edad+"' WHERE codigo ="+"'codigo'";
            System.err.println(sql); 
            conexion.runStatement(sql);
            
            System.out.println("A pasado por Dmodificar DPaciente exitosamente");
        }
        return Dstatement;
    }
    
    public int Deliminar(String codigo){
        int Dstatement = -1;
        if(conexion.connect() != null){
            String sql = "DELETE FROM paciente WHERE codigo ="+codigo;
             
            conexion.runStatement(sql);
            
            System.out.println("A pasado por Dmodificar DPaciente exitosamente");
        }
        return Dstatement;
    }
    
    public String Dlistar(){ //ver otra forma de listar que no sea en una tabla
        
        conexion.connect();
        String [] columnas = {"codigo","ci","nombre","nacionalidad","ocupacion","direccion","email","celular","edad"};
        DefaultTableModel tabla = new DefaultTableModel(columnas,0);
        Statement statement;
        ResultSet resultset = null;
        String sql = "SELECT * FROM paciente ORDER BY codigo,ci,nombre,nacionalidad,ocupacion,direccion,email,celular,edad";
        String resultado = conexion.runStatement(sql);
       /* try {
            
            int i = 0;
            while(resultset.next()){
                String[] pacientetabla = new String[9];
                tabla.setRowCount(tabla.getRowCount() + 1);
                tabla.setValueAt(resultset.getObject(1).toString(), i, 0);
                tabla.setValueAt(resultset.getObject(2).toString(), i, 1);
                tabla.setValueAt(resultset.getObject(3).toString(), i, 2);
                tabla.setValueAt(resultset.getObject(4).toString(), i, 3);
                tabla.setValueAt(resultset.getObject(5).toString(), i, 4);
                tabla.setValueAt(resultset.getObject(6).toString(), i, 5);
                tabla.setValueAt(resultset.getObject(7).toString(), i, 6);
                tabla.setValueAt(resultset.getObject(8).toString(), i, 7);
                tabla.setValueAt(resultset.getObject(9).toString(), i, 8);
          
                i++;
            }
            
        }catch (Exception e) {
                System.out.println("DPaciente listar "+e.getMessage());
            System.err.println("no se pudieron cargar los datos");
                
        }
        */
        
          return resultado;   
    }
}
