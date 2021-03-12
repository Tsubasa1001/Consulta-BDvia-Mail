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
        String[] tmp = Lista.split("\n");
        
        String resultado = "";
        resultado += "\n_________________________________________________________________ \n"
                     +"ID______NOMBRE_______________PRECIO______ID-EQPO_____ID-PROMOCION \n";
        
        for (int i = 0; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            resultado += String.format("%-5s", aux[0]);
            resultado += String.format("%-25s", ","+aux[1]);
            resultado += String.format("%-13s", ","+aux[2]);
            resultado += String.format("%-12s", ","+aux[3]);
            resultado += String.format("%-11s", ","+aux[4]);

            resultado += "\n";
        }
        
        return resultado;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        String nombre = atributos.get(1);
        float precio = Float.parseFloat(atributos.get(2));
        int id_e = Integer.parseInt(atributos.get(3));
        int id_p = Integer.parseInt(atributos.get(4));
        DServicio.setNombre(nombre);
        DServicio.setPrecio(precio);
        DServicio.setId_equipamiento(id_e);
        DServicio.setId_paquete(id_p);
        DServicio.Registrar(id);
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
