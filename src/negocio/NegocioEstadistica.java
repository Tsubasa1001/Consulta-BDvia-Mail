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

    public NegocioEstadistica() { datosEstadistica = new DatosEstadistica(); }

    public DatosEstadistica getDatosEstadistica() {return datosEstadistica;}
    public void setDatosEstadistica(DatosEstadistica datosEstadistica) {this.datosEstadistica = datosEstadistica;}
    
    /*M E T O D O S   E S T A D I S T I C O S*/
    
    public String mediaAtencionTotal() {
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
        
        resultado = this.cyan + "     mediaAtencionTotal :: " + mediaTotalAtenciones + "     " + this.white;
        return resultado;
    }
    public String mediaAtencionMes() {
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
        
        resultado = this.purple + "     mediaAtencionMes :: " + mediaAtencionMes + "     " + this.white;
        return resultado;
    }
    
    public String mediaAtencionTotalHombres() {
        String resultado = "default";
        int cantTotalAtencionesHombres = -1;
        int sumTotalAtencionesHombres = -1;
        int mediaTotalAtencionesHombres = -1;
        
        cantTotalAtencionesHombres = this.getDatosEstadistica().cantTotalAtencionesHombres();
        sumTotalAtencionesHombres = this.getDatosEstadistica().sumTotalAtencionesHombres();
        try {
            mediaTotalAtencionesHombres = sumTotalAtencionesHombres/cantTotalAtencionesHombres;
        }catch(Exception e){
            mediaTotalAtencionesHombres = 0;
        }
        
        resultado = this.cyan + "     mediaAtencionTotalHombres :: " + mediaTotalAtencionesHombres + "     " + this.white;
        return resultado;
    }
    public String mediaAtencionMesHombres() {
        String resultado = "default";
        int cantTotalAtencionesMesHombres = -1;
        int sumTotalAtencionesHombres = -1;
        int mediaAtencionMesHombres = -1;
        
        cantTotalAtencionesMesHombres = this.getDatosEstadistica().cantTotalAtencionesMesHombres();
        sumTotalAtencionesHombres = this.getDatosEstadistica().sumTotalAtencionesHombres();
        try{
            mediaAtencionMesHombres = sumTotalAtencionesHombres/cantTotalAtencionesMesHombres;
        }catch(Exception e){
            mediaAtencionMesHombres = 0;
        }
        
        resultado = this.purple + "     mediaAtencionMesHombres :: " + mediaAtencionMesHombres + "     " + this.white;
        return resultado;
    }

    public String mediaAtencionTotalMujeres() {
        String resultado = "default";
        int cantTotalAtencionesMujeres = -1;
        int sumTotalAtencionesMujeres = -1;
        int mediaTotalAtencionesMujeres = -1;
        
        cantTotalAtencionesMujeres = this.getDatosEstadistica().cantTotalAtencionesMujeres();
        sumTotalAtencionesMujeres = this.getDatosEstadistica().sumTotalAtencionesMujeres();
        try {
            mediaTotalAtencionesMujeres = sumTotalAtencionesMujeres/cantTotalAtencionesMujeres;
        }catch(Exception e){
            mediaTotalAtencionesMujeres = 0;
        }
        
        resultado = this.cyan + "     mediaAtencionTotalMujeres :: " + mediaTotalAtencionesMujeres + "     " + this.white;
        return resultado;
    }
    public String mediaAtencionMesMujeres() {
        String resultado = "default";
        int cantTotalAtencionesMesMujeres = -1;
        int sumTotalAtencionesMujeres = -1;
        int mediaAtencionMesMujeres = -1;
        
        cantTotalAtencionesMesMujeres = this.getDatosEstadistica().cantTotalAtencionesMesMujeres();
        sumTotalAtencionesMujeres = this.getDatosEstadistica().sumTotalAtencionesMujeres();
        try{
            mediaAtencionMesMujeres = sumTotalAtencionesMujeres/cantTotalAtencionesMesMujeres;
        }catch(Exception e){
            mediaAtencionMesMujeres = 0;
        }
        
        resultado = this.purple + "     mediaAtencionMesMujeres :: " + mediaAtencionMesMujeres + "     " + this.white;
        return resultado;
    }
    
    public static void main(String[] args) {
        NegocioEstadistica ne = new NegocioEstadistica();
        String tmp = "default";
        
        
        tmp = ne.mediaAtencionTotal();
        System.out.println(tmp);
        tmp = ne.mediaAtencionMes();
        System.out.println(tmp);
        
        
        tmp = ne.mediaAtencionTotalHombres();
        System.out.println(tmp);
        tmp = ne.mediaAtencionMesHombres();
        System.out.println(tmp);
        
        
        tmp = ne.mediaAtencionTotalMujeres();
        System.out.println(tmp);
        tmp = ne.mediaAtencionMesMujeres();
        System.out.println(tmp);
    }
}
