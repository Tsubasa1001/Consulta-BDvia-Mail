/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Consultas_Mail.ConsultasBD_Mail;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import negocio.*;

/**
 *
 * @author G. Franco
 */
public class Comando {
    private String Cu;
    private String Accion;
    private List<String> Atributos;
    private final String[] listaCu = {"usuario-paciente","usuario-trabajador","local","servicio","equipamiento","promocion","consulta","citaconsulta","estaditica","reporte","manual-usuario"};
    private final String[] listaAcciones = {"ver","listar","registrar","modificar","eliminar","show","help"};
    
    //reportes_reportes_all //estadistica-estadistica_all
    
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
        this.Atributos.clear();
        if (this.verificarCu(ListaComandos[0])){
            if (this.verificarAccion(ListaComandos[1])){
                this.setCu(ListaComandos[0]);
                this.setAccion(ListaComandos[1]);
                if ("all".equals(ListaComandos[2].toLowerCase())){
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
    
     public String recogerDatos(String c) throws SQLException{
        this.separar(c);
        String result = "";
        String cu= this.getCu();
        String accion = this.getAccion();
        List<String> att = this.getAtributos();
        
        switch(cu){
            case "manual-usuario":
                switch(accion){
                    case "help":
                    result= "\n"
                            + "-----------------------------MANUAL USUARIO-----------------------------\n"
                            + "\n"
                            + "\n"
                            + "PROMOCIONES\n"
                            + "-----------------------------\n"
                            + "Listar:\n"
                            + "< PROMOCIONES_LISTAR_ALL >\n"
                            + "\n"
                            + "Registrar:\n"
                            + "< PROMOCIONES_REGISTRAR_nombrepaquete,4,200.0 >\n"
                            + "\n"
                            + "Modificar:\n"
                            + "< PROMOCIONES_MODIFICAR_1,nombrepaquete,4,200.0 >\n"
                            + "\n"
                            + "Eliminar:\n"
                            + "< PROMOCIONES_ELIMINAR_1 >\n"
                            + "-----------------------------"
                            + "\n"
                            + "\n"
                            + "USUARIO-PACIENTE\n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "< USUARIO-PACIENTE_VER_1 >\n"
                            + "\n"
                            + "Listar:\n"
                            + "< USUARIO-PACIENTE_LISTAR_ALL >\n"
                            + "\n"
                            + "Registrar:\n"
                            + "< USUARIO-PACIENTE_REGISTRAR_nombrepaquete,4,200.0 >\n"
                            + "\n"
                            + "Modificar:\n"
                            + "< USUARIO-PACIENTE_MODIFICAR_1,nombrepaquete,4,200.0 >\n"
                            + "\n"
                            + "Eliminar:\n"
                            + "< USUARIO-PACIENTE_ELIMINAR_1 >\n"
                            + "\n"
                            + "\n"
                            + "CERRAR SESION: < stop >"
                            + "\n"
                            + "\n";
                    break;
                }
            break;
            
            
            case "promocion":
                NPaquete npaquete = new NPaquete();
                switch(accion){
                    case "listar":
                        result = npaquete.Listar();
                        break;
                    case "registrar":
                        npaquete.Registrar(att);
                        result = "Se registro promocion correctamente :D";
                        break;
                    case "modificar":
                        npaquete.Modificar(att);
                        result = "Se modifico el promocion correctamente :'D";
                        break;
                    case "eliminar":
                        npaquete.Eliminar(att);
                        result = "Se elimino el promocion correctamente :(";
                        break;
                }
                break;
            case "usuario-paciente":
                NPaciente npaciente = new NPaciente();
                switch(accion){
                    case "ver":
                        result = npaciente.Ver(att);
                        break;
                    case "listar":
                        result = npaciente.Listar();
                        break;
                    case "registrar":
                        npaciente.Registrar(att);
                        result = "Se registro paciente correctamente :D";
                        break;
                    case "modificar":
                        npaciente.Modificar(att);
                        System.out.println("paso por modificar");
                        result = "Se modifico el paciente correctamente :'D";
                        break;
                    case "eliminar":
                        npaciente.Eliminar(att);
                        result = "Se elimino el paciente correctamente :(";
                        break;
                }
                
        }
        return result;
    }
    
}
