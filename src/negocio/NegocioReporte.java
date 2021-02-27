/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Consultas_Mail.ClientePgSql;
import Datos.DatosReporte;

/**
 *
 * @author eyver-dev
 */
public class NegocioReporte {
    private DatosReporte datosReporte;

    public NegocioReporte() {
        this.datosReporte = new DatosReporte();
    }

    public DatosReporte getDatosReporte() {return datosReporte;}
    public void setDatosReporte(DatosReporte datosReporte) {this.datosReporte = datosReporte;}
    
    
    public static void main(String[] args) {
        NegocioReporte negocioReporte = new NegocioReporte();
        
        //negocioReporte.getDatosReporte().getDatosUsuario().getPostgres().connect();
        
        String tmp = negocioReporte.getDatosReporte().indexUsuario();
        System.out.println(tmp);
        
       //negocioReporte.getDatosReporte().getDatosUsuario().getPostgres().desconectar();
    }
}
