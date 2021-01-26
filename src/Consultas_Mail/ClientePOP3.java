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

/**
 *
 * @author Sariah
 */
public class ClientePOP3 {

    private String m_user;
    private String m_pass;
    private String m_host;
    private int m_port;

    private BufferedReader m_entrada;
    private DataOutputStream m_salida;

    private boolean isConnected;
    private boolean isLoggedIn;

    private Socket m_socket;

    /**
     * Constructor de oficio. Cuando se obvian todos los parámetros se asume que
     * se desea conectar al host de mail de la ficct, puerto 110, usuario y pass
     * para grupo15sa
     */
    public ClientePOP3() {
        this.m_user = "grupo07sc";
        this.m_pass = "grup007grup007";
        this.m_host = "tecnoweb.org.bo";
        this.m_port = 110;
    }

    /**
     * Constructor plenamente parametrizado
     *
     * @param user el usuario o casilla de correo
     * @param pass la contraseña del usuario o casilla de correo
     * @param host el host o servidor al cual conectarse, puede ser IP o nombre
     * de dominio
     * @param port el puerto al cual conectarse (POP3 normalmente funciona en el
     * puerto 110)
     */
    public ClientePOP3(String user, String pass, String host, int port) {
        this.m_user = user;
        this.m_pass = pass;
        this.m_host = host;
        this.m_port = port;

        this.isConnected = false;
        this.isLoggedIn = false;
    }

    /**
     * Constructor parcialmente parametrizado, solo pide user y pass, el resto
     * se asume que se desea conectar al servidor de la ficct en el puerto 110
     *
     * @param user
     * @param pass
     */
    public ClientePOP3(String user, String pass) {
        this(user, pass, "mail.tecnoweb.org.bo", 110);
    }

    public boolean conectar() {
        String resultado = "";
        try {
            //se establece conexion abriendo un socket especificando el servidor y puerto SMTP
            this.m_socket = new Socket(this.m_host, this.m_port);
            // preparacion de los streams de salida y entrada
            this.m_entrada = new BufferedReader(new InputStreamReader(this.m_socket.getInputStream()));
            this.m_salida = new DataOutputStream(this.m_socket.getOutputStream());
            resultado = this.m_entrada.readLine();
            //System.err.println("[Server]: " + m_entrada + "\r\n"); //java.io.BufferedReader@1554909b          
            //"OK Dovecot ready" significa que el servidor esta en la posibilidad de establecer conexion
            if (!resultado.contains("OK Dovecot ready")) {  
                return false;
            }
            this.isConnected = true;
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return this.isConnected;
    }

    public boolean iniciarSesion() {
        if (this.isConnected) {
            String result = "";
            String comando = "";
            //"\r\n" referencia maquina de escribir, r escribe y recorre hacian un lado. \n va saltando a la otra linea
            try {
                comando = "USER " + this.m_user + "\r\n"; 
                System.out.print("[Client]: " + comando);
                this.m_salida.writeBytes(comando);
                result = this.m_entrada.readLine();
                //System.out.println("[Server]: " + result + "\r\n");
                if (!result.contains("OK")) {
                    return false;
                }
                comando = "PASS " + this.m_pass + "\r\n";
                System.out.print("[Client]: " + comando);
                this.m_salida.writeBytes(comando);
                result = this.m_entrada.readLine();
                // System.out.println("[Server]: " + result + "\r\n");
                if (!result.contains("OK Logged in")) {
                    return false;
                }
                this.isLoggedIn = true;
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
        return this.isLoggedIn;
    }

    public boolean estaConectado() {
        return this.isConnected;
    }

    public boolean estaSesionIniciada() {
        return this.isLoggedIn;
    }

    public void cerrarCliente() {
        String comando = "";
        try {
            comando = "QUIT\r\n";
            // System.out.print("[Client]: " + comando);
            this.m_salida.writeBytes(comando);
            // System.out.println("[Server]: " + m_entrada.readLine() + "\r\n");
            // Cerrar los flujos de salida y de entrada y el socket cliente
            this.m_salida.close();
            this.m_entrada.close();
            this.m_socket.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public int contarCorreos() {
        String comando = "";
        String entrada = "";
        int resultado = -1;
        if (this.isConnected && this.isLoggedIn) {
            try {
                comando = "STAT\r\n";
                // System.out.print("[Client]: " + comando);
                this.m_salida.writeBytes(comando);
                entrada = this.m_entrada.readLine();
                // System.out.println("[Server]: " + entrada + "\r\n");
                /*System.out.println(entrada.substring(
                    entrada.indexOf(" ") + 1,
                    entrada.lastIndexOf(" ")
                ));*/
                int start = entrada.indexOf(" ") + 1;
                int end = entrada.lastIndexOf(" ");
                resultado = Integer.parseInt(entrada.substring(start, end));

            } catch (IOException ex) {
                System.out.println(ex.toString());
            }

            /*int mailCount = Integer.parseInt(resultado.substring(
                    resultado.lastIndexOf(" "),
                    resultado.indexOf(" ")
            ));*/
        }
        return resultado;
    }

    public String leerCorreo(int index) {
        String entrada = "~Nada para mostrar~";
        String comando = "";
        if (this.isLoggedIn) {
            try {
                comando = "RETR " + index + "\r\n";
                System.out.print("[Client]: " + comando);
                this.m_salida.writeBytes(comando);
                entrada = getMultiline(this.m_entrada);
                System.err.println("[Server]: " + entrada + "\r\n");
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }

        return entrada;
    }

    public String leerPrimerCorreo() {
        return leerCorreo(1);
    }

    public String leerUltimoCorreo() {
        return leerCorreo(contarCorreos());
    }

    public boolean borrarCorreo(int index) {
        String comando = "";
        String entrada = "";
        boolean resultado = false;
        if (this.isConnected && this.isLoggedIn) {
            try {
                comando = "DELE " + index + "\r\n";
                // System.out.print("[Client]: " + comando);
                this.m_salida.writeBytes(comando);
                entrada = this.m_entrada.readLine();
                // System.out.println("[Server]: " + entrada + "\r\n");

                if (entrada.contains("OK")) {
                    resultado = true;
                }

            } catch (IOException ex) {
                System.out.println(ex.toString());
            }

        }
        return resultado;
    }

    // Permite leer multiples lineas de respuesta del Protocolo POP
    static protected String getMultiline(BufferedReader in) throws IOException {
        String lines = "";
        while (true) {
            String line = in.readLine();
            if (line == null) {
                // Server closed connection
                throw new IOException("[Server]: Server unawares closed the connection.");
            }
            if (line.equals(".")) {
                break; // No more lines in the server response
            }
            if ((line.length() > 0) && (line.charAt(0) == '.')) {
                line = line.substring(1); // The line starts with a "." - strip it off.
            }
            lines = lines + "\n" + line; // Add read line to the list of lines
        }
        return lines;
    }
}
