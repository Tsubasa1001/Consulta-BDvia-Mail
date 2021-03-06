/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.DConsulta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sariah
 */
public class NConsulta {
    
    private DConsulta dconsulta;

    public NConsulta() {
        this.dconsulta = new DConsulta();
    }
    
    public String Listar(){
        String Lista = this.dconsulta.Listar();
        String[] tmp = Lista.split("\n");
        
        System.err.println("tmp: "+tmp[1]);
        String resultado = "";
        resultado += "\n________________________________________________________________________________________ \n"
                     +"ID____CODIGO____MOTIVO_CONSULTA______________SERVICIO__________HORA_ENTRADA_____Fecha___ \n";
        
        for (int i = 0; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            
        
            
            
        resultado += String.format("%-5s", aux[0]);
        resultado += String.format("%-10s", ","+aux[1]);
        resultado += String.format("%-30s", ","+aux[2]);
        resultado += String.format("%-20s", ","+aux[3]);
        resultado += String.format("%-12s", ","+aux[4]);
        resultado += String.format("%-12s", ","+aux[5]);
            
        resultado += "\n";
        
        }
        return resultado;
    }
    
     public void Registrar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        int id_citaConsulta = Integer.parseInt(atributos.get(1));
        int id_servicio = Integer.parseInt(atributos.get(2));
        String codigo = atributos.get(3);
        String horaEntrada = atributos.get(4);
        String horaSalida = atributos.get(5);
        String fecha = atributos.get(6);
        float precio = Float.parseFloat(atributos.get(7));
        String notas = atributos.get(8);
        String diagnosticoFinal = atributos.get(9);
        
        dconsulta.setCodigo(codigo); 
        dconsulta.setHoraEntrada(horaEntrada);
        dconsulta.setHoraSalida(horaSalida);
        dconsulta.setFecha(fecha);
        dconsulta.setPrecio(precio);
        dconsulta.setNotas(notas);
        dconsulta.setDiagnosticoFinal(diagnosticoFinal);
        
        dconsulta.Dregistrar(id,id_citaConsulta,id_servicio);
        
     }
     
     public void Modificar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        int id_citaConsulta = Integer.parseInt(atributos.get(1));
        int id_servicio = Integer.parseInt(atributos.get(2));
        String codigo = atributos.get(3);
        String horaEntrada = atributos.get(4);
        String horaSalida = atributos.get(5);
        String fecha = atributos.get(6);
        float precio = Float.parseFloat(atributos.get(7));
        String notas = atributos.get(8);
        String diagnosticoFinal = atributos.get(9);
        
        
        dconsulta.setCodigo(codigo); 
        dconsulta.setHoraEntrada(horaEntrada);
        dconsulta.setHoraSalida(horaSalida);
        dconsulta.setFecha(fecha);
        dconsulta.setPrecio(precio);
        dconsulta.setNotas(notas);
        dconsulta.setDiagnosticoFinal(diagnosticoFinal);
        
        dconsulta.Dmodificar(id,id_citaConsulta,id_servicio);
    }
     
    public void Eliminar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        dconsulta.setId(id);
        dconsulta.Deliminar();
    }
    
    public String Ver(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        dconsulta.setId(id);
        //System.err.println("id:"+id);
        String detalle = dconsulta.Dver(dconsulta.getId());
        //System.err.println("resultado: "+detalle);
    return detalle;
    } 
    
    public static void main(String[] args) throws SQLException{
        NConsulta nconsulta = new NConsulta();
        List<String> atributos = new ArrayList<>();
        
        atributos.add("4");
        atributos.add("1");
        atributos.add("2");
        atributos.add("C0002");
        atributos.add("13:30:00");
        atributos.add("14:00:00");
        atributos.add("2021-08-2");
        atributos.add("100.00");
        atributos.add("mala.alimentacion");
        atributos.add("estress");
        //<CONSULTA_REGISTRAR_2,1,1,c0002,13:30:00,14:00:00,100.00,2021-08-22,mal.sueño,mucho.estress>
        System.out.println("lista: "+atributos);
        //nconsulta.Modificar(atributos);
        System.out.println("lista: \n"+ nconsulta.Listar());
        //nconsulta.Registrar(atributos);
        //System.out.println(nconsulta.Ver(atributos));
        //System.out.println("lista: \n"+ nconsulta.Listar());
        
        nconsulta.Eliminar(atributos);
        System.out.println("lista: \n"+ nconsulta.Listar());
        
    } 
}
