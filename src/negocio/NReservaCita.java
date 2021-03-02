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
        return Lista;
    }
     
    public void Registrar(List<String> atributos) throws SQLException{
        int id_paciente = Integer.parseInt(atributos.get(0));
        int id_trabajador = Integer.parseInt(atributos.get(1));
        String codigo = atributos.get(2);
        String hora = atributos.get(3);
        String fecha = atributos.get(4);
        String motivoConsulta = atributos.get(5);
        String estadoTratamiento = atributos.get(6);
        
        dreservaCita.setCodigo(codigo); 
        dreservaCita.setHora(hora);
        dreservaCita.setFecha(fecha);
        dreservaCita.setMotivoConsulta(motivoConsulta);
        dreservaCita.setEstadoTratamiento(estadoTratamiento);
        
        dreservaCita.Dregistrar(id_paciente,id_trabajador);
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
        System.out.println("lista: \n"+ nreserva.Ver(atributos));
        
        //nreserva.Eliminar(atributos);
        //System.out.println("lista: \n"+ nreserva.Listar());
        
    } 
}
