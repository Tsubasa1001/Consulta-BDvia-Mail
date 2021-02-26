/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.DatosEstadistica;

/**
 *
 * @author eyver-dev
 */
public class NegocioEstadistica {
    private DatosEstadistica datosEstadistica;
    private String white = "\u001B[37m";
    private String cyan = "\u001B[36m";
    private String purple = "\u001B[35m";

    public NegocioEstadistica() {
        datosEstadistica = new DatosEstadistica();
    }

    public DatosEstadistica getDatosEstadistica() {return datosEstadistica;}
    public void setDatosEstadistica(DatosEstadistica datosEstadistica) {this.datosEstadistica = datosEstadistica;}
    
    /*M E T O D O S   E S T A D I S T I C O S*/
    
    private String mediaAtencionTotal() {
        String resultado = "default";
        int cantTotalAtenciones = -1;
        int sumTotalAtenciones = -1;
        int mediaTotalAtenciones = -1;
        
        cantTotalAtenciones = this.getDatosEstadistica().cantTotalAtenciones();
        sumTotalAtenciones = this.getDatosEstadistica().sumTotalAtenciones();
        try {
            mediaTotalAtenciones = sumTotalAtenciones/cantTotalAtenciones;
        }catch(Exception e){
            mediaTotalAtenciones = 0;
        }
        
        resultado = this.cyan + "mediaAtencionTotal :: " + mediaTotalAtenciones + this.white;
        return resultado;
    }
    private String mediaAtencionMes() {
        String resultado = "default";
        int cantTotalAtencionesMes = -1;
        int sumTotalAtenciones = -1;
        int mediaAtencionMes = -1;
        
        cantTotalAtencionesMes = this.getDatosEstadistica().cantTotalAtencionesMes();
        sumTotalAtenciones = this.getDatosEstadistica().sumTotalAtenciones();
        try{
            mediaAtencionMes = sumTotalAtenciones/cantTotalAtencionesMes;
        }catch(Exception e){
            mediaAtencionMes = 0;
        }
        
        resultado = this.purple + "mediaAtencionMes :: " + mediaAtencionMes + this.white;
        return resultado;
    }
    
    public static void main(String[] args) {
        NegocioEstadistica ne = new NegocioEstadistica();
        String tmp = "default";
        
        tmp = ne.mediaAtencionTotal();
        System.out.println(tmp);
        
        tmp = ne.mediaAtencionMes();
        System.out.println(tmp);
    }

    

    
}
