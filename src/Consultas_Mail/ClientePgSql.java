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
    
    
}
