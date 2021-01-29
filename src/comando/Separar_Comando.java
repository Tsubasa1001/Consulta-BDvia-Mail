/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comando;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sariah
 */
public class Separar_Comando {
    
    String comando;
    
    String[]  listaCU = {"USUARIO","SERVICIO","EQUIPAMIENTO","AGENDA","FICHAMEDICA"};
    String[] lista_acciones = {"LISTAR","REGISTRAR","MODIFICAR","ELIMINAR"};
    
    
    public Separar_Comando(){
          
    }
    public Separar_Comando(String comando){
        this.comando = comando;    
    }
    
    public void separacion(String comando){
        String[] separado = comando.split("_");
        
        String cu = separado[0];
        String accion = separado[1];
        String parametros = separado[2];
        
        //pruebas para la separacion de parametros
        String[] parametrosSeparados = parametros.split(",");
        String parametro1 = parametrosSeparados[0];
        String parametro2 = parametrosSeparados[1];
        String parametro3 = parametrosSeparados[2];
       
        //System.err.println("caso de uso: "+cu);
        //System.err.println("Accion: "+accion);
        System.err.println("Parametros: "+parametros);
        System.err.println("Parametros separados: "+parametro1+" "+parametro2+" "+parametro3);
        
        for (int i=0; i<listaCU.length; i++){
            if(listaCU[i].equals(cu)){
                System.out.println("CU encontrado en la lista: "+ listaCU[i]);
            }else{
                //System.err.println("CU no encontrado en la lista");
            }
        }
        
        for (int i=0; i<lista_acciones.length; i++){     
            if(lista_acciones[i].equals(accion)){
                System.out.println("Accion encontrada en la lista: "+ lista_acciones[i]);
                //llamar al negocio correspondiente y mandarle el parametro accion con sus atributos
            }else{
                //System.err.println("Accion no encontrada en la lista: "+ lista_acciones[i]);
            }
        }
          
           
    }
    
    public String encontrarCU(String comando){
        
        
        String cu_encontrado;
        cu_encontrado = " ";
        return cu_encontrado;
    }
    
    public String encontrarAccion(String comando){
        String accion_encontrada;
        accion_encontrada = " ";
        return accion_encontrada;
    
    }
    
    public static void main(String[] args){
        
       Separar_Comando separar_comando = new Separar_Comando();
       separar_comando.separacion("SERVICIO_REGISTRAR_nombre,apellido,correo");
       
        
    }
    
    
}
