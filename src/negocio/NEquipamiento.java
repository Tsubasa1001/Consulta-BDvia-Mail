/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import Datos.DEquipamiento;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author G. Franco
 */
public class NEquipamiento {
    private DEquipamiento DEquipamiento;
    
    public NEquipamiento(){
        this.DEquipamiento = new DEquipamiento();
    }
    
    public String Listar(){
        String Lista = this.DEquipamiento.Listar();
        String[] tmp = Lista.split("\n");
        
        String resultado = "";
        resultado += "\n_____________________________________________ \n"
                     +"ID___CODIGO_____NOMBRE_______________ID-LOCAL \n";
        
        for (int i = 0; i < tmp.length; i++){
            String[] aux = tmp[i].split(",");
            for (int j = 0; j < aux.length; j++){
                aux[j] = aux[j].trim();
            }
            resultado += String.format("%-5s", aux[0]);
            resultado += String.format("%-11s", ","+aux[1]);
            resultado += String.format("%-22s", ","+aux[2]);
            resultado += String.format("%-8s", ","+aux[3]);

            resultado += "\n";
        }
        
        return resultado;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        String codigo = atributos.get(1);
        String nombre = atributos.get(2);
        int id_l = Integer.parseInt(atributos.get(3));
        DEquipamiento.setCodigo(codigo);
        DEquipamiento.setNombre(nombre);
        DEquipamiento.setId_local(id_l);
        DEquipamiento.Registrar(id);
    }
    
    public void Modificar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        String codigo = atributos.get(1);
        String nombre = atributos.get(2);
        int id_l = Integer.parseInt(atributos.get(3));
        DEquipamiento.setId(id);
        DEquipamiento.setCodigo(codigo);
        DEquipamiento.setNombre(nombre);
        DEquipamiento.setId_local(id_l);
        DEquipamiento.Modificar();
    }
    
    public void Eliminar(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        DEquipamiento.setId(id);
        DEquipamiento.Eliminar();
    }
    
    public String Ver(List<String> atributos) throws SQLException{
        int id = Integer.parseInt(atributos.get(0));
        DEquipamiento.setId(id);
        String result = DEquipamiento.Ver();
        return result;
    }
}
