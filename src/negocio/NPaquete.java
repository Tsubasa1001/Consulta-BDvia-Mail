/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import Datos.DPaquete;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author G. Franco
 */
public class NPaquete {
    private DPaquete DPaquete;
    
    public NPaquete(){
        this.DPaquete = new DPaquete();
    }
    
    public String Listar(){
        String Lista = this.DPaquete.Listar();
        return Lista;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
        String nombre = atributos.get(0);
        int cantidad = Integer.parseInt(atributos.get(1));
        float precio = Float.parseFloat(atributos.get(2));
        DPaquete.setNombre(nombre);
        DPaquete.setCantidad(cantidad);
        DPaquete.setPrecio(precio);
        DPaquete.Registrar();
    }
    
    public void Modificar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        String nombre = atributos.get(1);
        int cantidad = Integer.parseInt(atributos.get(2));
        float precio = Float.parseFloat(atributos.get(3));
        DPaquete.setId(id);
        DPaquete.setNombre(nombre);
        DPaquete.setCantidad(cantidad);
        DPaquete.setPrecio(precio);
        DPaquete.Modificar();
    }
    
    public void Eliminar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        DPaquete.setId(id);
        DPaquete.Eliminar();
    }
}

