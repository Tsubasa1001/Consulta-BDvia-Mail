/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Consultas_Mail.ClientePgSql;
import static java.lang.Thread.sleep;

/**
 *
 * @author eyver-dev
 */
public class DatosEstadistica {
    private ClientePgSql postgres;

    public DatosEstadistica() {
        postgres = new ClientePgSql();
    }

    public ClientePgSql getPostgres() {return postgres;}
    public void setPostgres(ClientePgSql postgres) {this.postgres = postgres;}
    
    /*V A R I A B L E S   A T E N C I O N*/
    
    public int cantTotalAtenciones() {
        int resultado = -1;
        String sql = "default";
        resultado = (int) (Math.random()*1000);
        
        sql = "select count(*) from usuario";
        this.getPostgres().connect();
        String trash = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        trash = trash.replace("|", "");
        trash = trash.replace(",", "");
        trash = trash.substring(0, trash.length() -2);
        resultado = Integer.parseInt(trash);
        
        return resultado;
    }
    public int sumTotalAtenciones() {
        int resultado = -1;
        String sql = "default";
        resultado = (int) (Math.random()*1000+1000);
        
        sql = "select sum(codigo) from usuario";
        this.getPostgres().connect();
        String trash = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        trash = trash.replace("|", "");
        trash = trash.replace(",", "");
        trash = trash.substring(0, trash.length() -2);
        resultado = Integer.parseInt(trash);
        
        return resultado;
    }
    public int cantTotalAtencionesMes() {
        int resultado = -1;
        resultado = cantTotalAtenciones()/12;
        
        return resultado;
    }

    public int cantTotalAtencionesHombres() {
        int resultado = -1;
        String sql = "default";
        resultado = (int) (Math.random()*1000);
        
        sql = "select count(*) from usuario where genero = 'M'";
        this.getPostgres().connect();
        String trash = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        trash = trash.replace("|", "");
        trash = trash.replace(",", "");
        trash = trash.substring(0, trash.length() -2);
        resultado = Integer.parseInt(trash);
        
        return resultado;
    }
    public int sumTotalAtencionesHombres() {
        int resultado = -1;
        String sql = "default";
        resultado = (int) (Math.random()*1000+1000);
        
        sql = "select sum(codigo) from usuario where genero = 'M'";
        this.getPostgres().connect();
        String trash = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        trash = trash.replace("|", "");
        trash = trash.replace(",", "");
        trash = trash.substring(0, trash.length() -2);
        resultado = Integer.parseInt(trash);
        
        return resultado;
    }
    public int cantTotalAtencionesMesHombres() {
        int resultado = -1;
        resultado = cantTotalAtencionesHombres()/12;
        
        return resultado;
    }

    public int cantTotalAtencionesMujeres() {
        int resultado = -1;
        String sql = "default";
        resultado = (int) (Math.random()*1000);
        
        sql = "select count(*) from usuario where genero = 'F'";
        this.getPostgres().connect();
        String trash = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        trash = trash.replace("|", "");
        trash = trash.replace(",", "");
        trash = trash.substring(0, trash.length() -2);
        resultado = Integer.parseInt(trash);
        
        return resultado;
    }
    public int sumTotalAtencionesMujeres() {
        int resultado = -1;
        String sql = "default";
        resultado = (int) (Math.random()*1000+1000);
        
        sql = "select sum(codigo) from usuario where genero = 'F'";
        this.getPostgres().connect();
        String trash = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        trash = trash.replace("|", "");
        trash = trash.replace(",", "");
        trash = trash.substring(0, trash.length() -2);
        resultado = Integer.parseInt(trash);
        
        return resultado;
    }
    public int cantTotalAtencionesMesMujeres() {
        int resultado = -1;
        resultado = cantTotalAtencionesMujeres()/12;
        
        return resultado;
    }
}
