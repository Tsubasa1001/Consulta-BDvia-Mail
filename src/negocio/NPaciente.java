/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Datos.DPaciente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sariah
 */
public class NPaciente {
    
    private DPaciente Dpaciente;

    public NPaciente() {
        this.Dpaciente = new DPaciente();
    }
    
    public String Listar(){
        String Lista = this.Dpaciente.Listar();
        return Lista;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
        String codigo = atributos.get(0);
        String ci = atributos.get(1);
        String nombre = atributos.get(2);
        String nacionalidad = atributos.get(3);
        String ocupacion = atributos.get(4);
        String direccion  = atributos.get(5);
        String email = atributos.get(6);
        String celular = atributos.get(7);
        int edad = Integer.parseInt(atributos.get(8));
        char genero = atributos.get(9).charAt(0);
        
        Dpaciente.setCodigo(codigo);
        Dpaciente.setCi(ci);
        Dpaciente.setNombre(nombre);
        Dpaciente.setNacionalidad(nacionalidad);
        Dpaciente.setOcupacion(ocupacion);
        Dpaciente.setDireccion(direccion);
        Dpaciente.setEmail(email);
        Dpaciente.setCelular(celular);
        Dpaciente.setEdad(edad);
        Dpaciente.setGenero(genero);
        
        Dpaciente.Dregistrar();
    }
    
    public void Modificar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        String codigo = atributos.get(1);
        String ci = atributos.get(2);
        String nombre = atributos.get(3);
        String nacionalidad = atributos.get(4);
        String ocupacion = atributos.get(5);
        String direccion  = atributos.get(6);
        String email = atributos.get(7);
        String celular = atributos.get(8);
        int edad = Integer.parseInt(atributos.get(9));
        char genero = atributos.get(10).charAt(0);
        
        Dpaciente.setId(id);
        Dpaciente.setCodigo(codigo);
        Dpaciente.setCi(ci);
        Dpaciente.setNombre(nombre);
        Dpaciente.setNacionalidad(nacionalidad);
        Dpaciente.setOcupacion(ocupacion);
        Dpaciente.setDireccion(direccion);
        Dpaciente.setEmail(email);
        Dpaciente.setCelular(celular);
        Dpaciente.setEdad(edad);
        Dpaciente.setGenero(genero);
        Dpaciente.Dmodificar();
    }
    
    public void Eliminar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        Dpaciente.setId(id);
        Dpaciente.Deliminar();
    }
    
    public String Ver(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        Dpaciente.setId(id);
        //System.err.println("id:"+id);
        String detalle = Dpaciente.Dver(Dpaciente.getId());
        //System.err.println("resultado: "+detalle);
    return detalle;
    }
    
    public static void main(String[] args) throws SQLException{
        NPaciente nPaciente = new NPaciente();
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
        System.out.println("lista: \n"+ nPaciente.Ver(atributos));
        
        //nreserva.Eliminar(atributos);
        //System.out.println("lista: \n"+ nreserva.Listar());
        
    } 
    
}
