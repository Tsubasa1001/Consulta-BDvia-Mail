/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.DatosUsuario;

/**
 *
 * @author eyver-dev
 */
public class NegocioUsuario {
    private int codigo;                 /*variable de la tabla*/
    private String ci;                  /*variable de la tabla*/
    private String nombre;              /*variable de la tabla*/
    private String nacionalidad;        /*variable de la tabla*/
    private String especialidad;        /*variable de la tabla*/
    private String direccion;           /*variable de la tabla*/
    private String email;               /*variable de la tabla*/
    private String celular;             /*variable de la tabla*/
    private int edad;                   /*variable de la tabla*/
    private String genero;              /*variable de la tabla*/
    private String fecha_creacion;      /*variable de la tabla*/
    private DatosUsuario usuarioBD;     /*variable del sistema*/
    private String tabla;               /*variable del sistema*/

    public NegocioUsuario() {
        this.usuarioBD = new DatosUsuario();
        this.tabla = "usuario";
    }
    
    /* G E T / S E T   D E   L A S   V A R I A B L E S */
    
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public String getCi() {return ci;}
    public void setCi(String ci) {this.ci = ci;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getNacionalidad() {return nacionalidad;}
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}
    public String getEspecialidad() {return especialidad;}
    public void setEspecialidad(String especialidad) {this.especialidad = especialidad;}
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getCelular() {return celular;}
    public void setCelular(String celular) {this.celular = celular;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public String getFecha_creacion() {return fecha_creacion;}
    public void setFecha_creacion(String fecha_creacion) {this.fecha_creacion = fecha_creacion;}
    public String getTabla() {return tabla;}
    public void setTabla(String tabla) {this.tabla = tabla;}
    public DatosUsuario getUsuarioBD() {return usuarioBD;}
    public void setUsuarioBD(DatosUsuario usuarioBD) {this.usuarioBD = usuarioBD;}
    
    /* ********************************************************************** */
    
    public static void main(String[] args) {
        NegocioUsuario worker = new NegocioUsuario();
        String tmp = "";
        
        /**
         * codigo       ci      nombre      nacionalidad        especialidad
         * direccion    email   celular     edad                genero
         * fecha_reacion
         * 
         * "5000","6742098","IldefonsoLino","Bolivia","1","c/Alameins","5000@gmail.com","60426008","53","M","2020-08-08"
         * "codigo","ci","nombre","nacionalidad","especialidad","direccion","email","celular","edad","genero","fecha_creacion"
         */
        
        tmp = worker.index();
        System.out.println("index"+"\n"+tmp+"\n\n");
        worker.create(5001,"6242098","IldefonsoLino","Bolivia","1","c/Alameins","5001@gmail.com","60426008","53","M","2020-08-08");
        tmp = worker.read(5001);
        System.out.println("read"+"\n"+tmp+"\n\n");
        worker.update(5002,"6242098","IldefonsoLino","Bolivia","1","c/Alameins","5001@gmail.com","60426008","53","M","2020-08-08", 5001);
        worker.delete(5002);
    }

    private String index() {
        String resultado = "default";
        
        resultado = this.getUsuarioBD().index(this.getTabla());
        
        return resultado;
    }
    private String create(int codigo, String ci, String nombre, String nacionalidad, String especialidad, String direccion, String email, String celular, String edad, String genero, String fecha_creacion) {
        String resultado = "default";
        
        resultado = this.getUsuarioBD().create(this.getTabla(), codigo, ci, nombre, nacionalidad, especialidad, direccion, email, celular, edad, genero, fecha_creacion);
        
        return resultado;
    }
    private String read(int codigo) {
        String resultado = "default";
        
        resultado = this.getUsuarioBD().read(this.getTabla(), codigo);
        
        return resultado;
    }
    private String update(int codigo, String ci, String nombre, String nacionalidad, String especialidad, String direccion, String email, String celular, String edad, String genero, String fecha_creacion, int codigoViejo) {
        String resultado = "default";
        
        resultado = this.getUsuarioBD().update(this.getTabla(), codigo, ci, nombre, nacionalidad, especialidad, direccion, email, celular, edad, genero, fecha_creacion, codigoViejo);
        
        return resultado;
    }
    private String delete(int codigo) {
        String resultado = "default";
        
        resultado = this.getUsuarioBD().delete(this.getTabla(), codigo);
        
        return resultado;
    }
}
