/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author G. Franco
 */
public class Comando {
    private String Cu;
    private String Accion;
    private List<String> Atributos;
    private final String[] listaCu = {"local","servicio","equipamiento","paquete"};
    private final String[] listaAcciones = {"listar","registrar","modificar","eliminar"};
    
    public Comando(){
        this.Atributos = new ArrayList<>();
    }
    
    public String getCu(){
        return this.Cu;
    }
    public String getAccion(){
        return this.Accion;
    }
    public List<String> getAtributos(){
        return this.Atributos;
    }
    
    public void setCu(String cu){
        this.Cu = cu;
    }
    public void setAccion(String accion){
        this.Accion = accion;
    }
    public void setAtributos(List<String> atributos){
        this.Atributos = atributos;
    }
    
    public void separar(String comando){
        String[] ListaComandos = comando.split("_");
        ListaComandos[0] = ListaComandos[0].toLowerCase();
        ListaComandos[1] = ListaComandos[1].toLowerCase();
        if (this.verificarCu(ListaComandos[0])){
            if (this.verificarAccion(ListaComandos[1])){
                if ("all".equals(ListaComandos[2].toLowerCase())){
                    this.setCu(ListaComandos[0]);
                    this.setAccion(ListaComandos[1]);
                    this.Atributos.add(ListaComandos[2].toLowerCase());
                }else{
                    String att[] = ListaComandos[2].split(",");
                    for (String att1 : att) {
                        this.Atributos.add(att1);
                    }
                }
            }
        }else System.out.println("NO existe :/");
    }
    
    public boolean verificarCu(String cu){
        return Arrays.asList(this.listaCu).contains(cu);
    }
    
    public boolean verificarAccion(String accion){
        return Arrays.asList(this.listaAcciones).contains(accion);
    }
    
}
