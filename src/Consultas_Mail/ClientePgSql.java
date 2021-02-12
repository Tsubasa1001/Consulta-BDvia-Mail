/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Consultas_Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sariah
 */
public class ClientePgSql {
    private String m_host;
    private String m_port;      // usualmente 5432
    private String m_user;
    private String m_pass;
    private String m_database;
    
    private Connection m_conn;
    
    public ClientePgSql(){
        this(
            "tecnoweb.org.bo",
            "5432",
            "grupo05sa",
            "grupo05grupo05",
            "db_grupo05sa"
        );
    }
    public ClientePgSql(String host, String port, String user, String pass, String database){
        this.m_host = host;
        this.m_port = port;
        this.m_user = user;
        this.m_pass = pass;
        this.m_database = database;
        this.m_conn = null;
    }

    public String getM_host() {
        return m_host;
    }
    public void setM_host(String m_host) {
        this.m_host = m_host;
    }
    public String getM_port() {
        return m_port;
    }
    public void setM_port(String m_port) {
        this.m_port = m_port;
    }
    public String getM_user() {
        return m_user;
    }
    public void setM_user(String m_user) {
        this.m_user = m_user;
    }
    public String getM_pass() {
        return m_pass;
    }
    public void setM_pass(String m_pass) {
        this.m_pass = m_pass;
    }
    public String getM_database() {
        return m_database;
    }
    public void setM_database(String m_database) {
        this.m_database = m_database;
    }
    public Connection getM_conn() {
        return m_conn;
    }
    public void setM_conn(Connection m_conn) {
        this.m_conn = m_conn;
    }
    
    public String get_urlBD_postgres(){
        return "jdbc:postgresql://"+this.m_user+":"+this.m_pass+"@"+this.m_host+":"+this.m_port+"/"+this.m_database;
    }
    
    public String getConnString(){
        return "jdbc:postgresql://" + this.m_user + ":" + this.m_pass + "@"
                + this.m_host + ":" + this.m_port + "/" + this.m_database;
    }
    
    public Connection connect(){
        Connection conn = null;
        try{
            // conn = DriverManager.getConnection("jdbc:postgresql://mail.ficct.uagrm.edu.bo:5432/db_agenda", "agenda", "agendaagenda");
            conn = DriverManager.getConnection("jdbc:postgresql://"+this.m_host+":"+this.m_port+"/"+this.m_database, this.m_user, this.m_pass);
            //conn = DriverManager.getConnection(this.getConnString());
            System.out.println("Conectado exitosamente");
            this.m_conn = conn;
        }catch (SQLException sqlex){
            System.out.println("Error al conectar: " + sqlex.toString());
        }
        
        return conn;
    }
    
    public Connection getConnection(){
        return this.m_conn;
    }
    
    public String runStatement(String sqlQuery){
        // TODO: utilizar excepciones para controlar el caso "conn == null"
        String result = "";
        if(this.m_conn == null) result = "Aún no se ha conectado a un servidor SQL.";
        else{
            try{
                Statement statement = this.m_conn.createStatement();
                ResultSet rs = statement.executeQuery(sqlQuery);
                ResultSetMetaData rsmd = rs.getMetaData();
                int colCount = rsmd.getColumnCount();
                while(rs.next()){
                    for(int i = 1; i <= colCount; i++){
                        // System.out.print("|" + rs.getString(i) + "|,");
                        result += "|" + rs.getString(i) + "|,";
                    }
                    // System.out.println("\r\n");
                    result += "\r\n";
                }
            }catch(SQLException sqlEx){
                // System.out.println(sqlEx.toString());
                result = "Error: " + sqlEx.toString();
            }
        }
        return result;
    }
    
    public void desconectar(){
        try {
            this.getConnection().close();
        } catch (SQLException ex) {
            //Logger.getLogger(ClientePgSql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("error : desconectar");
        }
    }
}
