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
        return Lista;
    }
    
    public void Registrar(List<String> atributos) throws SQLException{
        String codigo = atributos.get(0);
        String nombre = atributos.get(1);
        int id_l = Integer.parseInt(atributos.get(2));
        DEquipamiento.setCodigo(codigo);
        DEquipamiento.setNombre(nombre);
        DEquipamiento.setId_local(id_l);
        DEquipamiento.Registrar();
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
