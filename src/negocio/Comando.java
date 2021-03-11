/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.SQLException;
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
    private final String[] listaCu = {
        "usuario-paciente","usuario-trabajador","local",
        "servicio","equipamiento","promocion","consulta",
        "citamedica","skintest","estadistica","reporte",
        "manual-usuario"
    };
    private final String[] listaAcciones = {
        "ver","listar","registrar",
        "modificar","eliminar","show","help"
    };
    
    public Comando(){ this.Atributos = new ArrayList<>(); }
    
    public String getCu(){ return this.Cu; }
    public String getAccion(){ return this.Accion; }
    public List<String> getAtributos(){ return this.Atributos; }
    public void setCu(String cu){ this.Cu = cu; }
    public void setAccion(String accion){ this.Accion = accion; }
    public void setAtributos(List<String> atributos){ this.Atributos = atributos; }
    
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
        }else{
            setCu("manual-usuario");
            setAccion("help");
            System.out.println("NO existe el comando:/");
        }
            
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
                            + "------------------------------------------------------------------------------------------------------------\n"
                            + "-----------------------------------------------MANUAL USUARIO-----------------------------------------------\n"
                            + "------------------------------------------------------------------------------------------------------------\n"
                            + "\n \n"
                            + "DATOS A CONSIDERAR: "
                            + "1. LOS COMANDOS INICIAN Y TERMINAN CON ESTOS SIMBOLOS (MENOR Y MAYOR) '< >' \n"
                            + "2. EN LOS DATOS, AL MOMENTO DE REGISTRAR O MODIFICAR, NO PUEDEN HABER ESPACIOS ENTRE LAS PALABRAS\n"
                            + "3. LOS ATRIBUTOS EMPIEZAN DESPUES DEL ULTIMO (GUION BAJO) '_' Y SE SEPARAN ENTRE SI POR (COMAS) ','\n"
                            + "4. SE PUEDEN UTILIZAR LOS SIGUIENTES SIMBOLOS EN VEZ DEL ESPACIO ENTRE PALABRAS:\n"
                            + "  '.' PUNTO \n"
                            + "  '/' SLASH\n"
                            + "\n \n"
                            + "----------------------------- \n"
                            + "USUARIO-PACIENTE\n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "Introducir  dato     id\n"
                            + "<USUARIO-PACIENTE_VER_1>\n \n"
                            + "Listar:\n"
                            + "<USUARIO-PACIENTE_LISTAR_ALL>\n \n"
                            + "Registrar:\n"
                            + "Introducir los datos       id, codigo, CI, nombre, nacionalidad, profesion, direccion, email, celular, edad,genero,fechaRegistro\n"
                            + "<usuario-paciente_REGISTRAR_103,P00101,0000000,karina,Bolivia,ingeniero,av./bush,kari@gmail.com,65412545,20,M,2021-01-02>\n \n"
                            + "Modificar:\n"
                            + "Introducir los datos       id, codigo, CI, nombre, nacionalidad, profesion, direccion, email, celular, edad,genero,fechaRegistro\n"
                            + "<usuario-paciente_modificar_103,p00101,0000000,karina,bolivia,ingeniero,av./bush,kari@gmail.com,65412545,20,m,2021-01-02>\n \n"
                            + "Eliminar:\n"
                            + "Introducir los datos       id\n"
                            + "< USUARIO-PACIENTE_ELIMINAR_1 > \n"
                            + "----------------------------- \n \n \n \n"
                            + "----------------------------- \n"
                            + "USUARIO-TRABAJADOR ..falta.. \n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "< USUARIO-TRABAJADOR_VER_1 >\n \n"
                            + "Listar:\n"
                            + "< USUARIO-TRABAJADOR_LISTAR_ALL >\n \n"
                            + "Registrar:\n"
                            + "< USUARIO-TRABAJADOR_REGISTRAR_COMPLETAR >\n \n"
                            + "Modificar:\n"
                            + "< USUARIO-TRABAJADOR_MODIFICAR_COMPLETAR >\n \n"
                            + "Eliminar:\n"
                            + "< USUARIO-TRABAJADOR_ELIMINAR_1 > \n"
                            + "----------------------------- \n \n \n \n"
                            + "----------------------------- \n"
                            + "SERVICIO ...falta...\n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "< SERVICIO_VER_1 >\n \n"
                            + "Listar:\n"
                            + "< SERVICIO_LISTAR_ALL >\n \n"
                            + "Registrar:\n"
                            + "< SERVICIO_REGISTRAR_COMPLETAR >\n \n"
                            + "Modificar:\n"
                            + "< SERVICIO_MODIFICAR_COMPLETAR >\n \n"
                            + "Eliminar:\n"
                            + "< SERVICIO_ELIMINAR_1 > \n"
                            + "----------------------------- \n \n \n \n"
                            + "----------------------------- \n"
                            + "RESERVA CITA MEDICA\n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "Introducir dato id\n"
                            + "<CITAMEDICA_VER_1>\n \n"
                            + "Listar:\n"
                            + "<CITAMEDICA_LISTAR_ALL>\n \n"
                            + "Registrar:\n"
                            + "Introducir los datos id,idPaciente,idtrabajador,codigoCita,hora,fecha,motivoConsulta,estadoTratamiento\n"
                            + "<CITAMEDICA_REGISTRAR_501,1,1,RC0001,14:30:00,2021-08-25,dolores,proceso> \n \n"
                            + "Modificar:\n"
                            + "<CITAMEDICA_MODIFICAR_501,1,1,RC0001,14:20:00,021-08-25,molestia,iniciando>\n \n"
                            + "Eliminar:\n"
                            + "<CITAMEDICA_ELIMINAR_1> \n"
                            + "----------------------------- \n \n \n \n"
                            + "----------------------------- \n"
                            + "EQUIPAMIENTO ...falta...\n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "< EQUIPAMIENTO_VER_1 >\n \n"
                            + "Listar:\n"
                            + "< EQUIPAMIENTO_LISTAR_ALL >\n \n"
                            + "Registrar:\n"
                            + "< EQUIPAMIENTO_REGISTRAR_COMPLETAR >\n \n"
                            + "Modificar:\n"
                            + "< EQUIPAMIENTO_MODIFICAR_COMPLETAR >\n \n"
                            + "Eliminar:\n"
                            + "< EQUIPAMIENTO_ELIMINAR_1 > \n"
                            + "----------------------------- \n \n \n \n"
                            + "----------------------------- \n"
                            + "CONSULTAS \n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "Introducir dato id\n"
                            + "<CONSULTA_VER_1>\n \n"
                            + "Listar:\n"
                            + "<CONSULTA_LISTAR_ALL>\n \n"
                            + "Registrar:\n"
                            + "Introducir los datos id,idCitaConsulta,idservicio,codigoConsulta,horaEntrada,horaSalida,fecha,precio,notas,diagnosticoFinal\n"
                            + "<CONSULTA_REGISTRAR_11,1,2,c0002,13:30:00,14:00:00,2021-08-22,100.00,mal.sueño,mucho.estress>\n \n"
                            + "Modificar:\n"
                            + "Introducir los datos id,idCitaConsulta,idservicio,codigoConsulta,horaEntrada,horaSalida,fecha,precio,notas,diagnosticoFinal\n"
                            + "<CONSULTA_MODIFICAR_11,1,2,c0002,13:30:00,14:00:00,2021-08-22,100.00,mal.sueño,mucho.estress>\n \n"
                            + "Eliminar:\n"
                            + "Introducir dato   id\n"
                            + "<CONSULTA_ELIMINAR_1> \n"
                            + "----------------------------- \n \n \n \n"
                            + "-----------------------------\n"
                            + "GESTIONAR SKINTEST ...falta...\n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "Introducir dato id\n"
                            + "< SKINTEST_VER_1 >\n \n"
                            + "Listar:\n"
                            + "< SKINTEST_LISTAR_ALL >\n \n"
                            + "Registrar:\n"
                            + "Introducir datoS   id,idConsulta,codigoTest,tratamientoDermatologico,cirugia,problemasSalud,fuma,actividadFisica,alergias,medicacion,afeccionPiel,hidratacion,observacionCosmetica \n"
                            + "<SKINTEST_REGISTRAR_4,3,T-0003,acne,ninguna,higado.graso,regularmente,no,ninguna,medicina.herbarea,acne,2.vasos/dia,acne.grado.2>\n \n"
                            + "Modificar:\n"
                            + "<SKINTEST_MODIFICAR_4,3,T-0003,acne,ninguna,higado.graso,regularmente,no,ninguna,medicina.herbarea,acne,2.vasos/dia,acne.grado.2>\n \n"
                            + "Eliminar:\n"
                            + "Introducir dato    id\n"
                            + "< SKINTEST_ELIMINAR_1 >\n"
                            + "----------------------------- \n \n \n \n"
                            + "-----------------------------\n"
                            + "PROMOCION\n"
                            + "-----------------------------\n"
                            + "Listar:\n"
                            + "< PROMOCION_LISTAR_ALL >\n \n"
                            + "Registrar:\n"
                            + "< PROMOCION_REGISTRAR_nombrepaquete,4,200.0 >\n \n"
                            + "Modificar:\n"
                            + "< PROMOCION_MODIFICAR_1,nombrepaquete,4,200.0 >\n \n"
                            + "Eliminar:\n"
                            + "< PROMOCION_ELIMINAR_1 >\n"
                            + "----------------------------- \n \n \n \n"
                            + "-----------------------------\n"
                            + "GESTIONAR CONSULTA Y ESTADISTICA ...falta...\n"
                            + "-----------------------------\n"
                            + "ver:\n"
                            + "< CONSULTA_VER_1 >\n \n"
                            + "Listar:\n"
                            + "< CONSULTA_LISTAR_ALL >\n \n"
                            + "Registrar:\n"
                            + "< CONSULTA_REGISTRAR_COMPLETAR >\n \n"
                            + "Modificar:\n"
                            + "< CONSULTA_MODIFICAR_COMPLETAR >\n \n"
                            + "Eliminar:\n"
                            + "< CONSULTA_ELIMINAR_1 >\n"
                            + "----------------------------- \n \n \n \n"
                            + "CERRAR SESION: < stop >"
                            + "\n"
                            + "\n";
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
            break;
            
            case "usuario-trabajdor":
                NegocioTrabajador ntrabajdor = new NegocioTrabajador();
                switch(accion){
                    case "ver":
                        //result = ntrabajdor.Ver(att);
                        break;
                    case "listar":
                        //result = ntrabajdor.Listar();
                        break;
                    case "registrar":
                        //ntrabajdor.Registrar(att);
                        result = "Se registro trabajador correctamente :D";
                        break;
                    case "modificar":
                        //ntrabajdor.Modificar(att);
                        System.out.println("paso por modificar");
                        result = "Se modifico el trabajador correctamente :'D";
                        break;
                    case "eliminar":
                        //ntrabajdor.Eliminar(att);
                        result = "Se elimino el trabajador correctamente :(";
                        break;
                }
            break;
                
            case "servicio":
                NServicio nservicio = new NServicio();
                switch(accion){
                    case "ver":
                        //result = NServicio.Ver(att);
                        break;
                    case "listar":
                        //result = NServicio.Listar();
                        break;
                    case "registrar":
                        //NServicio.Registrar(att);
                        result = "Se registro servicio correctamente :D";
                        break;
                    case "modificar":
                        //NServicio.Modificar(att);
                        System.out.println("paso por modificar");
                        result = "Se modifico el servicio correctamente :'D";
                        break;
                    case "eliminar":
                        //npaciente.Eliminar(att);
                        result = "Se elimino el servicio correctamente :(";
                        break;
                }
            break;   
                
            case "citamedica":
                NReservaCita ncitamedica = new NReservaCita();
                switch(accion){
                    case "ver":
                       result = ncitamedica.Ver(att);
                        break;
                    case "listar":
                        result = ncitamedica.Listar();
                        break;
                    case "registrar":
                        ncitamedica.Registrar(att);
                        result = "Se registro la reserva cita correctamente :D";
                        break;
                    case "modificar":
                        ncitamedica.Modificar(att);
                        System.out.println("paso por modificar");
                        result = "Se modifico la reserva cita correctamente :'D";
                        break;
                    case "eliminar":
                        ncitamedica.Eliminar(att);
                        result = "Se elimino la reserva cita correctamente :(";
                        break;
                }
            break;
                
            case "equipamiento":
                //NEquipamiento nequipamiento = new NEquipamiento();
                switch(accion){
                    case "ver":
                       //result = nequipamiento.Ver(att);
                        break;
                    case "listar":
                        //result = nequipamiento.Listar();
                        break;
                    case "registrar":
                        //nequipamiento.Registrar(att);
                        //result = "Se registro el equipamiento correctamente :D";
                        break;
                    case "modificar":
                        //nequipamiento.Modificar(att);
                        System.out.println("paso por modificar");
                        result = "Se modifico el equipamiento correctamente :'D";
                        break;
                    case "eliminar":
                        //nequipamiento.Eliminar(att);
                        result = "Se elimino el equipamiento correctamente :(";
                        break;
                }
            break;
            
            case "consulta":
                NConsulta nconsulta = new NConsulta();
                switch(accion){
                    case "ver":
                       result = nconsulta.Ver(att);
                        break;
                    case "listar":
                        result = nconsulta.Listar();
                        break;
                    case "registrar":
                        nconsulta.Registrar(att);
                        result = "Se registro la consulta correctamente :D";
                        break;
                    case "modificar":
                        nconsulta.Modificar(att);
                        System.out.println("paso por modificar");
                        result = "Se modifico la consulta correctamente :'D";
                        break;
                    case "eliminar":
                        nconsulta.Eliminar(att);
                        result = "Se elimino la consulta correctamente :(";
                        break;
                }
            break;
                
            case "skintest":
                NSkinTest nskintest = new NSkinTest();
                switch(accion){
                    case "ver":
                       result = nskintest.Ver(att);
                        break;
                    case "listar":
                        result = nskintest.Listar();
                        break;
                    case "registrar":
                        nskintest.Registrar(att);
                        result = "Se registro SkinTest correctamente :D";
                        break;
                    case "modificar":
                        nskintest.Modificar(att);
                        System.out.println("paso por modificar");
                        result = "Se modifico SkinTest correctamente :'D";
                        break;
                    case "eliminar":
                        nskintest.Eliminar(att);
                        result = "Se elimino SkinTest correctamente :(";
                        break;
                }
            break;
            
            case "promocion":
                NPaquete npaquete = new NPaquete();
                switch(accion){
                    case "ver":
                       //result = npaquete.Ver(att);
                       break;
                    
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
            
            case "reporte":
                NegocioReporte nreporte = new NegocioReporte();
                switch(accion){
                    case "listar":
                        result = nreporte.reporteAtencion();
                        break;
                }
            break;
                case "estadistica":
                NegocioEstadistica nestadistica = new NegocioEstadistica();
                switch(accion){
                    case "listar":
                        /*<ESTADISTICA_LISTAR_ALL>*/
                        String tmp = "";
        
                        tmp += nestadistica.mediaAtencionTotal();tmp += "\n";
                        tmp += nestadistica.mediaAtencionMes();tmp += "\n";
                        
                        tmp += nestadistica.mediaAtencionTotalHombres();tmp += "\n";
                        tmp += nestadistica.mediaAtencionMesHombres();tmp += "\n";
                        
                        tmp += nestadistica.mediaAtencionTotalMujeres();tmp += "\n";
                        tmp += nestadistica.mediaAtencionMesMujeres();tmp += "\n";
                        
                        result = tmp;
                        break;
                }
            break;
        }
        return result;
    }
     
     public static void main(String[] args) throws SQLException{
        Comando comando = new Comando();
        //String texto="USUARIO-PACIENTE_VER_1";
        //String texto = "usuario-paciente_REGISTRAR_103,P00101,0000000,karina,Bolivia,ingeniero,av./bush,kari@gmail.com,65412545,20,M,2021-01-02";
        String texto ="SKINTEST_REGISTRAR_3,3,T-0003,acne,ninguna,higado.graso,regularmente,no,ninguna,medicina.herbarea,acne,2.vasos/dia,acne.grado.2";
        
         System.out.println(""+comando.recogerDatos(texto));
         System.err.println("cu"+comando.getCu());
         System.err.println("accion"+comando.getAccion());
         System.err.println("atributos"+comando.getAtributos());
         //texto = "CONSULTA_REGISTRAR_12,1,2,c0002,13:30:00,14:00:00,2021-08-22,100.00,mal.sueño,mucho.estress"; 
        //System.out.println(""+comando.recogerDatos(texto));
        texto = "SKINTEST_LISTAR_ALL";
        System.out.println(""+comando.recogerDatos(texto));       
        
       
    } 
    
}
