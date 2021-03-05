/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import Datos.DServicio;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author G. Franco
 */
public class NServicio {
    private DServicio DServicio;
    
    public NServicio(){
        this.DServicio = new DServicio();
    }
    
    public String Listar(){
        String Lista = this.DServicio.Listar();
        return Lista;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
        String nombre = atributos.get(0);
        float precio = Float.parseFloat(atributos.get(1));
        int id_e = Integer.parseInt(atributos.get(2));
        int id_p = Integer.parseInt(atributos.get(3));
        DServicio.setNombre(nombre);
        DServicio.setPrecio(precio);
        DServicio.setId_equipamiento(id_e);
        DServicio.setId_paquete(id_p);
        DServicio.Registrar();
    }
    
    public void Modificar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        String nombre = atributos.get(1);
        float precio = Float.parseFloat(atributos.get(2));
        int id_e = Integer.parseInt(atributos.get(3));
        int id_p = Integer.parseInt(atributos.get(4));
        DServicio.setId(id);
        DServicio.setNombre(nombre);
        DServicio.setPrecio(precio);
        DServicio.setId_equipamiento(id_e);
        DServicio.setId_paquete(id_p);
        DServicio.Modificar();
    }
    
    public void Eliminar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        DServicio.setId(id);
        DServicio.Eliminar();
    }
    
    public String Ver(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        DServicio.setId(id);
        String result = DServicio.Ver();
        return result;
    }
}
