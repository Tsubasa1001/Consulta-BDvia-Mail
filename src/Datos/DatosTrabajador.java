package Datos;

import Consultas_Mail.ClientePgSql;

/**
 *
 * @author eyver-dev
 */
public class DatosTrabajador {
    private ClientePgSql postgres;
    
    public DatosTrabajador() {
        this.postgres = new ClientePgSql();
    }
    
    public ClientePgSql getPostgres() {return postgres;}
    public void setPostgres(ClientePgSql postgres) {this.postgres = postgres;}
    
    public void index(String tabla){
        String sql;
        String query;
        
        sql = "select * from "+tabla+";";
        query = this.getPostgres().runStatement(sql);
        if (query.isEmpty()){
            query = "Resultado :: vacio";
            System.out.println(query);
        }else{
            query = query.replace(" ", "");
            System.out.println(query);
        }
    }
    
    public void create(
            String tabla, int codigo, String ci, String nombre,
            String nacionalidad, String especialidad, String cargo, String direccion,
            String ocupacion, String email, String celular, String edad, String genero,
            String fecha_creacion
    ){
        String sql;
        String query;
        
        sql = ""
                + "INSERT INTO "
                + tabla
                + " VALUES ('"
                + codigo
                + "', '"
                + ci
                + "', '"
                + nombre
                + "', '"
                + nacionalidad
                + "', '"
                + especialidad
                + "', '"
                + cargo
                + "', '"
                + ocupacion
                + "', '"
                + direccion
                + "', '"
                + email
                + "', '"
                + celular
                + "', "
                + edad
                + ", '"
                + genero
                + ", '"
                + fecha_creacion
                + "');";
        this.getPostgres().runStatement(sql);
        query = "create :: ok";
        System.out.println(query);
    }
    
    public void read(String tabla, int codigo){
        String sql;
        String query;
        sql = "select * from "+tabla+" where codigo = '"+codigo+"';";
        query = this.getPostgres().runStatement(sql);
        if (query.isEmpty()){
            query = "Resultado :: vacio";
            System.out.println(query);
        }else{
            query = query.replace(" ", "");
            System.out.println(query);
        }
    }
    
    public void update(
            String tabla, int codigo, String ci, String nombre,
            String nacionalidad, String especialidad, String cargo, String direccion,
            String ocupacion, String email, String celular, String edad, String genero,
            String fecha_creacion,
            String idViejo
    ){
        String sql;
        String query;
        
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
                + "', cargo = '"
                + cargo
                + "', ocupacion = '"
                + ocupacion
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
                + idViejo
                +"';";
        this.getPostgres().runStatement(sql);
        query = "update :: ok";
        System.out.println(query);
    }
    
    public void delete(String tabla, int codigo){
        String sql;
        String query;
        
        sql = "delete from "+tabla+" where codigo = '"+codigo+"';";
        this.getPostgres().runStatement(sql);
        query = "delete :: ok";
        System.out.println(query);
    }
}
