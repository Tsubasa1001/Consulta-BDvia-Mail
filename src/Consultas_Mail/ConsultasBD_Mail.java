/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas_Mail;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Comando;

/**
 *
 * @author Sariah
 */
public class ConsultasBD_Mail {
    public boolean bandera = false;

    /**
     * Clase misterio.
     */
    public class Consulta {
        public int m_index;
        public String m_query;
        public String m_user;
        public String m_result;
        public Consulta(String user, String query) {
            this.m_user = user;
            this.m_query = query;   
        }
    }

    /**
     * Guarda en una Lista las consultas que existen en la bandeja de entrada.
     * @param clientePop3
     * @return 
     */
    public List<Consulta> obtenerConsultas(ClientePOP3 clientePop3) {
        ArrayList<Consulta> listaConsultas = new ArrayList<>();

        // obtener consultas via POP3
        // ClientePOP3 cliente = new ClientePOP3();
        int cantCorreos = clientePop3.contarCorreos();
        System.out.println("Hay " + cantCorreos + " correos en el servidor. Procesando...");
        
        for (int i = 1; i <= cantCorreos; i++) {
            String correoActual = clientePop3.leerCorreo(i);
            //String consulta = getQueryStringCommand(correoActual);
            String consulta = getQueryString(correoActual);
            System.err.println("CONSULTA getQueryString: "+consulta);
            String remitente = getSender(correoActual);
            if (!consulta.equals("noquery") && !consulta.equals("nosubject")) {
                Consulta nuevaConsulta = new Consulta(remitente, consulta);
                listaConsultas.add(nuevaConsulta);

                // borrar este correo, ya fue atentido
                if (clientePop3.borrarCorreo(i)) {
                    System.out.println("Borrado el correo #" + i);
                } else {
                    System.out.println("Error al borrar el correo #" + i);
                }
            }else{
                Consulta nuevaConsulta = new Consulta(remitente, "manual-usuario_help_all"); 
                listaConsultas.add(nuevaConsulta);
                if (clientePop3.borrarCorreo(i)) {
                    System.out.println("Borrado el correo #" + i);
                } else {
                    System.out.println("Error al borrar el correo #" + i);
                }
            }
        }
        //////////
        //listaConsultas.add(new Consulta("grupo01sa@tecnoweb.org.bo", "'%Er%'"));
        //////////
        
        return listaConsultas;
    }

    /**
     * Trata de determinar si el texto del correo pasado por parámetro contiene
     * una consulta en su campo SUBJECT, utilizando como referencia el patron:
     * "en => ... *en*"
     *
     * Si el mail no tiene campo SUBJECT se devuelve la cadena "nosubject" Si no
     * se encuentra el patron especificado, se devuelve la cadena "noquery"
     *
     * @param correo
     * @return
     */
    public String getQueryString(String correo) {
        //String patron1 = "er => ";
        //String patron2 = "*en*"; 
        String patron1 = "<";
        String patron2 = ">";
        int subjectIndex = -1;/*-1 = valor inicial*/
        
        /*Procesando el mail_content*/
        correo = correo.toUpperCase();
        subjectIndex = correo.indexOf("SUBJECT: ");
        System.out.println("subjectIndex "+subjectIndex);
        
        if (subjectIndex < 0) {
            return "nosubject";
        }
        
        // recortar la linea "SUBJECT: "
        String subjectStr = correo.substring(subjectIndex).split("\\R")[0].trim();
        // determinar las posiciones de las cadenas del patron en la linea SUBJECT       
        subjectStr = subjectStr.toLowerCase();
        ////
        System.err.println("el subject " + subjectStr);
        ////     
        int inicio = subjectStr.indexOf(patron1);
        int fin = subjectStr.indexOf(patron2);
        
        System.err.println("INICIO-- " + inicio);
        System.err.println("FIN----- " + fin);
        
        // si alguna de las posiciones no es válida, retornar "noquery"
        if (inicio < 0 || fin < 0) {
            return "noquery";
        }

        // si todo salió bien, retornar la consulta encontrada
        return subjectStr.substring(inicio + patron1.length(), fin).trim();
    }
    
    /**
     * Obtener el correo de la persona que nos ha enviado el mail.
     * @param correo
     * @return 
     */
    public String getSender(String correo) {
        // este sería un buen momento para usar el patrón "Strategy" :v
        // e: ok no .v
        
        // estrategia anterior: usar el campo FROM
        // abandonada porque diferentes servicios de mail hacen lo que les da la gana con esto xD
        /*
        String patron = "From:";
        String senderStr = correo.substring(correo.indexOf(patron) + patron.length()).split("\\R")[0].trim();
        */
        
        String patron = "Return-Path:";
        String senderStr = correo
                .substring(correo.indexOf(patron) + patron.length())
                .split("\\R")[0]
                .replace("<", "")
                .replace(">", "")
                .trim();       

        return senderStr;
    }

    /**
     * Procesa las consultas pasadas por parámetro con el fin de ejecutar el
     * codigo SQL que contienen y almacenar la respuesta.
     *
     * @param listaConsultas Un ArrayList de consultas a procesar
     * @param clientePg
     */
    public void procesarConsultas(List<Consulta> listaConsultas, ClientePgSql clientePg) throws SQLException {
        for (Consulta consulta : listaConsultas) {
            // ClientePgSql clientePg = new ClientePgSql();
            clientePg.connect();
            if ("stop".equals(consulta.m_query)){
                this.bandera = true;
                consulta.m_result = "Has matado el programa :'v9";
            }else{
                
                if(clientePg.getM_conn()==null){
                    consulta.m_result = "Error del servidor al conectar con la BD";
                  }else{
                System.err.println("el patron => " + consulta.m_query);
                Comando comando = new Comando();
                consulta.m_result = comando.recogerDatos(consulta.m_query);
                //String sql = "select * from persona where per_nom like '%"+ consulta.m_query+"%'";
                //consulta.m_result = clientePg.runStatement(sql);
                }
            }
        }
    }
    
    /**
     * Se obtiene una lista de consultas SQL y envía las respuestas a una
     * casilla de correo dada a través del protocolo SMTP, al cual se conecta y
     * comunica a través de sockets y comandos de texto
     *
     * @param listaConsultas La lista de consultas a responder via SMTP
     * @param clienteSmtp
     */
    public void responderConsultas(List<Consulta> listaConsultas, ClienteSMTP clienteSmtp) throws InterruptedException {
        for (Consulta consulta : listaConsultas) {
            try {
                boolean couldSend = clienteSmtp.enviarCorreo(
                        "grupo06sc@tecnoweb.org.bo",
                        consulta.m_user,
                        "Resultado de su consulta SQL",
                        consulta.m_result
                );
                System.err.println("se respondio la consulta");
                if (!couldSend) break;
            } catch (IOException ex) {
                //System.out.println(ex.toString());
                System.err.println("error en la funcion :: responderConsultas");
            }
            sleep(5000);
        }
    }
    
    public void run() throws SQLException{
        // cliente POP3
        ClientePOP3 clientePop3 = new ClientePOP3(
                "grupo06sc",
                "grup006grup006",
                "tecnoweb.org.bo",
                110
            );
        ClienteSMTP clienteSmtp = new ClienteSMTP(
                "tecnoweb.org.bo",
                25
            );
        ClientePgSql clientePg = new ClientePgSql(
                "tecnoweb.org.bo",
                "5432",
                "grupo06sc",
                "grup006grup006",
                "db_grupo06sc"
            );
        

        clientePg.connect();
        

        // conectar cliente POP3
        //clientePop3.conectar();
        //clientePop3.iniciarSesion();

            
        // ciclo infinito esperando cada 5 segundos
        while (true) {
            clientePop3.conectar();
            clientePop3.iniciarSesion();
            if (clientePop3.estaSesionIniciada()){
                try {
                    // buscar consultas entre los correos disponibles
                    System.out.println("Buscando correos con consultas...");
                    List<Consulta> consultas = this.obtenerConsultas(clientePop3);
                    if (consultas.size() > 0) {
                        System.out.println(
                                "Se han encontrado "
                                        + consultas.size()
                                        + "consultas. Procesando..."
                        );
                        this.procesarConsultas(consultas,clientePg);
                        
                        this.responderConsultas(consultas, clienteSmtp);
                        System.out.println("Se ha finalizado el procesamiento. Saliendo...");
                    } else {
                        System.out.println("No se encontraron consultas. Saliendo...");
                    }
                    
                    /*1000 = 1 seg*/
                    sleep(5000);
                if (bandera){
                        System.err.println("[SYSTEM :: CERRANDO SESIÓN]");
                        break;
                    }
                    clientePop3.cerrarCliente();
                } catch (InterruptedException ex) {
                    //Logger.getLogger(ConsultasBD_Mail.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("error en la funcion :: run");
                }
            }else{
                System.out.println("No se ha podido iniciar sesión!");
            }
        }
        clientePop3.cerrarCliente();
    }

    public static void main(String[] args) throws SQLException{
        
        ConsultasBD_Mail gestor = new ConsultasBD_Mail();
        gestor.run();
    }
}

