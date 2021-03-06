/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Consultas_Mail.ClientePgSql;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author eyver-dev
 */
public class DatosReporte {
    private DPaciente datosPaciente;
    private DPaquete datosPaquete;
    private DatosTrabajador datosTrabajador;
    private DatosUsuario datosUsuario;
    private ClientePgSql postgres;

    public DatosReporte() {
        datosPaciente = new DPaciente();
        datosPaquete = new DPaquete();
        datosTrabajador = new DatosTrabajador();
        datosUsuario = new DatosUsuario();
        postgres = new ClientePgSql();
    }

    public DPaciente getDatosPaciente() {return datosPaciente;}
    public void setDatosPaciente(DPaciente datosPaciente) {this.datosPaciente = datosPaciente;}
    public DPaquete getDatosPaquete() {return datosPaquete;}
    public void setDatosPaquete(DPaquete datosPaquete) {this.datosPaquete = datosPaquete;}
    public DatosTrabajador getDatosTrabajador() {return datosTrabajador;}
    public void setDatosTrabajador(DatosTrabajador datosTrabajador) {this.datosTrabajador = datosTrabajador;}
    public DatosUsuario getDatosUsuario() {return datosUsuario;}
    public void setDatosUsuario(DatosUsuario datosUsuario) {this.datosUsuario = datosUsuario;}
    public ClientePgSql getPostgres() {return postgres;}
    public void setPostgres(ClientePgSql postgres) {this.postgres = postgres;}
    
    public void conectar (){this.getPostgres().connect();}
    public void desconectar(){this.getPostgres().desconectar();}
    
    public String indexPaciente(){
        String cadena = this.getDatosPaciente().Listar();
        return cadena;
    }
    
    public String indexPaquete(){
        String cadena = this.getDatosPaciente().Listar();
        return cadena;
    }
    
    public String indexTrabajador(){
        String cadena = this.getDatosPaciente().Listar();
        return cadena;
    }
    
    public String indexUsuario(){
        String cadena = ""; //this.getDatosUsuario().index();
        return cadena;
    }

    public String reporteAtencion() {
        String sql;
        String resultado;
        
        sql = ""
            + "select p.nombre as paciente_nombre, p.genero as paciente_genero, t.nombre as trabajador_nombre, t.cargo as trabajador_cargo, c.motivoconsulta, c.estadotratamiento\n"
            + "from trabajador t, paciente p, citaconsulta c\n"
            + "where t.ocupacion = 'No presente' and c.id_paciente = p.id and c.id_trabajador = t.id;";
        this.getPostgres().connect();
        resultado = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        if (resultado.isEmpty()){
            resultado = "Resultado :: vacio";
        }
        
        return resultado;
    }
    
}
