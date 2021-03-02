/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.DatosReporte;

/**
 *
 * @author eyver-dev
 */
public class NegocioReporte {
    private DatosReporte reporteDB;

    public NegocioReporte() {
        this.reporteDB = new DatosReporte();
    }

    public DatosReporte getDatosReporteDB() {return reporteDB;}
    public void setDatosReporteDB(DatosReporte datosReporte) {this.reporteDB = datosReporte;}
    
    
    public static void main(String[] args) {
        NegocioReporte worker = new NegocioReporte();
        String tmp = "default";
        
        tmp = worker.reporteAtencion();
        System.out.println("reporteAtencion\n" + tmp);
    }

    private String reporteAtencion() {
        String resultado = "default";
        resultado = this.getDatosReporteDB().reporteAtencion();
        return resultado;
    }
}
