
package Datos;

import Consultas_Mail.ClientePgSql;

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
        }else{
            resultado = resultado.replace(" ", "");
        }
        
        return resultado;
    }
    public void create(String tabla, int codigo, String ci, String nombre, String nacionalidad, String especialidad, String direccion, String email, String celular, String edad, String genero, String fecha_creacion){
        String sql = "";
        
        sql = ""
            + "INSERT INTO "+tabla+" VALUES ("
            + codigo+",'"
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
    public String read(String tabla, int codigo){
        String sql = "";
        String resultado = "";
        
        sql = "select * from "+tabla+" where codigo = '"+codigo+"';";
        this.getPostgres().connect();
        resultado = this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
        
        if (resultado.isEmpty()){
            resultado = "Resultado :: vacio";
        }else{
            resultado = resultado.replace(" ", "");
        }
        
        return resultado;
    }
    public void update(String tabla, int codigo, String ci, String nombre,String nacionalidad, String especialidad,String direccion, String email, String celular, String edad, String genero,String fecha_creacion,int codigoViejo){
        String sql = "";
        
        sql = ""
                + "update "
                + tabla
                + " set "
                + "codigo = '"
                + codigo
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
                + "' where codigo = '"
                + codigoViejo
                +"';";
        this.getPostgres().connect();
        this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
    }
    public void delete(String tabla, int codigo){
        String sql = "";
        
        sql = "delete from "+tabla+" where codigo = '"+codigo+"';";
        this.getPostgres().connect();
        this.getPostgres().runStatement(sql);
        this.getPostgres().desconectar();
    }
}
