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
        String[] tmp = Lista.split("\n");
        
        String resultado = "";
        resultado += "\n________________________________________________ \n"
                     +"ID______NOMBRE_______________CANTIDAD_____PRECIO \n";
        
        for (int i = 0; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            resultado += String.format("%-5s", aux[0]);
            resultado += String.format("%-25s", ","+aux[1]);
            resultado += String.format("%-12s", ","+aux[2]);
            resultado += String.format("%-4s", ","+aux[3]);

            resultado += "\n";
        }
        
        return resultado;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        String nombre = atributos.get(1);
        int cantidad = Integer.parseInt(atributos.get(2));
        float precio = Float.parseFloat(atributos.get(3));
        DPaquete.setNombre(nombre);
        DPaquete.setCantidad(cantidad);
        DPaquete.setPrecio(precio);
        DPaquete.Registrar(id);
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
    
    public String Ver(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        DPaquete.setId(id);
        String result = DPaquete.Ver();
        return result;
    }
}

