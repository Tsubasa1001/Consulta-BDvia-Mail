/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.DReservaCita;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author sariah
 */
public class NReservaCita {
    
    private DReservaCita dreservaCita;

    public NReservaCita() {
        this.dreservaCita = new DReservaCita();
    }
    
     public String Listar(){
        String Lista = this.dreservaCita.Listar();
        String[] tmp = Lista.split("\n");
        
        System.err.println("tmp: "+tmp[1]);
        String resultado = "";
        resultado += "\n________________________________________________________________________________________________ \n"
                     +"ID______PACIENTE_____________________TRABAJADOR_______________CODIGO_CITA_____HORA_______FECHA__ \n";
        
        for (int i = 1; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            
        
            
            
        resultado += String.format("%-5s", aux[0]);
        resultado += String.format("%-30s", ","+aux[1]);
        resultado += String.format("%-30s", ","+aux[2]);
        resultado += String.format("%-10s", ","+aux[3]);
        resultado += String.format("%-12s", ","+aux[4]);
        resultado += String.format("%-12s", ","+aux[5]);
        
            
        resultado += "\n";
        
        }
        return resultado;
    }
     
    public void Registrar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        int id_paciente = Integer.parseInt(atributos.get(1));
        int id_trabajador = Integer.parseInt(atributos.get(2));
        String codigo = atributos.get(3);
        String hora = atributos.get(4);
        String fecha = atributos.get(5);
        String motivoConsulta = atributos.get(6);
        String estadoTratamiento = atributos.get(7);
        
        dreservaCita.setCodigo(codigo); 
        dreservaCita.setHora(hora);
        dreservaCita.setFecha(fecha);
        dreservaCita.setMotivoConsulta(motivoConsulta);
        dreservaCita.setEstadoTratamiento(estadoTratamiento);
        
        dreservaCita.Dregistrar(id,id_paciente,id_trabajador);
    }
    
    public void Modificar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        int id_paciente = Integer.parseInt(atributos.get(1));
        int id_trabajador = Integer.parseInt(atributos.get(2));
        String codigo = atributos.get(3);
        String hora = atributos.get(4);
        String fecha = atributos.get(5);
        String motivoConsulta = atributos.get(6);
        String estadoTratamiento = atributos.get(7);
        
        dreservaCita.setCodigo(codigo); 
        dreservaCita.setHora(hora);
        dreservaCita.setFecha(fecha);
        dreservaCita.setMotivoConsulta(motivoConsulta);
        dreservaCita.setEstadoTratamiento(estadoTratamiento);
        
        dreservaCita.Dmodificar(id,id_paciente,id_trabajador);
    }
    
    public void Eliminar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        dreservaCita.setId(id);
        dreservaCita.Deliminar();
    }
    
    public String Ver(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        dreservaCita.setId(id);
        //System.err.println("id:"+id);
        String detalle = dreservaCita.Dver(dreservaCita.getId());
        //System.err.println("resultado: "+detalle);
    return detalle;
    } 
    
     
    public static void main(String[] args) throws SQLException{
        NReservaCita nreserva = new NReservaCita();
        List<String> atributos = new ArrayList<>();
        
        atributos.add("2");
        atributos.add("1");
        atributos.add("1");
        atributos.add("FC0001");
        atributos.add("14:30:00");
        atributos.add("2021-08-25");
        atributos.add("fatiga");
        atributos.add("iniciando");
        
        System.out.println("lista: "+atributos);
        System.out.println("lista: \n"+ nreserva.Listar());
        
        //nreserva.Eliminar(atributos);
        //System.out.println("lista: \n"+ nreserva.Listar());
        
    } 
}
