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

    public ClientePgSql getPostgres() {
        return postgres;
    }
    public void setPostgres(ClientePgSql postgres) {
        this.postgres = postgres;
    }
    
    /**
     * Listar todas las peronas de la tabla.
     * @param tabla 
     */
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
    
    /**
     * Crear una nueva tupla.
     * @param tabla
     * @param id
     * @param ci
     * @param nombre
     * @param nacionalidad
     * @param especialidad
     * @param cargo
     * @param ocupacion
     * @param direccion
     * @param email
     * @param celular
     * @param edad
     * @param genero 
     */
    public void create(String tabla, String id, String ci,
            String nombre, String nacionalidad, String especialidad,
            String cargo, String ocupacion, String direccion,
            String email, String celular, int edad, String genero){
        
        String sql;
        String query;
        
        sql = ""
                + "INSERT INTO "
                + tabla
                + " VALUES ('"
                + id
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
                + "');";
        this.getPostgres().runStatement(sql);
        query = "create :: ok";
        System.out.println(query);
    }
    
    /**
     * 
     * @param tabla
     * @param id 
     */
    public void read(String tabla, String id){
        String sql;
        String query;
        sql = "select * from "+tabla+" where codigo = '"+id+"';";
        query = this.getPostgres().runStatement(sql);
        if (query.isEmpty()){
            query = "Resultado :: vacio";
            System.out.println(query);
        }else{
            query = query.replace(" ", "");
            System.out.println(query);
        }
    }
    
    /**
     * 
     * @param tabla
     * @param id
     * @param ci
     * @param nombre
     * @param nacionalidad
     * @param especialidad
     * @param cargo
     * @param ocupacion
     * @param direccion
     * @param email
     * @param celular
     * @param edad
     * @param genero
     * @param idViejo 
     */
    public void update(String tabla, String id, String ci, String nombre,
            String nacionalidad, String especialidad, String cargo, String ocupacion,
            String direccion, String email, String celular, int edad, String genero,
            String idViejo){
        String sql;
        String query;
        
        sql = ""
                + "update "
                + tabla
                + " set "
                + "codigo = '"
                + id
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
    
    /**
     * 
     * @param tabla
     * @param id 
     */
    public void delete(String tabla, String id){
        String sql;
        String query;
        
        sql = "delete from "+tabla+" where codigo = '"+id+"';";
        this.getPostgres().runStatement(sql);
        query = "delete :: ok";
        System.out.println(query);
    }
    
}
