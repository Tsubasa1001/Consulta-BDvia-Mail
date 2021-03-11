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
        String[] tmp = Lista.split("\n");
        
        System.err.println("tmp: "+tmp[1]);
        String resultado = "";
        resultado += "\n____________________________________________________________________________________ \n"
                     +"ID______CI_____CODIGO______________NOMBRE_______________CELULAR_______EDAD____GENERO \n";
        
        for (int i = 0; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            
        
            
            
        resultado += String.format("%-5s", aux[0]);
        resultado += String.format("%-10s", ","+aux[1]);
        resultado += String.format("%-10s", ","+aux[2]);
        resultado += String.format("%-30s", ","+aux[3]);
        resultado += String.format("%-15s", ","+aux[4]);
        resultado += String.format("%-10s", ","+aux[5]);
        resultado += String.format("%-10s", ","+aux[6]);
            
        resultado += "\n";
        
        }
        return resultado;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
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
        String fecha_creacion = atributos.get(11);
        
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
        Dpaciente.setFecha_creacion(fecha_creacion);
        
        Dpaciente.Dregistrar(id);
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
        String fecha_creacion = atributos.get(11);
        
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
        Dpaciente.setFecha_creacion(fecha_creacion);
        
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
        
        atributos.add("102");
        atributos.add("P00101");
        atributos.add("0000000");
        atributos.add("Fernando");
        atributos.add("Bolivia");
        atributos.add("ingeniero");
        atributos.add("av. bush");
        atributos.add("fersh@gmail.com");
        atributos.add("65412545");
        atributos.add("20");
        atributos.add("M");
        atributos.add("2021-01-02");
        
        
        
        System.out.println("lista: "+atributos);
       
        System.out.println("lista: \n"+ nPaciente.Listar());
        
        nPaciente.Registrar(atributos);
        System.out.println("lista: \n"+ nPaciente.Listar());
        
        
    } 
    
}
