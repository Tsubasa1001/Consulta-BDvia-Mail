/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Consultas_Mail;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sariah
 */
public class ClienteSMTP {
    private String m_host;
    private int m_port;
    private static ClienteSMTP instance;
    
    private Socket m_socket;
    
    public ClienteSMTP(){
        this("mail.tecnoweb.org.bo", 25 );
    }
    public static synchronized ClienteSMTP getInstance(){
        if(instance == null){
            instance = new ClienteSMTP();
        }
        return instance;
    }
    public ClienteSMTP(String host, int port){
        this.m_host = host;
        this.m_port = port;
    }
        
    
    public boolean enviarCorreo(String sender, String receiver, String subject, String body) throws IOException{
        String command = "";
        String response = "";
        try{
            // conexión al puerto SMTP
            this.m_socket = new Socket(this.m_host, this.m_port);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(this.m_socket.getInputStream()));
            DataOutputStream salida = new DataOutputStream(this.m_socket.getOutputStream());

            if(this.m_socket != null && entrada != null && salida != null){
                System.out.println("[Server]: " + entrada.readLine());

                // send a command: "HELO ..."
                command = "HELO " + this.m_host + "\r\n";
                System.out.print("[Client]: " + command);
                salida.writeBytes(command);
                response = entrada.readLine();
                System.out.println("[Server]: " + response);
                if (!response.contains("250")) return false;
                
                // send a command: "MAIL FROM ..."
                command = "MAIL FROM: " + sender + "\r\n";
                System.out.print("[Client]: " + command);
                salida.writeBytes(command);
                response = entrada.readLine();
                System.out.println("[Server]: " + response);
                if (!response.contains("250")) return false;
                
                // send a command: "RCPT TO ..."
                command = "RCPT TO: " + receiver + "\r\n";
                System.out.print("[Client]: " + command);
                salida.writeBytes(command);
                response = entrada.readLine();
                System.out.println("[Server]: " + response);
                if (!response.contains("250")) return false;
                
                // send a command: "DATA ..."
                // step 1: send the DATA command
                command = "DATA\r\n"; // server should expect more commands after this one
                System.out.print("[Client]: " + command);
                salida.writeBytes(command);
                response = entrada.readLine();
                System.out.println("[Server]: " + response);
                if (!response.contains("354")) return false;
                // step 2: actually send the data :)
                // command = "SUBJECT: Hello, this is a test mail sent from a Java socket\n";
                command = subject + "\r\n" + body + "\r\n";
                command += ".\r\n";
                System.out.print("[Client]: " + command);
                salida.writeBytes(command);
                response = entrada.readLine();
                System.out.println("[Server]: " + response);
                if (!response.contains("250")) return false;
                
                // send a command: "QUIT ..."
                command = "QUIT\r\n";
                System.out.print("[Client]: " + command);
                salida.writeBytes(command);
                System.out.println("[Server]: " + entrada.readLine());
            }
            // closing data streams and client socket conn
            this.m_socket.close();
            entrada.close();
            salida.close();
            return true;
            
        }catch(Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    }
    
   /**
    * Permite procesar los mensajes multilinea del protocolo SMTP
    * @param in
    * @return 
    */
   static protected String getMultiline(BufferedReader in){
        String lines = "";
        while (true){
            try {
                String line = in.readLine();
                if (line == null){
                    // Server closed connection
                    throw new IOException("[Client]: Connection closed unexpectedly.");
                }
                if (line.charAt(3)==' '){
                    lines += "\n" + line;
                    // No more lines in the server response
                    break;
                }
                // Add read line to the list of lines
                lines += "\n" + line;
            } catch (IOException ex) {
                Logger.getLogger(ClienteSMTP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return lines;
    }
    
}
