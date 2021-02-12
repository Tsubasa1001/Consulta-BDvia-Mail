/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import Datos.DPaquete;
import java.sql.SQLException;
/**
 *
 * @author G. Franco
 */
public class NPaquete {
    private DPaquete DPaquete;
    
    public NPaquete(){
        this.DPaquete = new DPaquete();
    }
    
    public String Listar(String comandInput){
        String Lista;
        Comando comando = new Comando();
        comando.separar(comandInput);
        if ("all".equals(comando.getAtributos().get(0))){
            Lista = this.DPaquete.Listar();
            return Lista;
        }else
            return "none";
    }
    
    public void Registrar(String comandInput) throws SQLException{
        Comando comando = new Comando();
        comando.separar(comandInput);
        String nombre = comando.getAtributos().get(0);
        int cantidad = Integer.parseInt(comando.getAtributos().get(1));
        float precio = Float.parseFloat(comando.getAtributos().get(2));
        DPaquete.setNombre(nombre);
        DPaquete.setCantidad(cantidad);
        DPaquete.setPrecio(precio);
        DPaquete.Registrar();
    }
    
    public void Modificar(String comandInput) throws SQLException{
        Comando comando = new Comando();
        comando.separar(comandInput);
        int id = Integer.parseInt(comando.getAtributos().get(0));
        String nombre = comando.getAtributos().get(1);
        int cantidad = Integer.parseInt(comando.getAtributos().get(2));
        float precio = Float.parseFloat(comando.getAtributos().get(3));
        DPaquete.setId(id);
        DPaquete.setNombre(nombre);
        DPaquete.setCantidad(cantidad);
        DPaquete.setPrecio(precio);
        DPaquete.Modificar();
    }
    
    public void Eliminar(String comandInput) throws SQLException{
        Comando comando = new Comando();
        comando.separar(comandInput);
        int id = Integer.parseInt(comando.getAtributos().get(0));
        DPaquete.setId(id);
        DPaquete.Eliminar();
    }
    
    public static void main(String[] args) throws SQLException{
        NPaquete NPaquete = new NPaquete();
        //NPaquete.Registrar("PAQUETE_REGISTRAR_Paquete2,5,300.5");
        //NPaquete.Modificar("PAQUETE_MODIFICAR_1,Paquete1edited,3,200.5");
        //NPaquete.Eliminar("PAQUETE_ELIMINAR_5");
        String a = NPaquete.Listar("PAQUETE_LISTAR_ALL");
        System.out.println(a);
    }
}
