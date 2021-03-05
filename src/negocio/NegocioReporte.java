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
        
        String[] tmp = resultado.split("\n");
        resultado = "";
        
        /**
         * Banner
         */
        
        for (int i = 1; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            
            resultado += String.format("%-20s", aux[0]);
            resultado += String.format("%-5s", ","+aux[1]);
            resultado += String.format("%-20s", ","+aux[2]);
            resultado += String.format("%-50s", ","+aux[3]);
            resultado += String.format("%-30s", ","+aux[4]);
            resultado += String.format("%-10s", ","+aux[5]);
            
            resultado += "\n";
        }
        
        return resultado;
    }
}
