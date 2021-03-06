
package Datos;

import Consultas_Mail.ClientePgSql;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author eyver-dev
 */
public class DatosUsuario {
    private ClientePgSql postgres;
    
    public DatosUsuario() {
        this.postgres = new ClientePgSql(
            "tecnoweb.org.bo",
            "5432",
            "grupo06sc",
            "grup006grup006",
            "db_grupo06sc"
        );
    }

    public ClientePgSql getPostgres() {return postgres;}
    public void setPostgres(ClientePgSql postgres) {this.postgres = postgres;}
    
    public String index(String tabla){
        String sql;
        String resultado;
        
        sql = "select * from "+tabla+";";
        this.getPostgres().connect();
        resultado = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        if (resultado.isEmpty()){
            resultado = "Resultado :: vacio";
        }
        
        return resultado;
    }
    public void create(String tabla, int id, String ci, String nombre, String nacionalidad, String especialidad, String direccion, String email, String celular, String edad, String genero, String fecha_creacion){
        String sql = "";
        
        sql = ""
            + "INSERT INTO "+tabla+" VALUES ("
            + id+",'"
            + ci+"','"
            + nombre+"','"
            + nacionalidad+"','"
            + especialidad+"','"
            + direccion+"','"
            + email+"','"
            + celular+"','"
            + edad+"','"
            + genero+"','"
            + fecha_creacion+"');";
        this.getPostgres().connect();
        this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
    }
    public String read(String tabla, int id){
        String sql = "";
        String resultado = "";
        
        sql = "select * from "+tabla+" where id = '"+id+"';";
        this.getPostgres().connect();
        resultado = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        if (resultado.isEmpty()){
            resultado = "Resultado :: vacio";
        }
        
        return resultado;
    }
    public void update(String tabla, int id, String ci, String nombre,String nacionalidad, String especialidad,String direccion, String email, String celular, String edad, String genero,String fecha_creacion,int idViejo){
        String sql = "";
        
        sql = ""
                + "update "
                + tabla
                + " set "
                + "id = '"
                + id
                + "', ci = '"
                + ci
                + "', nombre = '"
                + nombre
                + "', nacionalidad = '"
                + nacionalidad
                + "', especialidad = '"
                + especialidad
                + "', direccion = '"
                + direccion
                + "', email = '"
                + email
                + "', celular = '"
                + celular
                + "', edad = "
                + edad
                + ", genero = '"
                + genero
                + "' where id = '"
                + idViejo
                +"';";
        this.getPostgres().connect();
        this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
    }
    public void delete(String tabla, int id){
        String sql = "";
        
        sql = "delete from "+tabla+" where id = '"+id+"';";
        this.getPostgres().connect();
        this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
    }
}
