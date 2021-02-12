/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comando;

import java.util.ArrayList;
import java.util.Scanner;

import Datos.DPaciente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sariah
 */
public class Separar_Comando {
    
    DPaciente paciente;
    String cuActual;
    String accionActual;
    String atributosActuales;
    String comando;
    
    String[]  listaCU = {"USUARIO-TRABAJADOR","USUARIO-PACIENTE","SERVICIO","EQUIPAMIENTO","AGENDA","FICHAMEDICA"};
    String[] lista_acciones = {"LISTAR","REGISTRAR","MODIFICAR","ELIMINAR"};
    
    
    public Separar_Comando(){
          paciente = new DPaciente();
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
        System.err.println("Parametros: "+parametros);
        /*String parametro1 = parametrosSeparados[0];
        String parametro2 = parametrosSeparados[1];
        String parametro3 = parametrosSeparados[2];
       
        //System.err.println("caso de uso: "+cu);
        //System.err.println("Accion: "+accion);
        System.err.println("Parametros: "+parametros);
        System.err.println("Parametros separados: "+parametro1+" "+parametro2+" "+parametro3);
       */ 
        for (int i=0; i<listaCU.length; i++){
            if(listaCU[i].equals(cu)){
                cuActual = listaCU[i];
                System.out.println("CU encontrado en la lista: "+ listaCU[i]);
          
            }else{
                //System.err.println("CU no encontrado en la lista");
            }
            
        }
        
        
        
        for (int i=0; i<lista_acciones.length; i++){     
            if(lista_acciones[i].equals(accion)){
                accionActual=lista_acciones[i];
                System.out.println("Accion encontrada en la lista: "+ lista_acciones[i]);
                //llamar al negocio correspondiente y mandarle el parametro accion con sus atributos
            }else{
                //System.err.println("Accion no encontrada en la lista: "+ lista_acciones[i]);
            }
        }
        
        switch(cuActual){
            case "USUARIO-PACIENTE":
                System.err.println("paso por USUARIO-PACIENTE");
                switch(accionActual){
                    case "LISTAR":
                        System.err.println("paso por LISTAR");
                        System.out.println(paciente.Dlistar());
                        break;
                    case "REGISTRAR":
                        String parametro1 = parametrosSeparados[0];
                        String parametro2 = parametrosSeparados[1];
                        String parametro3 = parametrosSeparados[2];
                        String parametro4 = parametrosSeparados[3];
                        String parametro5 = parametrosSeparados[4];
                        String parametro6 = parametrosSeparados[5];
                        String parametro7 = parametrosSeparados[6];
                        String parametro8 = parametrosSeparados[7];
                        String parametro9 = parametrosSeparados[8];
                        paciente.Dregistrar(parametro1, parametro2, parametro3,parametro4,parametro5,parametro6,parametro7,parametro8, Integer.parseInt(parametro9));
                        break;
                    case "MODIFICAR":
                        paciente.Dmodificar(comando, cu, comando, accionActual, accion, accion, accion, cu, 0);
                        break;
                    case "ELIMINAR":
                        paciente.Deliminar(comando);
                        break;
                }            
        }
        
        
    }
    
    
    

    
    public static void main(String[] args){
       DPaciente paciente = new DPaciente();
       
        //FUNCIONAN
        //System.out.println(paciente.Dlistar());
        //System.out.println(paciente.Dregistrar("P0003","42123", "Gustavo", "Bolivia", "Ing", "Por alla", "gustav@gmail.com", "75698542", 20));
        //System.out.println(paciente.Dmodificar("P003","00033", "Gustavo", "Bolivia", "Ing.", "Por aquiii", "gustav@gmail.com", "75698542", 23));
        //System.out.println(paciente.Deliminar("P003"));
        //System.out.println(paciente.Dlistar()); 
        
        Separar_Comando separar_comando = new Separar_Comando();
        
        //FUNCIONA
        separar_comando.separacion("USUARIO-PACIENTE_REGISTRAR_P0005,42123,Eyver,Bolivia,Ing,por alla,eyver@gmail.com,75698542,22");
        
        separar_comando.separacion("USUARIO-PACIENTE_LISTAR_P0004,42123,Celia,Bolivia,Artista,4to anillo,celiav@gmail.com,75698542,21");
       
        
    }
    
    
}
